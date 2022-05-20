package com.jiawa.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiawa.wiki.domain.Ebook;
import com.jiawa.wiki.domain.EbookExample;
import com.jiawa.wiki.mapper.EbookMapper;
import com.jiawa.wiki.req.EbookReq;
import com.jiawa.wiki.resp.EbookResp;
import com.jiawa.wiki.resp.PageResp;
import com.jiawa.wiki.utils.CopyUtil;
import com.jiawa.wiki.utils.SnowFlake;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: EdisonHo
 * Date: 2022/5/18
 */

@Slf4j
@Service
public class EbookService {
    

    @Resource
    private EbookMapper ebookMapper;

    @Resource
    private SnowFlake snowFlake;

    public PageResp<EbookResp> list(EbookReq req){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();

        if(!ObjectUtils.isEmpty(req.getName()))
            criteria.andNameLike("%" + req.getName() + "%");
        
        PageHelper.startPage(req.getPage(),req.getSize());
        List<Ebook> ebooks = ebookMapper.selectByExample(ebookExample);

        List<EbookResp> ebookResps = ebooks.stream().map((item) -> {
            EbookResp ebookResp = CopyUtil.copy(item, EbookResp.class);
            return ebookResp;
        }).collect(Collectors.toList());


        PageInfo<EbookResp> ebookRespPageInfo = new PageInfo<>(ebookResps);
        log.info("总数目" + ebookRespPageInfo.getTotal());
        log.info("总页数" + ebookRespPageInfo.getPages());

        PageResp<EbookResp> ebookPageResp = new PageResp<>();
        ebookPageResp.setList(ebookResps);
        ebookPageResp.setTotal(ebookRespPageInfo.getTotal());
        return ebookPageResp;
    }

    public void save(Ebook ebook){
        if(ObjectUtils.isEmpty(ebook.getId())){
            ebook.setId(snowFlake.nextId());
            ebookMapper.insert(ebook);
        }else
            ebookMapper.updateByPrimaryKey(ebook);

    }


    public void delete(Long id){
        ebookMapper.deleteByPrimaryKey(id);

    }

}
