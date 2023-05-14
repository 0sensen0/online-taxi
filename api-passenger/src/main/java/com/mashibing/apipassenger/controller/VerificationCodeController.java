package com.mashibing.apipassenger.controller;

import com.mashibing.apipassenger.request.VerificationCodeDTO;
import com.mashibing.apipassenger.service.VerificationCodeService;
import com.mashibing.common.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationCodeController {
    @Autowired
    private VerificationCodeService verificationCodeService;


    @GetMapping("/verification-code")
    public ResponseResult verificationCode(@RequestBody VerificationCodeDTO input) {
        ResponseResult responseResult = verificationCodeService.generatorCode(input.getPassengerPhone());
        return responseResult.success(' ');
    }

    @PostMapping("/verification-code-check")
    public ResponseResult verificationCodeCheck(@RequestBody VerificationCodeDTO input) {
        String passengerPhone = input.getPassengerPhone();
        String verificationCode = input.getVerificationCode();
        ResponseResult responseResult = verificationCodeService.checkVerifiaction(passengerPhone, verificationCode);
        return responseResult;
    }

}
