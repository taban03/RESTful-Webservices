package com.restservice.restfulwebservices.model;

public class HelloWorldBean {


    private String message;

    public HelloWorldBean(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage() {
        this.message = message;
    }
}
