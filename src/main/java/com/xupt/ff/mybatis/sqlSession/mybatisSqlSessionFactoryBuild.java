package com.xupt.ff.mybatis.sqlSession;

import com.xupt.ff.mybatis.cfg.Configuration;
import com.xupt.ff.mybatis.sqlSession.impl.implMybatisSqlSessionFactory;
import com.xupt.ff.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @author cc_ff
 * @creat 2019-10-2019/10/25-22:56
 * 用于创建一个sqlSessionFactory对象
 */
public class mybatisSqlSessionFactoryBuild {


    /**
     *
     * @param config
     * @return
     * @action 根据字节输入流来构建一个sqlSessionFactory工厂
     */
    public mybatisSqlSessionFactory build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new implMybatisSqlSessionFactory(cfg);
    };
}
