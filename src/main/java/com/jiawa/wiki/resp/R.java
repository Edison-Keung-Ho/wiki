package com.jiawa.wiki.resp;

import lombok.Data;

import java.io.Serializable;

@Data
public class R<T> implements Serializable {

    private boolean success = true; //编码：1成功，0和其它数字为失败

    private String message; //错误信息

    private T content; //数据

//    private Map map = new HashMap(); //动态数据

    public static <T> R<T> success(T object) {
        R<T> r = new R<T>();
        r.content = object;
        return r;
    }

    public static <T> R<T> error(String message) {
        R r = new R();
        r.message = message;
        r.success = false;
        return r;
    }

//    public R<T> add(String key, Object value) {
//        this.map.put(key, value);
//        return this;
//    }

}
