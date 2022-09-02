package com.jiangzhiyan.mybatis.test;

import com.jiangzhiyan.mybatis.binding.MapperProxyFactory;
import com.jiangzhiyan.mybatis.test.dao.IUserDao;
import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ApiTest {

    @Test
    public void mapperProxyTest() {
        MapperProxyFactory<IUserDao> mapperProxyFactory = new MapperProxyFactory<>(IUserDao.class);
        Map<String,String> sqlSession = new HashMap<>(2);
        sqlSession.put("com.jiangzhiyan.mybatis.test.dao.IUserDao.queryUserName", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户姓名");
        sqlSession.put("com.jiangzhiyan.mybatis.test.dao.IUserDao.queryUserAge", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户年龄");
        IUserDao userDao = mapperProxyFactory.newInstance(sqlSession);
        String res1 = userDao.queryUserName("1111");
        String res2 = userDao.queryUserAge("2222");
        int i = userDao.hashCode();
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(i);
    }

    @Test
    public void proxyClassTest() {
        IUserDao userDao = (IUserDao) Proxy.newProxyInstance(IUserDao.class.getClassLoader(),
                new Class[]{IUserDao.class}, (proxy, method, args) -> "你被代理了!");
        String result = userDao.queryUserName("10001");
        System.out.println("测试结果1:" + result);
        String res = userDao.queryUserAge("shajkdhsakl");
        System.out.println("测试结果2:" + res);
    }
}
