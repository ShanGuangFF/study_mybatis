package com.xupt.ff.test;

import com.xupt.ff.dao.IAccountDao;
import com.xupt.ff.domain.Account;
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
 * @create 2019-11-02 下午4:34
 * @action
 */
public class accountTest {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private IAccountDao iAccountDao;

    @Before
    public void init() throws Exception{
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSession = new SqlSessionFactoryBuilder().build(inputStream).openSession();
        iAccountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After
    public void destroy() throws Exception{
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testFindALl(){
        List<Account> accountList = iAccountDao.findAll();
        for (Account account : accountList) {
            System.out.println(account);
        }
    }
}
