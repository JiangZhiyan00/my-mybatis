package com.jiangzhiyan.mybatis.test;

import com.jiangzhiyan.mybatis.io.Resources;
import com.jiangzhiyan.mybatis.session.SqlSession;
import com.jiangzhiyan.mybatis.session.SqlSessionFactory;
import com.jiangzhiyan.mybatis.session.SqlSessionFactoryBuilder;
import com.jiangzhiyan.mybatis.test.dao.IUserDao;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class ApiTest {

    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 1.从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2.获取映射器代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3.执行方法
        String res = userDao.queryUserInfoById("123");
        System.out.println("测试结果: " + res);
    }
}
