package com.xupt.ff.test;

import com.xupt.ff.dao.IUserDao;
import com.xupt.ff.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author cc_ff
 * @create 2019-11-05 下午4:52
 * @action
 */
public class IuserDaoTest {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private IUserDao iUserDao;

    @Before
    public void init()throws Exception{
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSession = new SqlSessionFactoryBuilder().build(inputStream).openSession();
        iUserDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws Exception{
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testfindALL(){
        List<User> userList = iUserDao.findAll();
        for (User user : userList) {
            System.out.println(user);
            System.out.println(user.getAccountList());
            System.out.println(user.getRoleList());
        }
    }
}
