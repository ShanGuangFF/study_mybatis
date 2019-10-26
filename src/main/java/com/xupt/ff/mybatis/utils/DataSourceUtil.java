package com.xupt.ff.mybatis.utils;

import com.xupt.ff.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author cc_ff
 * @create 2019-10-26 下午6:14
 * @action 创建数据源的工具类
 */
public class DataSourceUtil {

    public static Connection getConnection(Configuration cfg) {
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
