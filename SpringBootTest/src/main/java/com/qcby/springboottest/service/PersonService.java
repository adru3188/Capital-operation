package com.qcby.springboottest.service;

import com.qcby.springboottest.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();

    List<Person> login(Person person);
}
