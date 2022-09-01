package com.jiangzhiyan.mybatis.test.dao;

import com.jiangzhiyan.mybatis.test.po.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {

    @Select("select id,userId,userName,userHead,createTime,updateTime from user where id = #{id}")
    User queryUserInfo(User user);

    @Select("select id,userId,userName,userHead,createTime,updateTime from user")
    List<User> queryUserInfoList();
}
