package com.yonyou.stream.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

/**
 * 定义消费者
 * mxf
 * 2019年08月31日18:05:21
 */
@EnableBinding(RegChannel.class)
public class SendVerifyCodeService {
    @Autowired
    TemplateEngine templateEngine;

    @Autowired
    MailService mailService;

    @StreamListener(RegChannel.INPUT)
    public void sendVerifyCode(Map<String, Object> map) {
        //发送验证邮件和短信
        System.out.println("receive:" + map);
        Context ctx = new Context();
        String email = (String) map.get("email");
        ctx.setVariable("email", email);
        ctx.setVariable("code",(int)(Math.random()*10000));
        String mail = templateEngine.process("mailtemplate.html", ctx);
        mailService.sendHtmlMail("1563004690@qq.com",
                email,
                "欢迎注册XXX网站",
                mail);

    }

}
