package com.bantanger.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/29 17:24
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Teacher {
    private int id;
    private String name;
    private List<Student> students;
}
