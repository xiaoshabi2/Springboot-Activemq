package com.example.demo.controller;

import com.example.demo.annotation.NoRepeatSubmit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: Druid
 * @description:
 * @author: ChenYu
 * @create: 2018-09-19 15:14
 **/
@Controller
public class HelloWorld {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }

}
