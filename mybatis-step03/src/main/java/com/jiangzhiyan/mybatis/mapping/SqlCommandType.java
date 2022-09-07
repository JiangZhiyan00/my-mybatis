package com.jiangzhiyan.mybatis.mapping;

/**
 * SQL指令类型
 */
public enum SqlCommandType {

    /**
     * 未知
     */
    UNKNOWN,

    /**
     * 插入
     */
    INSERT,

    /**
     * 更新
     */
    UPDATE,

    /**
     * 查询
     */
    SELECT,

    /**
     * 删除
     */
    DELETE
}
