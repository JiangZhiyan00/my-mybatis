package com.jiangzhiyan.mybatis.session;

/**
 * SqlSession 用来执行sql,获取映射器,管理事务
 * 通常情况下,我们在应用程序中使用的Mybatis的API就是这个接口定义的方法.
 */
public interface SqlSession {

    /**
     * 根据指定的sqlID获取一条记录的封装对象
     * @param statement sqlId
     * @return 封装后的对象
     * @param <T> 封装后的对象类型
     */
    <T> T selectOne(String statement);

    /**
     * 根据指定的sqlId获取一条记录的封装对象,这个方法可以给sql传递一些参数
     * 一般在实际使用中,这个参数传递的pojo,或者是Map或ImmutableMap
     * @param <T>       the returned object type
     * @param statement Unique identifier matching the statement to use.
     * @param parameter A parameter object to pass to the statement.
     * @return Mapped object
     */
    <T> T selectOne(String statement, Object parameter);

    /**
     * 获取映射器
     * @param <T>  the mapper type
     * @param type Mapper interface class
     * @return a mapper bound to this SqlSession
     */
    <T> T getMapper(Class<T> type);
}
