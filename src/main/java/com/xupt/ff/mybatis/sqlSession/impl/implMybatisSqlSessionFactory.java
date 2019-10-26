package com.xupt.ff.mybatis.sqlSession.impl;

import com.xupt.ff.mybatis.cfg.Configuration;
import com.xupt.ff.mybatis.sqlSession.mybatisSqlSession;
import com.xupt.ff.mybatis.sqlSession.mybatisSqlSessionFactory;

/**
 * @author cc_ff
 * @create 2019-10-26 下午5:04
 * @action sqlSessionFactory的实现类
 */
public class implMybatisSqlSessionFactory implements mybatisSqlSessionFactory {

    private Configuration cfg;

    public implMybatisSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * @action 用于创建一个新的数据库操作对象
     * @return
     */
    @Override
    public mybatisSqlSession openSession() {
        return new implMybatisSqlSession(cfg);
    }
}
