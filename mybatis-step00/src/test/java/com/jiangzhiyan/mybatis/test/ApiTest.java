package com.jiangzhiyan.mybatis.test;

import com.jiangzhiyan.mybatis.test.dao.IActivityDao;
import com.jiangzhiyan.mybatis.test.dao.IUserDao;
import com.jiangzhiyan.mybatis.test.po.Activity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class ApiTest {

    @Test
    public void testSqlSessionFactory() throws Exception {
        // 1.读取mybatis配置文件,从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // 2.请求对象
        Activity activity = new Activity();
        activity.setActivityId(100001L);
        // 3.第一组
        // 3.1 开启Session
        SqlSession sqlSession01 = sqlSessionFactory.openSession();
        // 3.2获取映射器对象
        IActivityDao dao01 = sqlSession01.getMapper(IActivityDao.class);
        System.out.println("测试结果01:" + dao01.queryActivityById(activity));
        sqlSession01.close();

        // 4.第二组
        // 4.1 开启Session
        SqlSession sqlSession02 = sqlSessionFactory.openSession();
        IActivityDao dao02 = sqlSession02.getMapper(IActivityDao.class);
        System.out.println("测试结果02:" + dao02.queryActivityById(activity));
        sqlSession02.close();
    }

    @Test
    public void testSqlSessionFactoryAnnotation() throws IOException {
        // 1.读取mybatis配置文件,从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource-annotation.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // 2.开启session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3.获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        // 4.测试验证
        System.out.println(userDao.queryUserInfoList());
    }
}
