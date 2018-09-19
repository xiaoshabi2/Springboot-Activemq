package com.example.demo.activemq;

import com.example.demo.entity.City;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.Destination;

/**
 * @program: Druid
 * @description:
 * @author: ChenYu
 * @create: 2018-09-19 17:53
 **/
@Controller
@RequestMapping
public class SendController {

    @Autowired
    private Producer producer;

    @ResponseBody
    @RequestMapping("/send")
    public Object send(){
        Destination destination = new ActiveMQQueue("Test");
        for (int i = 0; i < 10; i++) {
            producer.sendMessage(destination, "Hello World");
        }
        return "发送消息完成";
    }

    @ResponseBody
    @RequestMapping("/object")
    public Object sendInt(){
        Destination destination = new ActiveMQQueue("object");
        for (int i = 0; i < 10; i++) {
            producer.sendMessage(destination, new City(1,"name","introduce"));
        }
        return "发送消息完成";
    }

}
