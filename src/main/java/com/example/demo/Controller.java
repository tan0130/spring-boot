package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by tan on 2018/6/12
 * 用于测试第一个spring-boot
 **/
@RestController
@RequestMapping("/demo")
public class Controller {
    /*@Value("${name}")
    private String name;
    @Value("${age}")
    private String age;
    @Value("${context}")
    private String context;*/

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello wold!!!! ...";
    }
}
