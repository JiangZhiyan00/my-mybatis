package com.jiangzhiyan.mybatis.session;

import com.jiangzhiyan.mybatis.builder.xml.XMLConfigBuilder;
import com.jiangzhiyan.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * 构建SqlSessionFactory的工厂
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return this.build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }
}
