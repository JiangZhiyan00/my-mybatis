package com.jiangzhiyan.mybatis.session;

/**
 * 工厂模式接口,构建SqlSession的工厂
 */
public interface SqlSessionFactory {

    /**
     * 打开一个SqlSession
     */
    SqlSession openSession();
}
