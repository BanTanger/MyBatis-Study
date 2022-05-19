package com.bantanger.dao;

import com.bantanger.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/17 22:21
 */
public interface UserMapper {
    // 通过id查询用户信息
    User queryUserById(@Param("id") int id);

    // 修改用户
    int updateUser(User user);
}
