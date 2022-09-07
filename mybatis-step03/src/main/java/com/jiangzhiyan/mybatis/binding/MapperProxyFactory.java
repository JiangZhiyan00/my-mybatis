package com.jiangzhiyan.mybatis.binding;

import com.jiangzhiyan.mybatis.session.SqlSession;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 映射器代理工厂
 */
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    private Map<Method,MapperMethod> methodCache = new ConcurrentHashMap<>();

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public Map<Method, MapperMethod> getMethodCache() {
        return methodCache;
    }

    @SuppressWarnings("unchecked")
    public T newInstance(SqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(),
                new Class[]{mapperInterface},new MapperProxy<>(sqlSession, mapperInterface, methodCache));
    }

}
