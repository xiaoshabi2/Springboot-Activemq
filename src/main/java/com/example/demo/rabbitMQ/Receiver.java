package com.example.demo.rabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: Druid
 * @description:
 * @author: ChenYu
 * @create: 2018-09-19 21:10
 **/
@RabbitListener(queues = "message")
@Component
public class Receiver {


    @RabbitHandler
    public void process(Object o) {
        System.out.println("接收成功");
        System.out.println(o);
    }
}
