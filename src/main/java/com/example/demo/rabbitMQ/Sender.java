package com.example.demo.rabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: Druid
 * @description:
 * @author: ChenYu
 * @create: 2018-09-19 21:09
 **/
@Component
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public String send(){
        String context = "简单消息发送";
        amqpTemplate.convertAndSend("message", context);
        System.out.println("发送成功");
        return "发送成功";
    }


}
