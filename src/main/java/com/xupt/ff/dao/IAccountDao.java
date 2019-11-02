package com.xupt.ff.dao;

import com.xupt.ff.domain.Account;

import java.util.List;

/**
 * @author cc_ff
 * @create 2019-11-02 下午4:30
 * @action
 */
public interface IAccountDao {

    /**
     * @action 查询所有账户信息
     * @return
     */
    List<Account> findAll();
}
