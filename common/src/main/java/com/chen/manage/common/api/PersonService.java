package com.chen.manage.common.api;

import com.chen.manage.common.entity.Person;

public interface PersonService {

    Person findById(Long id);

    Person findByName(String name);


}
