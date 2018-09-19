package com.example.demo.activemq;

import com.example.demo.entity.City;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @program: Druid
 * @description:
 * @author: ChenYu
 * @create: 2018-09-19 17:51
 **/
@Component
public class Consumer {

    @JmsListener(destination = "Test")
    public void receiveQueue(String text){
        System.out.println("Consumer收到的报文为："+text);
    }

    /*
        JmsListener 注解可以重复  可以订阅多个
    * */

    @JmsListener(destination = "Test")
    @JmsListener(destination = "object")
    public void receiveQueue2(Object o) {
        System.out.println("Consumer2收到的报文为："+o);
//        System.out.println(o);
    }
}
