package com.demo.controller;

import com.demo.entity.Person;
import com.demo.entity.User;
import com.demo.service.PersonService;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PersonService personService;

    @RequestMapping
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("test");
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("MasterPan" , 24, "changsha", new Timestamp(System.currentTimeMillis()), "remark"));
        personService.insertList(persons);
        return modelAndView;
    }

    @RequestMapping("test")
    @ResponseBody
    public List<User> getUsers() {
        return userService.selectAll();
    }
}
