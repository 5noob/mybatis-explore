package com.me.mybatis.dao;

import com.me.mybatis.domain.Blog;
import com.me.mybatis.domain.LastName;
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
            Blog blog = new Blog(3, "赵三", LastName.ZHAO, LastName.ZHAO);
            int i = blogDAO.insertBlog(blog);
            Blog blog1 = blogDAO.selectBlogByXml(3);
            System.out.println(blog1);
            sqlsession.commit();
        }finally {
            sqlsession.close();
        }
    }

    @Test
    public void updateBlog() throws IOException {
        MySqlSessionFactory mySqlSessionFactory = new MySqlSessionFactory();
        SqlSession sqlsession = mySqlSessionFactory.getSqlSessionFactoryFromXml().openSession();
        Blog blog = new Blog(3, "李立", LastName.LI, LastName.LI);
        try{
            BlogDAO blogDAO = sqlsession.getMapper(BlogDAO.class);
            int i = blogDAO.updateBlog(blog);
            sqlsession.commit();
        }finally {
            sqlsession.close();
        }
    }
}