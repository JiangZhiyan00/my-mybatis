package com.jiangzhiyan.mybatis.mapping;

import com.jiangzhiyan.mybatis.session.Configuration;
import com.jiangzhiyan.mybatis.type.JdbcType;

/**
 * 参数映射{property,javaType=int,jdbcType=NUMERIC}
 */
public class ParameterMapping {

    private Configuration configuration;

    private String property;

    private Class<?> javaType = Object.class;

    private JdbcType jdbcType;

    private ParameterMapping() {
    }

    public static class Builder {
        private ParameterMapping parameterMapping = new ParameterMapping();

        public Builder(Configuration configuration,String property) {
            parameterMapping.configuration = configuration;
            parameterMapping.property = property;
        }

        public Builder javaType(Class<?> javaType) {
            parameterMapping.javaType = javaType;
            return this;
        }

        public Builder jdbcType(JdbcType jdbcType) {
            parameterMapping.jdbcType = jdbcType;
            return this;
        }
    }
}
