package com.example.demo.rabbitMQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Druid
 * @description:
 * @author: ChenYu
 * @create: 2018-09-19 21:11
 **/
@RestController
public class RabbitMQSendController {

    @Autowired
    private Sender sender;

    @GetMapping("/r/send")
    public String helloTest(){
        sender.send();
        return "success";
    }

}
