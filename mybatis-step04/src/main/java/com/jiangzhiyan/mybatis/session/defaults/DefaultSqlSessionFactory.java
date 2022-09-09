package com.jiangzhiyan.mybatis.session.defaults;

import com.jiangzhiyan.mybatis.session.Configuration;
import com.jiangzhiyan.mybatis.session.SqlSession;
import com.jiangzhiyan.mybatis.session.SqlSessionFactory;

/**
 * 默认的SqlSessionFactory实现
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
