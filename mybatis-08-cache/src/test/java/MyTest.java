import com.bantanger.dao.UserMapper;
import com.bantanger.pojo.User;
import com.bantanger.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/17 22:34
 */
public class MyTest {
    @Test
    public void queryUserByIdTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);

//        mapper.updateUser(new User(2, "aaaaa","bbbbb"));
        sqlSession.clearCache(); // 手动清理缓存
        System.out.println("=============");
        User user1 = mapper.queryUserById(1);
        System.out.println(user1);
        System.out.println(user==user1);
        sqlSession.close();
    }

    @Test
    public void queryUserByIdTest2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);
        sqlSession.close();
        // 注意二级缓存一定是作用于一级缓存死亡之后

        System.out.println("=============");

        User user1 = mapper2.queryUserById(1);
        System.out.println(user1);
        System.out.println(user==user1);
        sqlSession2.close();
    }
}
