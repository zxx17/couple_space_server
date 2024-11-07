package com.zxx17.couple.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 *
 * @author Xinxuan Zhuo
 * @version 1.0.0
 * @since 2024/11/7
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String test(){
        return "success";
    }

}
