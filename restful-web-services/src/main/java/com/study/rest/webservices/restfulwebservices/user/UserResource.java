package com.study.rest.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
public class UserResource {

    private UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping(path = "/users")
    public List<User> getUsers()
    {
        return this.userDaoService.findAll();
    }

    @GetMapping(path = "/getUsers/{id}")
    public User getUserById(@PathVariable int id)
    {
        User user = this.userDaoService.find(id);
        if (user == null){
            throw new UserNotFoundException("id: " + id);
        }
        return user;
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User newUser = this.userDaoService.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();

        return ResponseEntity.created(location).body(user);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteUser(@PathVariable int id)
    {
        this.userDaoService.delete(id);

    }


    // Hate oas
    @GetMapping(path = "/retrieveUsers/{id}")
    public EntityModel<User> retrierveUserById(@PathVariable int id)
    {
        User user = this.userDaoService.find(id);
        if (user == null){
            throw new UserNotFoundException("id: " + id);
        }

        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getUsers());
        entityModel.add(link.withRel("all_users"));
        return entityModel;
    }


}
