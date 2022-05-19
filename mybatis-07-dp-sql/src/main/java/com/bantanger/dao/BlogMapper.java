package com.bantanger.dao;

import com.bantanger.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/30 22:14
 */
public interface BlogMapper {
    // 插入数据
    int addBook(Blog blog);

    // 查询博客
    List<Blog> queryBolgIF(Map map);

    // 查询博客
    List<Blog> queryBolgChoose(Map map);

    // 修改
    int updateBlog(Map map);

    // 查询部分博客
    List<Blog> queryBlogForeach(Map map);
}
