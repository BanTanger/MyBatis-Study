package com.bantanger.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/30 22:12
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime; // 属性名和字段名不一致
    private int views;
}
