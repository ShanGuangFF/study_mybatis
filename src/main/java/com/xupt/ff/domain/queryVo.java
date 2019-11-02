package com.xupt.ff.domain;

import java.util.List;

/**
 * @author cc_ff
 * @create 2019-10-30 下午4:24
 * @action 传递的查询条件
 */
public class queryVo {
    private User user;
    private List<Integer> idList;

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
