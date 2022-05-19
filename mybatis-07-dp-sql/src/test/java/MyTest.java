import com.bantanger.dao.BlogMapper;
import com.bantanger.pojo.Blog;
import com.bantanger.utils.IDutils;
import com.bantanger.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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

    @Test
    public void queryBolgIFTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<Object, Object> hashMap = new HashMap<>();
//        hashMap.put("title","Mybatis");
        hashMap.put("author","狂神说");

        List<Blog> blogs = mapper.queryBolgIF(hashMap);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }
    }

    @Test
    public void queryBolgChooseTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<Object, Object> hashMap = new HashMap<>();
//        hashMap.put("title","Mybatis");
        hashMap.put("author","狂神说");

        List<Blog> blogs = mapper.queryBolgChoose(hashMap);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }
    }

    @Test
    public void updateBlogTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap hashMap = new HashMap();
//        hashMap.put("title","Mybatis");
        hashMap.put("author","半糖先生");
        hashMap.put("id","6f9c5fc700eb44daaa382eacc097ee40");

        int blogs = mapper.updateBlog(hashMap);
    }

    @Test
    public void queryBlogForeachTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        List ids = new ArrayList();

        ids.add(2);
        ids.add(1);

        map.put("ids", ids);
        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
}
