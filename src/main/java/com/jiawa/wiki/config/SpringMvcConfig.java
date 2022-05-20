//package com.jiawa.wiki.config;
//
//import com.jiawa.wiki.interceptor.LogInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//
//import javax.annotation.Resource;
//
///**
// * Author: EdisonHo
// * Date: 2022/5/19
// */
//
//@Configuration
//public class SpringMvcConfig {
//
//
//    @Resource
//    LogInterceptor logInterceptor;
//
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(logInterceptor)
//                .addPathPatterns("/**");
//
//    }
//}
