package com.zhongba.sbrabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitConfig.Q_USER)
public class UserReceiver {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver User :" + hello);
    }
}
