package com.demo.controller;

import com.demo.entity.Person;
import com.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping
    public ModelAndView index(ModelAndView modelAndView) {
        Person person = new Person(null, "admin", 24, "changsha", new Timestamp(System.currentTimeMillis()), "beizhu", new BigDecimal(12000.23));
        personService.insert(person);
        List<Person> persons = personService.find();
        modelAndView.setViewName("index");
        modelAndView.addObject("persons", persons);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("json")
    public List<Person> index() {
        return personService.find();
    }

}
