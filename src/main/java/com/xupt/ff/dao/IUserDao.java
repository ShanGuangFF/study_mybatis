package com.xupt.ff.dao;

import com.xupt.ff.domain.User;
import com.xupt.ff.domain.queryVo;
import com.xupt.ff.mybatis.annotation.customizeSelect;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface   IUserDao {
    /**
     * 查询所有用户
     * @return 包含所用用户的list集合
     */
    @customizeSelect("select * from user")//自定义注解
    List<User> findAll();

    /**
     * @action 保存用户信息
     */
    void saveUser(User user);

    /**
     * @action 更新用户信息
     */
    void updateUser(User user);

    /**
     * @action 删除用户
     */
    void deleteUser(Integer userId);

    /**
     * @action 根据ID查询一个用户
     * @param userId
     * @return
     */
    User findOne(Integer userId);

    /**
     * @action 根据字符串模糊查询
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * @action 查询所有用户的数目总和
     * @return
     */
    int findTotal();

    /**
     * @action 通过传递javaBean对象，查询综合条件
     */
    List<User> findByVo(queryVo vo);
}
