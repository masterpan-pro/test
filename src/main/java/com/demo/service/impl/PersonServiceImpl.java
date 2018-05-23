package com.demo.service.impl;

import com.demo.dao.PersonMapper;
import com.demo.entity.Person;
import com.demo.service.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonMapper personMapper;

    @Override
    @Transactional("txManager")
    public int insert(Person person) {
        return personMapper.insert(person);
    }

    @Override
    public int insertSelective(Person person) {
        return personMapper.insertSelective(person);
    }

    @Override
    public int insertList(List<Person> persons) {
        return personMapper.insertList(persons);
    }

    @Override
    public int update(Person person) {
        return personMapper.update(person);
    }

    @Override
    public List<Person> find() {
        return personMapper.find();
    }
}
