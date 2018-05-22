package com.demo.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.demo.entity.Person;
import com.demo.dao.PersonMapper;
import com.demo.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

    @Resource
    private PersonMapper personMapper;

    @Override
    public int insert(Person person){
        return personMapper.insert(person);
    }

    @Override
    public int insertSelective(Person person){
        return personMapper.insertSelective(person);
    }

    @Override
    public int insertList(List<Person> persons){
        return personMapper.insertList(persons);
    }

    @Override
    public int update(Person person){
        return personMapper.update(person);
    }
}
