package com.xupt.ff.dao;

import com.xupt.ff.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface   IUserDao {
    /**
     * 查询所有用户
     * @return 包含所用用户的list集合
     */
    List<User> findAll();
}
