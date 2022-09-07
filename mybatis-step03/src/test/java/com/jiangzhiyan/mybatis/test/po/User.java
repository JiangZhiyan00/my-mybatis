package com.jiangzhiyan.mybatis.test.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String userId;      // 用户ID
    private String userHead;    // 头像
    private Date createTime;    // 创建时间
    private Date updateTime;    // 更新时间
}
