package com.zhang.biyeseji.remeberme.util;

public class PageRequest {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;

    private Integer nowclassfiy;

    private Integer nowtag;

    //这里定义的是es的查询字段
    private  String esString;

    public String getEsString() {
        return esString;
    }

    public void setEsString(String esString) {
        this.esString = esString;
    }

    public void setNowclassfiy(Integer nowclassfiy) {
        this.nowclassfiy = nowclassfiy;
    }

    public void setNowtag(Integer nowtag) {
        this.nowtag = nowtag;
    }

    public Integer getNowclassfiy() {
        return nowclassfiy;
    }

    public Integer getNowtag() {
        return nowtag;
    }

    public int getPageNum() {
        return pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
