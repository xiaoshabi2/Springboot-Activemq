package com.example.demo.activemq;

import javax.jms.Destination;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * @program: Druid
 * @description:
 * @author: ChenYu
 * @create: 2018-09-19 17:43
 **/
@Service
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(Destination destination, final Object message){
        jmsMessagingTemplate.convertAndSend(destination,message);
    }


}
