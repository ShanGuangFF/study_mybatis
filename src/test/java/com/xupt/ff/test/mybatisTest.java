package com.xupt.ff.test;

import com.xupt.ff.dao.IUserDao;
import com.xupt.ff.dao.impl.userDaoImpl;
import com.xupt.ff.domain.User;
import com.xupt.ff.mybatis.io.mybatisResources;
import com.xupt.ff.mybatis.sqlSession.mybatisSqlSession;
import com.xupt.ff.mybatis.sqlSession.mybatisSqlSessionFactory;
import com.xupt.ff.mybatis.sqlSession.mybatisSqlSessionFactoryBuild;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mybatisTest {

    /**
     * 使用代理对象，不写dao实现类
     */
    @Test
    public void test1 () throws IOException {
        //1.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        //6.释放资源
        sqlSession.close();
        inputStream.close();
    }

    /**
     * 使用userDaoImpl，繁琐，没有省去不需要的麻烦
     * @throws Exception
     */
   @Test
   public void test2() throws Exception{
      //1.读取配置文件
      InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
      //2.创建SqlSessionFactory工厂
      SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
      SqlSessionFactory factory = builder.build(inputStream);
      //3.使用工厂创建userDao实体类
      IUserDao userDao = new userDaoImpl(factory);
      //5.使用实体对象执行方法
      List<User> userList = userDao.findAll();
      for (User user : userList) {
          System.out.println(user);
      }
      //6.释放资源
      inputStream.close();
   }

    /**
     * 自定义实现mybatis  自定义：customize
     */
    @Test
    public void testCustomize() throws IOException {
        //1.读取配置文件
        InputStream inputStream = mybatisResources.getResourceAsStream("customizeSqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        mybatisSqlSessionFactoryBuild builder = new mybatisSqlSessionFactoryBuild();
        mybatisSqlSessionFactory factory = builder.build(inputStream);
        //3.使用工厂生产SqlSession对象
        mybatisSqlSession sqlSession = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        //6.释放资源
        sqlSession.close();
        inputStream.close();
    }
}
