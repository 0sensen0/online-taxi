package com.mashibing.apipassenger.service;

import com.mashibing.apipassenger.remote.VerificationCodeServiceClient;
import com.mashibing.common.dto.ResponseResult;
import com.mashibing.common.response.NumberCodeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class VerificationCodeService {
    @Autowired
    private VerificationCodeServiceClient verificationCodeServiceClient;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    String numberCodePrefix = "NUMBER-CODE-";

    public ResponseResult generatorCode(String passengerPhone) {
        ResponseResult<NumberCodeResponse> numberCodeResponse = verificationCodeServiceClient.getNumberCode();
        NumberCodeResponse data = numberCodeResponse.getData();
        int numberCode = data.getNumberCode();
        System.out.println("接受到的验证码为:"+numberCode);
        stringRedisTemplate.opsForValue().set(numberCodePrefix + passengerPhone, numberCode + "", 2, TimeUnit.MINUTES);
        System.out.println("已经存入redis中");
        return  ResponseResult.success(' ');
    }
}
