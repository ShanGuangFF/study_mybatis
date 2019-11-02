package com.xupt.ff.domain;

import java.io.Serializable;

/**
 * @author cc_ff
 * @create 2019-11-02 下午4:29
 * @action
 */
public class Account implements Serializable {
    private int id;
    private int uid;
    private double money;
    private User user;


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }
}
