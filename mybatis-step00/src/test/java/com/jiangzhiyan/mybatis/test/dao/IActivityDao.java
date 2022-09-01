package com.jiangzhiyan.mybatis.test.dao;

import com.jiangzhiyan.mybatis.test.po.Activity;

public interface IActivityDao {

    Activity queryActivityById(Activity activity);

    Integer insert(Activity activity);
}
