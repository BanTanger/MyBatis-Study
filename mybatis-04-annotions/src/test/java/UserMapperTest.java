import bantanger.dao.UserMapper;
import bantanger.pojo.User;
import bantanger.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/28 17:57
 */
public class UserMapperTest {
    static SqlSession sqlSession = MybatisUtils.getSqlSession();
    static UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    @Test
    public void test(){
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void test1(){
        User userByID = mapper.getUserByID(6, "半糖");
        System.out.println(userByID);
    }

    public static void function(){
        // 调用查询所有用户的SQL语句，查看是否添加成功
        for (User user : mapper.getUsers()) {
            System.out.println(user);
        }
    }

    @Test
    public void addUserTest(){
        int cc = mapper.addUser(new User(4, "小城", "1234"));
        if(cc > 0) {
            System.out.println("事务提交成功");
            function();
        }
        // 这里把MybatisUtils工具类里的openSession打开了，不需要再设置commit提交事务了
    }

    @Test
    public void updateUserTest(){
        int mi = mapper.updateUser(new User(5, "小米", "741852"));
        if (mi > 0){
            System.out.println("事务提交成功");
            function();
        }
    }

    @Test
    public void deleteUserTest(){
        int i = mapper.deleteUser(6);
        if(i > 0) {
            System.out.println("事务提交成功");
            function();
        }
    }
}
