package com.demo.service;

import java.util.List;
import com.demo.entity.Person;
public interface PersonService{

    int insert(Person person);

    int insertSelective(Person person);

    int insertList(List<Person> persons);

    int update(Person person);
}
