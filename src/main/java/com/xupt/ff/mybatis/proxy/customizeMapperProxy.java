package com.xupt.ff.mybatis.proxy;

import com.xupt.ff.mybatis.cfg.Mapper;
import com.xupt.ff.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * @author cc_ff
 * @create 2019-10-26 下午5:51
 * @action
 */
public class customizeMapperProxy implements InvocationHandler {

    //map的key是全限定类名+方法名称
    private Map<String, Mapper> mapperMap;
    private Connection conn;

    public customizeMapperProxy(Map<String, Mapper> mapperMap, Connection conn) {
        this.mapperMap = mapperMap;
        this.conn = conn;
    }


    /**
     * @action 用于对方法进行增强的，我们的增强其实就是调用selectList方法
     * @param proxy
     * @param method
     * @param objects
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {
        //1.获取方法名
        String methodName = method.getName();
        //2.获取方法所在类的名称
        String className = method.getDeclaringClass().getName();
        //3.组合key
        String key = className+"."+methodName;
        //4.获取mapperMap中的Mapper对象
        Mapper mapper = mapperMap.get(key);
        //5.判断是否有mapper
        if(mapper == null){
            throw new IllegalArgumentException("传入的参数有误");
        }
        //6.使用工具类查询所有
        return new Executor().selectList(mapper,conn);
    }
}
