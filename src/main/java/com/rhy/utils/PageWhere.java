package com.rhy.utils;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/16
 * @Description: com.rhy.entity.emp
 * @Version:1.0
 */
public class PageWhere {
    private int pageSize = 100;
    private int pageNow = 1;
    private Long pageTotal;

    public PageWhere() {
    }

    public PageWhere(int pageSize, int pageNow, Long pageTotal) {
        this.pageSize = pageSize;
        this.pageNow = pageNow;
        this.pageTotal = pageTotal;
    }

    @Override
    public String toString() {
        return "EmpWhere{" +
                "pageSize=" + pageSize +
                ", pageNow=" + pageNow +
                ", pageTotal=" + pageTotal +
                '}';
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public Long getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Long pageTotal) {
        this.pageTotal = pageTotal;
    }
}
