package com.chen.manage.bookservice.serviceimpl;


import com.chen.manage.common.api.BookService;
import com.chen.manage.common.entity.Book;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.concurrent.ThreadLocalRandom;

@DubboService
public class BookServiceImpl implements BookService {

    @Override
    public Book findById(Long id) {
        return Book.builder()
                .id(id)
                .name("1")
                .build();
    }

    @Override
    public Book findByName(String name) {
        return Book.builder()
                .id(ThreadLocalRandom.current().nextLong())
                .name(name)
                .build();
    }
}
