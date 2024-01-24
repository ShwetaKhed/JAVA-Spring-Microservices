package com.study.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.study.rest.webservices.restfulwebservices.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 10)
    private String desc;

    @ManyToOne(fetch = FetchType.LAZY)
    //Because we do not want this to be part of json responses
    @JsonIgnore
    private User user;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post(Long id, String desc) {
        this.id = id;
        this.desc = desc;
    }


    public Post() {
    }

    @Override
    public String   toString() {
        return "Post{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                '}';
    }
}
