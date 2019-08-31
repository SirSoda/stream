package com.yonyou.stream.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RegService {

    @Autowired
    RegChannel regChannel;

    public Map<String, Object> reg(String email, String phone, String password) {
        //数据写入数据库
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);
        map.put("phone", phone);
        regChannel.output().send(MessageBuilder.withPayload(map).build());
        map.put("msg", "验证短信已经发送，请注意查收！");
        return map;
    }
}
