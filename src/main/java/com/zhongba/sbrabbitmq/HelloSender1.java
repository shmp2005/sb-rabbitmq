package com.zhongba.sbrabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HelloSender1 {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String sendMsg = "hello1 " + new Date();
        System.out.println("Sender1 :" + sendMsg);
        rabbitTemplate.convertAndSend(RabbitConfig.Q_HELLO, sendMsg);
    }

    public void send(String msg) {
        System.out.println("Sender1 with msg :" + msg);
        rabbitTemplate.convertAndSend(RabbitConfig.Q_HELLO, msg);
    }

    public void sendUser(String msg) {
        System.out.println("SenderUser with msg :" + msg);
        rabbitTemplate.convertAndSend(RabbitConfig.Q_USER, msg);
    }
}
