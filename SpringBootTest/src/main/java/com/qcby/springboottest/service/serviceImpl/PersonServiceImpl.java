package com.qcby.springboottest.service.serviceImpl;

import com.qcby.springboottest.dao.PersonDao;
import com.qcby.springboottest.model.Person;
import com.qcby.springboottest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public List<Person> findAll() {
        return this.personDao.findAll();
    }

    @Override
    public List<Person> login(Person person) {
        return this.personDao.login(person);
    }
}
