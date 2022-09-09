package com.jiangzhiyan.mybatis.binding;

import com.jiangzhiyan.mybatis.session.Configuration;
import com.jiangzhiyan.mybatis.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 映射器代理类
 */
public class MapperProxy<T> implements Serializable, InvocationHandler {

    private static final long serialVersionUID = 1234L;

    private SqlSession sqlSession;

    private final Class<T> mapperInterface;

    private final Map<Method,MapperMethod> methodCache;

    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface, Map<Method, MapperMethod> methodCache) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
        this.methodCache = methodCache;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this,args);
        } else {
            final MapperMethod mapperMethod = this.cacheMapperMethod(method);
            return mapperMethod.execute(sqlSession,args);
        }
    }

    /**
     * 去缓存中查找MapperMethod
     */
    private MapperMethod cacheMapperMethod(Method method) {
        MapperMethod mapperMethod = methodCache.get(method);
        if (mapperMethod == null) {
            // 找不到才去new
            mapperMethod = new MapperMethod(mapperInterface, method, sqlSession.getConfiguration());
            methodCache.put(method,mapperMethod);
        }
        return mapperMethod;
    }
}
