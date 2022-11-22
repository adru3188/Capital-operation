package com.qcby.springboottest.model;

import org.springframework.stereotype.Component;

@Component
public class Dog {

    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
