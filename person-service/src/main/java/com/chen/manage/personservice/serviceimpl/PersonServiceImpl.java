package com.chen.manage.personservice.serviceimpl;


import com.chen.manage.common.api.PersonService;
import com.chen.manage.common.entity.Person;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.concurrent.ThreadLocalRandom;

@DubboService()
public class PersonServiceImpl implements PersonService {

    @Override
    public Person findById(Long id) {
        return Person.builder()
                .id(id)
                .name("1")
                .build();
    }

    @Override
    public Person findByName(String name) {
        return Person.builder()
//                .id(ThreadLocalRandom.current().nextLong())
                .id(3L)
                .name(name)
                .build();
    }
}
