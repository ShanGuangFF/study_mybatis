package com.xupt.ff.mybatis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author cc_ff
 * @create 2019-10-28 上午12:59
 * @action 自定义查询的注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface customizeSelect {

    /**
     * @action 配置Sql语句
     * @return
     */
    String value();
}
