package com.chen.manage.common.api;

import com.chen.manage.common.entity.Book;

public interface BookService {

    Book findById(Long id);

    Book findByName(String name);
}
