package com.chen.nacosconfig.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;


@RefreshScope
@RestController
@RequestMapping("/yaml")
public class YamlController {

    @Value("${yaml.fruit:null}")
    String fruit;

    @Value("${swagger.enable:true}")
    String enable;

    @GetMapping("/fruit")
    public String testYaml(){
        return JSON.toJSONString(fruit);
    }

    @GetMapping("/enable")
    public String testEnable(){
        return JSON.toJSONString(enable);
    }



}

