package com.xupt.ff.mybatis.sqlSession;



/**
 * @author cc_ff
 * @creat 2019-10-2019/10/25-23:12
 * 自定义Mybatis中和数据库交互的核心类
 *  它里面可以创建dao接口的代理对象
 */
public interface mybatisSqlSession {

    /**
     * 根据参数创建一个代理对象
     * @param <T>
     * @param daoInterfaceClass dao接口的字节码
     * @return
     */
    <T> T  getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
    void close();
}
