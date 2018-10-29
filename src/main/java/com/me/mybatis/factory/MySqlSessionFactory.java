package com.me.mybatis.factory;

import com.me.mybatis.dao.BlogDAO;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author OuyangJie
 * @Date 2018/10/29 11:21
 * @Description: 构建sqlSessionFactory
 *      1、使用xml
 *      2、不使用xml
 */
public class MySqlSessionFactory {

    public SqlSessionFactory getSqlSessionFactoryFromXml() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        Properties db = Resources.getResourceAsProperties("db.properties");
        PooledDataSourceFactory pooledDataSourceFactory = new PooledDataSourceFactory();
        pooledDataSourceFactory.setProperties(db);
        DataSource dataSource = pooledDataSourceFactory.getDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(BlogDAO.class);
        return new SqlSessionFactoryBuilder().build(configuration);
    }
}
