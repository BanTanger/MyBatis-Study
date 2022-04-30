import bantanger.dao.UserMapper;
import bantanger.pojo.User;
import bantanger.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/28 17:28
 */
public class UserDaoTest {
    static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void getUserByLimitTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex", 1);
        map.put("pageSize", 2);
        List<User> userByLimit = mapper.getUserByLimit(map);
        for (User user : userByLimit) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void getUserTest() {
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");
    }
}
