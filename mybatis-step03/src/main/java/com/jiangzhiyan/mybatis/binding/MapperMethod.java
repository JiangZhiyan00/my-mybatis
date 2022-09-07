package com.jiangzhiyan.mybatis.binding;

import com.jiangzhiyan.mybatis.mapping.MappedStatement;
import com.jiangzhiyan.mybatis.mapping.SqlCommandType;
import com.jiangzhiyan.mybatis.session.Configuration;
import com.jiangzhiyan.mybatis.session.SqlSession;

import java.lang.reflect.Method;

/**
 * 映射器方法
 */
public class MapperMethod {

    private final SqlCommand command;

    public MapperMethod(Class<?> mapperInterface,Method method,Configuration configuration) {
        this.command = new SqlCommand(configuration,mapperInterface,method);
    }

    public Object execute(SqlSession sqlSession, Object[] args) {
        Object result = null;
        switch (command.getType()) {
            case INSERT:
            case DELETE:
            case UPDATE:
                break;
            case SELECT:
                result = sqlSession.selectOne(command.getName(),args);
                break;
            default:
                throw new RuntimeException("Unknown execution method for: " + command.getName());
        }
        return result;
    }

    public static class SqlCommand {

        private final String name;

        private final SqlCommandType type;

        public SqlCommand(Configuration configuration, Class<?> mapperInterface, Method method) {
            String statementName = mapperInterface.getName() + "." + method.getName();
            MappedStatement ms = configuration.getMappedStatement(statementName);
            name = ms.getId();
            type = ms.getSqlCommandType();
        }

        public String getName() {
            return name;
        }

        public SqlCommandType getType() {
            return type;
        }
    }
}
