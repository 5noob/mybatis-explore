package com.me.mybatis.dao;

import com.me.mybatis.domain.Blog;
import org.apache.ibatis.annotations.Select;

/**
 * @author OuyangJie
 * @Date 2018/10/29 11:48
 * @Description:
 */

public interface BlogDAO {
    @Select("select * from blog where id = #{id}")
    Blog selectBlog(int id);

    Blog selectBlogByXml(int id);

    int insertBlog(Blog blog);

    int updateBlog(Blog blog);
}
