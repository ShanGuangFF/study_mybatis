package com.xupt.ff.dao.impl;

import com.xupt.ff.dao.IUserDao;
import com.xupt.ff.domain.User;
import com.xupt.ff.domain.queryVo;
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

    @Override
    public void saveUser(User user) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.insert("com.xupt.ff.dao.IUserDao.saveUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateUser(User user) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.update("com.xupt.ff.dao.IUserDao.updateUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteUser(Integer userId) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.delete("com.xupt.ff.dao.IUserDao.deleteUser",userId);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public User findOne(Integer userId) {
        SqlSession sqlSession = factory.openSession();
        User selectOne = sqlSession.selectOne("com.xupt.ff.dao.IUserDao.findOne", userId);
        sqlSession.commit();
        sqlSession.close();
        return selectOne;
    }

    @Override
    public List<User> findByName(String name) {
        SqlSession sqlSession = factory.openSession();
        List<User> objects = sqlSession.selectList("com.xupt.ff.dao.IUserDao.findByName", name);
        sqlSession.commit();
        sqlSession.close();
        return objects;
    }

    @Override
    public int findTotal() {
        SqlSession sqlSession = factory.openSession();
        Integer one = sqlSession.selectOne("com.xupt.ff.dao.IUserDao.findTotal");
        sqlSession.commit();
        sqlSession.close();
        return one;
    }

    @Override
    public List<User> findByVo(queryVo vo) {
        SqlSession sqlSession = factory.openSession();
        List<User> list = sqlSession.selectList("com.xupt.ff.dao.IUserDao.findByVo",vo);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }
}
