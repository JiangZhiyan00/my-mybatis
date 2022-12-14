package com.jiangzhiyan.mybatis.session;

import com.jiangzhiyan.mybatis.binding.MapperRegistry;
import com.jiangzhiyan.mybatis.mapping.MappedStatement;

import java.util.HashMap;
import java.util.Map;

/**
 * 配置项
 */
public class Configuration {

    /**
     * 映射器注册机
     */
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    /**
     * 映射的语句,存在Map中
     */
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type,SqlSession sqlSession) {
        return mapperRegistry.getMapper(type,sqlSession);
    }

    public boolean hasMapper(Class<?> type) {
        return mapperRegistry.hasMapper(type);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(),ms);
    }

    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }
}
