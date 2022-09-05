package com.jiangzhiyan.mybatis.test;

import com.jiangzhiyan.mybatis.binding.MapperRegistry;
import com.jiangzhiyan.mybatis.session.SqlSession;
import com.jiangzhiyan.mybatis.session.SqlSessionFactory;
import com.jiangzhiyan.mybatis.session.defaults.DefaultSqlSessionFactory;
import com.jiangzhiyan.mybatis.test.dao.ISchoolDao;
import com.jiangzhiyan.mybatis.test.dao.IUserDao;
import org.junit.Test;

public class ApiTest {

    @Test
    public void testMapperProxyFactory() {
        // 1.注册Mapper
        MapperRegistry mapperRegistry = new MapperRegistry();
        mapperRegistry.addMappers("com.jiangzhiyan.mybatis.test.dao");

        // 2.从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(mapperRegistry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        ISchoolDao schoolDao = sqlSession.getMapper(ISchoolDao.class);

        // 4.测试验证
        String res1 = userDao.queryUserName("1234");
        System.out.println(res1);
        String res2 = schoolDao.querySchoolName("123");
        System.out.println(res2);
    }
}
