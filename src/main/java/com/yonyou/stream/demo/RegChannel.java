package com.yonyou.stream.demo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 定义消息信道
 * mxf
 * 2019年08月31日18:02:58
 */
public interface RegChannel {
    String INPUT = "reg-input-channel";
    String OUTPUT = "reg-output-channel";

    @Output(OUTPUT)
    MessageChannel output();
    @Input(INPUT)
    SubscribableChannel input();
}
