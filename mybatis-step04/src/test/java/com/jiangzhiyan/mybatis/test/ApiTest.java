package com.jiangzhiyan.mybatis.test;

import com.alibaba.fastjson.JSON;
import com.jiangzhiyan.mybatis.builder.xml.XMLConfigBuilder;
import com.jiangzhiyan.mybatis.io.Resources;
import com.jiangzhiyan.mybatis.session.Configuration;
import com.jiangzhiyan.mybatis.session.SqlSession;
import com.jiangzhiyan.mybatis.session.SqlSessionFactory;
import com.jiangzhiyan.mybatis.session.SqlSessionFactoryBuilder;
import com.jiangzhiyan.mybatis.session.defaults.DefaultSqlSession;
import com.jiangzhiyan.mybatis.test.dao.IUserDao;
import com.jiangzhiyan.mybatis.test.po.User;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class ApiTest {

    @Test
    public void test_selectOne() throws IOException {
        // 1.从xml获取Configuration
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        Configuration configuration = xmlConfigBuilder.parse();

        // 2.获取DefaultSqlSession
        SqlSession sqlSession = new DefaultSqlSession(configuration);

        // 3.执行查询
        Object[] req = {2L};
        Object res = sqlSession.selectOne("com.jiangzhiyan.mybatis.test.dao.IUserDao.queryUserInfoById", req);
        System.out.println("测试结果: " + JSON.toJSONString(res));
    }

    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 1.从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2.获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3.测试查询验证
        User user = userDao.queryUserInfoById(2L);
        System.out.println("测试结果: " + JSON.toJSONString(user));
    }
}
