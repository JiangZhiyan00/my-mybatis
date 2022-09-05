package com.jiangzhiyan.mybatis.binding;

import com.jiangzhiyan.mybatis.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 映射器代理类
 */
public class MapperProxy<T> implements Serializable, InvocationHandler {

    private static final long serialVersionUID = 121L;

    private SqlSession sqlSession;

    private final Class<T> mapperInterface;

    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this,args);
        } else {
            return sqlSession.selectOne(method.getName(),args);
        }
    }
}
