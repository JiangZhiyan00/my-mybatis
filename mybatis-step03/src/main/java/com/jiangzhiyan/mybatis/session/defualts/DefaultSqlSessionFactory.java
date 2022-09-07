package com.jiangzhiyan.mybatis.session.defualts;

import com.jiangzhiyan.mybatis.session.Configuration;
import com.jiangzhiyan.mybatis.session.SqlSession;
import com.jiangzhiyan.mybatis.session.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
