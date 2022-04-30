package bantanger.dao;

import bantanger.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/28 17:22
 */
public interface UserMapper {

    // 接口
    List<User> getUserByLimit(Map<String, Integer> map);
}
