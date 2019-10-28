package com.xupt.ff.mybatis.sqlSession.impl;

import com.xupt.ff.dao.IUserDao;
import com.xupt.ff.mybatis.cfg.Configuration;
import com.xupt.ff.mybatis.sqlSession.proxy.customizeMapperProxy;
import com.xupt.ff.mybatis.sqlSession.mybatisSqlSession;
import com.xupt.ff.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author cc_ff
 * @create 2019-10-26 下午5:13
 * @action sqlSession的实现类
 */
public class implMybatisSqlSession implements mybatisSqlSession {

    private Configuration cfg;
    private Connection conn;

    public implMybatisSqlSession(Configuration cfg) {
        this.cfg = cfg;
        this.conn = DataSourceUtil.getConnection(cfg);
    }


    /**
     * @acton 用于创建代理对象
     * @param daoInterfaceClass dao接口的字节码
     * @param <T>
     * @return
     */
    @Override
    public <T> T  getMapper(Class<T> daoInterfaceClass) {
        return(T) Proxy.newProxyInstance(
                daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},
                new customizeMapperProxy(cfg.getMappers(),conn)
        );

    }

    @Override
    public void close() {
        if(conn !=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
