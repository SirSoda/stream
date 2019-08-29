package com.yonyou.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class MsgReceiver {

    @StreamListener(Sink.INPUT)
    public void receive(Object msg) {
        System.out.println("received msg : " + msg);
    }
}
