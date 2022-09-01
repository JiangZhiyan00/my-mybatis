package com.jiangzhiyan.mybatis.test;

import com.jiangzhiyan.mybatis.test.po.User;
import org.junit.Test;

import java.sql.*;

public class JDBCTest {

    static {
        // 1.注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testJdbc() {
        String url = "jdbc:mysql://localhost:3306/my-mybatis?userUnicode=true&characterEncoding=utf-8&autoReconnect=true&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "jae7758521";
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            // 2.建立连接
            conn = DriverManager.getConnection(url, username, password);
            // 3.获取sql操作对象
            stat = conn.createStatement();
            String sql = "select id,userId,userName,userHead,createTime,updateTime from user;";
            // 4.执行sql
            rs = stat.executeQuery(sql);
            // 5.处理查询结果集
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUserId(rs.getString("userId"));
                user.setUserName(rs.getString("userName"));
                user.setUserHead(rs.getString("userHead"));
                user.setCreateTime(rs.getDate("createTime"));
                user.setUpdateTime(rs.getDate("updateTime"));
                System.out.println(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //6.关闭资源,遵循先后次序关闭
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
