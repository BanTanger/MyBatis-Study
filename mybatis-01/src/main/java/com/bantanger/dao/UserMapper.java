package com.bantanger.dao;

import com.bantanger.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/23 18:46
 */
public interface UserMapper {
    // 等效于后续SpringMVC里面用到的mapper
    List<User> getUserList();

    User getUserById(int id);

    int addUser(User user);
    // 万能的Map
    int addUserMap(Map<String,Object> map);

    int updateUser(User user);

    int deleteUser(int id);
}
