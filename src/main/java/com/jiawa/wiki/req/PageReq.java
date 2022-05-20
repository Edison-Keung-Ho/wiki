package com.jiawa.wiki.req;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * Author: EdisonHo
 * Date: 2022/5/20
 */
public class PageReq {

    @NotNull(message = "页码不能为空")
    private int page;

    @NotNull(message = "页数不能为空")
    @Max(value=1000,message = "最大页数不能超过1000")
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }


    @Override
    public String toString() {
        return "PageReq{" +
                "page=" + page +
                ", size=" + size +
                '}';
    }
}
