package com.test.service;

import com.demo.config.WebConfig;
import com.demo.entity.Person;
import com.demo.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebConfig.class })
@WebAppConfiguration
public class TestService {

    @Autowired
    private PersonService personService;

    @Test
    public void test () {
        List<Person> personList = personService.find();
        log.debug("{}", personList);
    }
}
