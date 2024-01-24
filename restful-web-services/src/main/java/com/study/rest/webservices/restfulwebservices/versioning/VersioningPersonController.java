package com.study.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("v1/person")
    public PersonV1 getFirstPerson(){
        return new PersonV1("Bob Char");
    }

    @GetMapping("v2/person")
    public PersonV2 getSecondPerson(){
        Name name = new Name("Shweta","K");
        return new PersonV2(name);
    }

    @GetMapping(path = "person", params = "version=1")
    public PersonV1 getFirstPersonUsingReqParam(){
        return new PersonV1("Bob Char");
    }

    @GetMapping(path = "person", params = "version=2")
    public PersonV2 getSecondPersonUsingReqParam(){
        Name name = new Name("Shweta","K");
        return new PersonV2(name);
    }

    @GetMapping(path = "person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstPersonUsingHeaders(){
        return new PersonV1("Bob Char");
    }

}
