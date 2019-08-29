package com.yonyou.stream.mystream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    MyChannel myChannel;

    @GetMapping("/test1")
    public void hello() {
        myChannel.output().send(MessageBuilder.withPayload("hello stream!").build());
    }
}
