package com.chen.manage.controller;

import com.alibaba.fastjson.JSON;
import com.chen.manage.common.api.BookService;
import com.chen.manage.common.entity.Book;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/book")
public class BookController {

    @DubboReference
    BookService bookService;

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id){
        Book book = bookService.findById(ThreadLocalRandom.current().nextLong());
        return JSON.toJSONString(book);
    }

    @GetMapping("/")
    public String findByName(@RequestParam("name")String name){
        Book book = bookService.findByName(name);
        return JSON.toJSONString(book);
    }
}

