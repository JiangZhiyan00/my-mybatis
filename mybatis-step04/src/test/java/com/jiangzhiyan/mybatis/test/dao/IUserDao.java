package com.jiangzhiyan.mybatis.test.dao;

import com.jiangzhiyan.mybatis.test.po.User;

public interface IUserDao {

    User queryUserInfoById(Long uId);
}
