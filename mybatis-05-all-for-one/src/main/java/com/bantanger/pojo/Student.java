package com.bantanger.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/29 17:23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private int id;
    private String name;

    // 多对一，一个老师多个学生，所以在学生类里绑定老师类
    private Teacher teacher;
}
