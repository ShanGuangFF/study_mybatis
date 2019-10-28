package com.xupt.ff.dao.impl;

import com.xupt.ff.dao.IUserDao;
import com.xupt.ff.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class userDaoImpl implements IUserDao {

    private SqlSessionFactory factory;

    public userDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    public List<User> findAll() {

        //1.使用工厂创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //2.使用SqlSession执行方法
        List<User> userList = sqlSession.selectList("com.xupt.ff.dao.IUserDao.findAll");
        //3.返回查询结果
        sqlSession.close();
        return userList;
    }
}
