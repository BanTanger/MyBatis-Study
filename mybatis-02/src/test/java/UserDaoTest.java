import com.bantanger.dao.UserMapper;
import com.bantanger.pojo.User;
import com.bantanger.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/23 19:09
 */
public class UserDaoTest {
    @Test
    public void test(){
        SqlSession sqlSession = null;
        try {
            // 1.获取SqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
            // 2.执行SQL
            //      --> 首先要拿到SQL:
            //          两种方式: 1. 通过getMapper(接口类名.class)获取
            //                   2. 通过XML配置文件获取
            //      但因为接口化编程的思想，我们应该采用方式1，也就是通过getMapper来获取
            com.bantanger.dao.UserMapper userDao = sqlSession.getMapper(com.bantanger.dao.UserMapper.class);// 通过获取接口类来得到Mapper（DAO）对象
            List<User> userList = userDao.getUserList();

            for (User user : userList) {
                System.out.println(user.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void getUserById(){
        SqlSession session = MybatisUtils.getSqlSession();

        com.bantanger.dao.UserMapper mapper = session.getMapper(com.bantanger.dao.UserMapper.class);

        User userById = mapper.getUserById(1);
        System.out.println(userById);

        session.close();
    }

    @Test
    public void addUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        com.bantanger.dao.UserMapper mapper = sqlSession.getMapper(com.bantanger.dao.UserMapper.class);
        int user = mapper.addUser(new User(6, "半糖", "123654"));

        if(user > 0) System.out.println("插入成功");

        // 提交事务【增删改都必须提交事务才行】
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void updateUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        com.bantanger.dao.UserMapper mapper = sqlSession.getMapper(com.bantanger.dao.UserMapper.class);
        int res = mapper.updateUser(new User(2, "王在小曼都", "654312"));
        if(res > 0) System.out.println("修改成功");

        // 提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void deleteUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        com.bantanger.dao.UserMapper mapper = sqlSession.getMapper(com.bantanger.dao.UserMapper.class);
        int i = mapper.deleteUser(3);

        if(i > 0) System.out.println("删除成功");

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUserMapTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        com.bantanger.dao.UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Object> map = new HashMap<>();
        // 键值要与xml里的一一对应
        map.put("userid",5);
        map.put("userName","牛批");
        map.put("passWord","1111111");
        int i = mapper.addUserMap(map);
        if(i > 0) System.out.println("增添成功");
        sqlSession.commit();
        sqlSession.close();
    }
}
