package com.jiangzhiyan.mybatis.transaction.jdbc;

import com.jiangzhiyan.mybatis.session.TransactionIsolationLevel;
import com.jiangzhiyan.mybatis.transaction.Transaction;
import com.jiangzhiyan.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * JdbcTransaction工厂
 */
public class JdbcTransactionFactory implements TransactionFactory {

    @Override
    public Transaction newTransaction(Connection conn) {
        return new JdbcTransaction(conn);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource,level,autoCommit);
    }
}
