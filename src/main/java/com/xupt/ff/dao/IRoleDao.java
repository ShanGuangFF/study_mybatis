package com.xupt.ff.dao;

import com.xupt.ff.domain.Role;

import java.util.List;

/**
 * @author cc_ff
 * @create 2019-11-05 下午6:06
 * @action
 */
public interface IRoleDao {
    /**
     * @action 查询所有角色
     * @return
     */
    List<Role> findAll();
}
