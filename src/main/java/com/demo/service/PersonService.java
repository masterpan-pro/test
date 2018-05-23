package com.demo.service;

import com.demo.entity.Person;

import java.util.List;

public interface PersonService {

    int insert(Person person);

    int insertSelective(Person person);

    int insertList(List<Person> persons);

    int update(Person person);

    List<Person> find();
}
