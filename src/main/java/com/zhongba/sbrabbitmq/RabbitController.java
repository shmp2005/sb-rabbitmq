package com.zhongba.sbrabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    @Autowired
    private HelloSender1 helloSender1;

    @GetMapping("/hello")
    public void hello() {
        helloSender1.send();
    }

    @GetMapping("/oneToMany")
    public void oneToMany() {
        for (int i = 0; i < 10000; i++) {
            helloSender1.send("helloMsg: " + i);

        }
    }

    @GetMapping("/manyUser")
    public void manyUser() {
        for (int i = 0; i < 10000; i++) {
            helloSender1.sendUser("X user: " + i);
        }
    }

}
