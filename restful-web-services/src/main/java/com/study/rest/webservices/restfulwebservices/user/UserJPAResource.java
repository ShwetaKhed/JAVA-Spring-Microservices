package com.study.rest.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
public class UserJPAResource {

    private UserDaoService userDaoService;
    private UserRepository userRepository;

    private PostRepository postRepository;

    public UserJPAResource(UserDaoService userDaoService, UserRepository userRepository,
                           PostRepository postRepository) {
        this.userDaoService = userDaoService;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @GetMapping(path = "/jpa/users")
    public List<User> getUsers()
    {
        return this.userRepository.findAll();
    }

    @PostMapping("/jpa/addUser")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User newUser = this.userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();

        return ResponseEntity.created(location).body(user);
    }

    @DeleteMapping(path = "/jpa/delete/{id}")
    public void deleteUser(@PathVariable int id)
    {
        this.userRepository.deleteById(id);

    }


    // Hate oas
    @GetMapping(path = "/jpa/retrieveUsers/{id}")
    public EntityModel<User> retrierveUserById(@PathVariable int id)
    {
        Optional<User> user =  this.userRepository.findById(id);
        if (user.isEmpty()){
            throw new UserNotFoundException("id" + id);
        }
        EntityModel<User> entityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getUsers());
        entityModel.add(link.withRel("all_users"));
        return entityModel;
    }


    @GetMapping(path = "/jpa/users/{id}/post")
    public List<Post> retrievePostForUser(@PathVariable int id)
    {

        Optional<User> user = this.userRepository.findById(id);
        if (user == null)
        {
            throw new UserNotFoundException("id " + id);
        }

        return user.get().getPostList();

    }

    @PostMapping(path = "/jpa/users/{id}/createPost")
    public ResponseEntity<Object> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post)
    {

        Optional<User> user = this.userRepository.findById(id);
        if (user == null)
        {
            throw new UserNotFoundException("id " + id);
        }
        post.setUser(user.get());
        Post savedPost = postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }


}
