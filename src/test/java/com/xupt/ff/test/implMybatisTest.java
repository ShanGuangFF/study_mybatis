package com.xupt.ff.test;

import com.xupt.ff.dao.IUserDao;
import com.xupt.ff.dao.impl.userDaoImpl;
import com.xupt.ff.domain.User;
import com.xupt.ff.domain.queryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class implMybatisTest {

    private InputStream inputStream;
    private IUserDao iUserDao;


    @Before//用于在测试方法之前执行
    public void init() throws Exception{
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        iUserDao = new userDaoImpl(factory);
    }

    @After//用于在测试方法之后执行
    public void destroy() throws Exception{
        inputStream.close();
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setAddress("西安市长安区");
        user.setUsername("简十初");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存前"+user);
        iUserDao.saveUser(user);
        System.out.println("保存后"+user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setAddress("西安市长安区");
        user.setUsername("简十遇");
        user.setId(49);
        user.setSex("女");
        user.setBirthday(new Date());

        iUserDao.updateUser(user);
    }

    @Test
    public void testDelete(){
        iUserDao.deleteUser(49);
    }

    @Test
    public void testFindOne(){
        User user = iUserDao.findOne(48);
        System.out.println(user);
    }

    @Test
    public void testFindByName(){
        List<User> userList = iUserDao.findByName("%王%");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void test(){
        System.out.println(iUserDao.findTotal());
    }
    @Test
    public void testfindByVo(){
        queryVo vo = new queryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> userList = iUserDao.findByVo(vo);
        for (User user1 : userList) {
            System.out.println(user1);
        }
    }
}
