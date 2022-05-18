package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.Ebook;
import com.jiawa.wiki.service.EbookService;
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
@RequestMapping("/ebook")
public class EbookController {



    @Resource
    private EbookService ebookService;


    @GetMapping("/list")
    public List<Ebook> list() {
        return ebookService.list();
    }
}
