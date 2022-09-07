package com.jiangzhiyan.mybatis.session.defualts;

import com.jiangzhiyan.mybatis.mapping.MappedStatement;
import com.jiangzhiyan.mybatis.session.Configuration;
import com.jiangzhiyan.mybatis.session.SqlSession;

/**
 * SqlSession默认实现类
 */
@SuppressWarnings("unchecked")
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了! " + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T) ("你被代理了!" + "\n方法:" + statement + "\n入参:" + parameter + "\n待执行的SQL: " + mappedStatement.getSql());
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type,this);
    }
}
