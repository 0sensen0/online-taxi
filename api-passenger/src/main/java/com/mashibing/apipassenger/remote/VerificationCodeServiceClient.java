package com.mashibing.apipassenger.remote;

import com.mashibing.common.dto.ResponseResult;
import com.mashibing.common.response.NumberCodeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("service-verificationcode")
public interface VerificationCodeServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "/verificationcodeNumer/6")
    ResponseResult<NumberCodeResponse> getNumberCode();

}
