package com.jiangzhiyan.mybatis.binding;

import cn.hutool.core.lang.ClassScanner;
import com.jiangzhiyan.mybatis.session.Configuration;
import com.jiangzhiyan.mybatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 映射器注册机
 */
public class MapperRegistry {

    private Configuration config;

    private final Map<Class<?>,MapperProxyFactory<?>> knownMappers = new HashMap<>();

    public MapperRegistry(Configuration config) {
        this.config = config;
    }

    @SuppressWarnings("unchecked")
    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if (mapperProxyFactory == null) {
            throw new RuntimeException("Type " + type + "is not know to the MapperRegistry.");
        }
        try {
            return mapperProxyFactory.newInstance(sqlSession);
        }catch (Exception e) {
            throw new RuntimeException("Error getting mapper instance. Cause: " + e, e);
        }
    }

    public void addMappers(String packageName) {
        Set<Class<?>> mapperSet = ClassScanner.scanPackage(packageName);
        for (Class<?> mapperClass : mapperSet) {
            this.addMapper(mapperClass);
        }
    }

    public void addMapper(Class<?> type) {
        if (type.isInterface()) {
            if (this.hasMapper(type)) {
                throw new RuntimeException("Type " + type + " is already known to the MapperRegistry.");
            }
        }
        knownMappers.put(type,new MapperProxyFactory<>(type));
    }

    public boolean hasMapper(Class<?> type) {
        return knownMappers.containsKey(type);
    }
}
