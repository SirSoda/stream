package com.yonyou.stream.mystream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(MyChannel.class)
public class MsgReceiver2 {
    @StreamListener(MyChannel.INPUT)
    public void receive(Object playload) {
        System.out.println("Received2:"+playload);
    }
}
