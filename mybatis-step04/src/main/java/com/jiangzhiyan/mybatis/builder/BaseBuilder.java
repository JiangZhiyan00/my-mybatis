package com.jiangzhiyan.mybatis.builder;

import com.jiangzhiyan.mybatis.session.Configuration;
import com.jiangzhiyan.mybatis.type.TypeAliasRegistry;

/**
 * 构建器的基类,建造者模式
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;

    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }
}
