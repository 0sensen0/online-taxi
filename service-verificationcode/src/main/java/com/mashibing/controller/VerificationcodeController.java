package com.mashibing.controller;

import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationcodeController {
    @GetMapping("/verificationcodeNumer/{size}")
    public String verificationcodeNumber(@PathVariable("size") Integer size) {
        double number = ((Math.random() * 9) + 1) * Math.pow(10, size - 1);
        JSONObject result = new JSONObject();
        result.put("code", 200);
        result.put("message", "success");
        JSONObject data = new JSONObject();
        data.put("verificationNumber", (int) number);
        result.put("data", data);
        return result.toString();
    }
}
