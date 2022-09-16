package com.lhao.bookdb.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Message
 * @Description :
 * @Author 小豪
 * @Date 2022/9/12 14:14
 * @Version 1.0
 **/
public class Message {

    private String code;

    private String message;

    private Map<String, Object> data = new HashMap<>();

    public Message() {
    }

    public static Message success() {
        Message message = new Message();
        message.code = "200";
        message.message = "匹配成功";
        return message;
    }

    public static Message fail() {
        Message message = new Message();
        message.code = "404";
        message.message = "匹配失败";
        return message;
    }

    public Message add(String key, Object obj) {
        this.data.put(key, obj);
        return this;
    }
}
