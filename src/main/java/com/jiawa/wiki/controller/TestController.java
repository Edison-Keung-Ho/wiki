package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.Test;
import com.jiawa.wiki.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: EdisonHo
 * Date: 2022/5/17
 */
@RestController
public class TestController {

    @Value("${test.hello:Test}")
    private String testHello;


    @Resource
    private TestService testService;

//    @GetMapping("/hello")
//    public String Hello(){
//        return "hello" + testHello;
//    }



    @GetMapping("/test/list")
    public List<Test> list(){
        return testService.list();
    }
}
