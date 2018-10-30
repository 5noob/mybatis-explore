package com.me.mybatis.dao;

import com.me.mybatis.domain.Blog;
import com.me.mybatis.factory.MySqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;

/**
 * @author OuyangJie
 * @Date 2018/10/29 14:41
 * @Description:
 */
public class BlogDAOTest {

    @Test
    public void selectBlog() throws IOException {
        MySqlSessionFactory mySqlSessionFactory = new MySqlSessionFactory();
        SqlSession sqlsession = mySqlSessionFactory.getSqlSessionFactory().openSession();
        try{
            BlogDAO blogDAO = sqlsession.getMapper(BlogDAO.class);
            Blog blog = blogDAO.selectBlog(1);
            System.out.println(blog);
        }finally {
            sqlsession.close();
        }
    }

    @Test
    public void selectBlogByXml() throws IOException {
        MySqlSessionFactory mySqlSessionFactory = new MySqlSessionFactory();
        SqlSession sqlsession = mySqlSessionFactory.getSqlSessionFactoryFromXml().openSession();
        try{
            BlogDAO blogDAO = sqlsession.getMapper(BlogDAO.class);
            Blog blog = blogDAO.selectBlogByXml(1);
            System.out.println(blog);
        }finally {
            sqlsession.close();
        }
    }

    @Test
    public void insertBlog() throws IOException {
        MySqlSessionFactory mySqlSessionFactory = new MySqlSessionFactory();
        SqlSession sqlsession = mySqlSessionFactory.getSqlSessionFactoryFromXml().openSession();
        try{
            BlogDAO blogDAO = sqlsession.getMapper(BlogDAO.class);
            Blog blog = new Blog(3, "王二");
            // Junit的单元测试，默认回滚，所以没有插入值到数据库里面
            int i = blogDAO.insertBlog(blog);
            Blog blog1 = blogDAO.selectBlogByXml(3);
            System.out.println(blog1);
        }finally {
            sqlsession.close();
        }
    }
}