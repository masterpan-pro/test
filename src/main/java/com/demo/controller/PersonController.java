package com.demo.controller;

import com.demo.entity.Person;
import com.demo.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("index")
    public ModelAndView index(ModelAndView modelAndView) {
        Person person = new Person(null, "admin", 24, "changsha", new Timestamp(System.currentTimeMillis()), "beizhu", new BigDecimal(12000.23));
        personService.insert(person);
        List<Person> persons = personService.find();
        log.debug("persons:", persons);
        modelAndView.setViewName("index");
        modelAndView.addObject("persons", persons);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("json")
    public List<Person> index() {
        return personService.find();
    }

    @ResponseBody
    @RequestMapping("batI")
    public Integer batchInsert() {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            personList.add(
                    new Person(null, "admin" + i, 24, "changsha", new Timestamp(System.currentTimeMillis()), "beizhu" + i, new BigDecimal(12000.23))
            );
        }
        return personService.insertList(personList);
    }

    @RequestMapping("webjar")
    public ModelAndView webjar(ModelAndView modelAndView) {
        modelAndView.setViewName("webjar");
        return modelAndView;
    }

}
