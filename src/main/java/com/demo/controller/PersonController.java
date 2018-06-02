package com.demo.controller;

import com.demo.annotation.OperationLog;
import com.demo.entity.Log;
import com.demo.entity.Person;
import com.demo.service.LogService;
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

    @Autowired
    private LogService logService;

    @RequestMapping("index")
    public ModelAndView index(ModelAndView modelAndView) {
        Person person = new Person(null, "admin", 24, "changsha", new Timestamp(System.currentTimeMillis()), "beizhu", new BigDecimal(12000.23));
        personService.insert(person);
        List<Person> persons = personService.find();
        log.debug("{}", persons);
        modelAndView.setViewName("index");
        modelAndView.addObject("persons", persons);
        return modelAndView;
    }

    @OperationLog(description = "查询Person数据")
    @ResponseBody
    @RequestMapping("json")
    public List<Person> index() {
        return personService.find();
    }

    @ResponseBody
    @RequestMapping("log")
    public List<Log> log() {
        return logService.find();
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
        Person person = personService.findById(100052L);
        modelAndView.setViewName("webjar");
        modelAndView.addObject("person", person);
        log.debug("{}", person);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("delete")
    public List<Person> delete() {
        personService.deleteAll();
        return personService.find();
    }

}
