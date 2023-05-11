package com.mashibing.controller;

import com.mashibing.common.dto.ResponseResult;
import com.mashibing.common.response.NumberCodeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationcodeController {
    @GetMapping("/verificationcodeNumer/{size}")
    public ResponseResult verificationcodeNumber(@PathVariable("size") Integer size) {
        double number = ((Math.random() * 9) + 1) * Math.pow(10, size - 1);
        NumberCodeResponse response = new NumberCodeResponse();
        response.setNumberCode((int) number);
        return   ResponseResult.success(response);
    }
}
