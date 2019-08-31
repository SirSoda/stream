package com.yonyou.stream.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RegController {
    @Autowired
    RegService regService;
    @PostMapping("/doReg")
    public Map<String, Object> reg(String email, String phone, String password) {
        return regService.reg(email, phone, password);
    }
}
