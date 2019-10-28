package com.xupt.ff.mybatis.sqlSession;



/**
 * @author cc_ff
 * @creat 2019-10-2019/10/25-23:06
 * 用于生产sqlSession对象
 */
public interface mybatisSqlSessionFactory {

    /**
     * 用于打开一个新的sqlSession对象
     * @return sqlSession
     */
    mybatisSqlSession openSession();
}
