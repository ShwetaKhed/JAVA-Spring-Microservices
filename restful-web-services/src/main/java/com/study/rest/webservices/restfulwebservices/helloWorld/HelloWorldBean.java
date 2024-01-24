package com.study.rest.webservices.restfulwebservices.helloWorld;

public class HelloWorldBean {
    private String message;

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HelloWorldBean(String message) {
        this.message = message;
    }
}
