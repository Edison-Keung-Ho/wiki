package com.jiawa.wiki.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: EdisonHo
 * Date: 2022/5/17
 */
@RestController
public class TestController {


    @GetMapping("/hello")
    public String Hello(){
        return "hello";
    }
}
