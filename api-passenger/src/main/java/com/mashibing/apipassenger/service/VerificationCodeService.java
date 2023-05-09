package com.mashibing.apipassenger.service;

import org.springframework.stereotype.Service;

@Service
public class VerificationCodeService {
    public String generatorCode(String passengerPhone) {
        System.out.println("接受到的电话号码为:"+passengerPhone);
        System.out.println("已经存入redis中");
        return "123456";
    }
}
