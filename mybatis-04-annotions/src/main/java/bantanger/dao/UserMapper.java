package bantanger.dao;

import bantanger.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/28 17:22
 */
public interface UserMapper {

    @Select("select * from mybatis.user")
    List<User> getUsers();

    // CRUD
    // 方法存在多个参数，必须前面添加@Param注解
    @Select("select * from mybatis.user where id = #{id} and name = #{name}")
    User getUserByID(@Param("id") int id,@Param("name") String name);

    // 增加用户
    @Insert("insert into user(id,name,pwd) values (#{id}, #{name}, #{password})")
    int addUser(User user);

    // 修改用户
    @Update("update user set name=#{name}, pwd=#{password} where id = #{id}")
    int updateUser(User user);

    // 删除用户
    @Delete("delete from user where id = #{uid}")
    int deleteUser(@Param("uid")int id);
}
