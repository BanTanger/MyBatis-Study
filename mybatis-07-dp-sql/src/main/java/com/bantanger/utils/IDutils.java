package com.bantanger.utils;

import org.junit.Test;

import java.util.UUID;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/30 22:15
 */



@SuppressWarnings("all")
public class IDutils {

    /**
     * 使用UUID封装方法将数据库中的id打乱，目的是安全和防止查询错误
     * @return
     */
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Test
    public void test(){
        System.out.println(getId());
        System.out.println(getId());
        System.out.println(getId());
    }


}
