package com.xupt.ff.mybatis.io;

import java.io.InputStream;

/**
 * @author cc_ff
 * @creat 2019-10-2019/10/25-22:37
 * 使用类加载器读取配置文件的类
 */
public class mybatisResources {

    /**
     * 根据传入的参数，获取一个字节输入流
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath) {
        return mybatisResources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
