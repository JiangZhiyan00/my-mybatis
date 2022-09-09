package com.jiangzhiyan.mybatis.session;

import java.sql.Connection;

/**
 * 事务的隔离级别
 * 包括JDBC支持的5个事务隔离级别
 */
public enum TransactionIsolationLevel {

    /**
     * 无事务
     */
    NONE(Connection.TRANSACTION_NONE),
    /**
     * 读已提交
     */
    READ_COMMITTED(Connection.TRANSACTION_READ_COMMITTED),
    /**
     * 读未提交
     */
    READ_UNCOMMITTED(Connection.TRANSACTION_READ_UNCOMMITTED),
    /**
     * 可重复读
     */
    REPEATABLE_READ(Connection.TRANSACTION_REPEATABLE_READ),
    /**
     * 序列化
     */
    SERIALIZABLE(Connection.TRANSACTION_SERIALIZABLE);

    private int level;

    TransactionIsolationLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
