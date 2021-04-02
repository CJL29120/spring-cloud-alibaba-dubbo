package com.chen.manage.controller;

import com.alibaba.fastjson.JSON;
import com.chen.manage.common.api.BookService;
import com.chen.manage.common.api.PersonService;
import com.chen.manage.common.entity.Book;
import com.chen.manage.common.entity.Person;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/person")
public class PersonController {

    @DubboReference
    PersonService personService;

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id){
        Person person = personService.findById(ThreadLocalRandom.current().nextLong());
        return JSON.toJSONString(person);
    }

    @GetMapping("/")
    public String findByName(@RequestParam("name")String name){
        Person person = personService.findByName(name);
        return JSON.toJSONString(person);
    }
}

