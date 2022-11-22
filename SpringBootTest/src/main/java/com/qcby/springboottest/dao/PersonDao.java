package com.qcby.springboottest.dao;

import com.qcby.springboottest.model.Person;

import java.util.List;

public interface PersonDao {
    List<Person> findAll();

    List<Person> login(Person person);
}
