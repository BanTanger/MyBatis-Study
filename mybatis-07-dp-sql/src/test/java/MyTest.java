import com.bantanger.dao.BlogMapper;
import com.bantanger.pojo.Blog;
import com.bantanger.utils.IDutils;
import com.bantanger.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/30 22:29
 */
public class MyTest {
    @Test
    public void addBlogTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBook(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Java");
        mapper.addBook(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Spring");
        mapper.addBook(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("微服务");
        mapper.addBook(blog);

        sqlSession.close();
    }
}
