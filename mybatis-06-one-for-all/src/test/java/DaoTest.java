import com.bantanger.dao.TeacherMapper;
import com.bantanger.pojo.Teacher;
import com.bantanger.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/30 18:56
 */
public class DaoTest {
    @Test
    public void getTeacherTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Teacher teacher = sqlSession.getMapper(TeacherMapper.class).getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }
}
