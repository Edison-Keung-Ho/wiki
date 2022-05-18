package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.Demo;
import com.jiawa.wiki.service.DemoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: EdisonHo
 * Date: 2022/5/17
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Value("${demo.hello:Demo}")
    private String demoHello;


    @Resource
    private DemoService demoService;


    @GetMapping("/list1")
    public List<Demo> list() {
        return demoService.list();
    }
}
