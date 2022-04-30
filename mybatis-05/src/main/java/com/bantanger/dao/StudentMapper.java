package com.bantanger.dao;

import com.bantanger.pojo.Student;
import com.bantanger.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/29 17:27
 */

public interface StudentMapper {

    public List<Student> getStudent();
}
