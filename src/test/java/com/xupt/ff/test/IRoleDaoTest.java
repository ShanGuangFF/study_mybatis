package com.xupt.ff.test;

import com.xupt.ff.dao.IRoleDao;
import com.xupt.ff.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author cc_ff
 * @create 2019-11-05 下午6:22
 * @action
 */
public class IRoleDaoTest {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private IRoleDao iRoleDao;

    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSession = new SqlSessionFactoryBuilder().build(inputStream).openSession();
        iRoleDao = sqlSession.getMapper(IRoleDao.class);
    }

    @After
    public void destroy() throws Exception{
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testfindAllRole(){
        List<Role> roleList = iRoleDao.findAll();
        for (Role role : roleList) {
            System.out.println(role);
            System.out.println(role.getUserList());
        }
    }
}
