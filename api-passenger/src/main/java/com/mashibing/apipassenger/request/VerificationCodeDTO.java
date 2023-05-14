package com.mashibing.apipassenger.request;

import lombok.Data;

@Data
public class VerificationCodeDTO {
    String passengerPhone;

    String verificationCode;

}
