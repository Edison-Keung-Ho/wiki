package com.jiawa.wiki.controller;

import com.jiawa.wiki.req.EbookReq;
import com.jiawa.wiki.resp.EbookResp;
import com.jiawa.wiki.resp.PageResp;
import com.jiawa.wiki.resp.R;
import com.jiawa.wiki.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    public R<PageResp<EbookResp>> list(EbookReq req) {

        return R.success(ebookService.list(req));
    }
}
