package com.xupt.ff.mybatis.cfg;

/**
 * @author cc_ff
 * @create 2019-10-26 下午4:43
 * @action 用于封装执行的Sql语句和结果类型的全限定类名
 */
public class Mapper {
    private String queryString; //Sql
    private String resultType; //实体类的全限定类名

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
