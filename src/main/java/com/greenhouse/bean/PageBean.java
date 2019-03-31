package com.greenhouse.bean;

/**
 * 用来分页bean
 */
public class PageBean {

    // 页码
    private Integer pageNum = 1;

    //  每页数量
    private Integer pageSize = 20;

    // 是否第一页
    private boolean isFirst;

    // 是否最后一页
    private boolean isLast;

    // 记录总数
    private Integer count;
    // 页码数量
    private Integer pageCount;


    public PageBean() {

    }

    public PageBean(Integer pageNum, Integer pageSize, Integer count) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.count = count;


        // 计算一共有多少页
        if ((this.count % this.pageSize) == 0) {
            this.pageCount = this.count / this.pageSize;
        } else {
            this.pageCount = this.count / this.pageSize + 1;
        }

        if (this.pageCount.intValue() == this.pageNum.intValue() || this.pageCount == 0)
            this.isLast = true;

        if (this.pageNum == 1)
            this.isFirst = true;

    }

    public PageBean(Integer pageNum, Integer pageSize, Integer btnNum, Integer count) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        initCount(count.longValue());

    }
    public PageBean initCount(Long count){
        this.count = count.intValue();

        // 计算一共有多少页
        if ((this.count % this.pageSize) == 0) {
            this.pageCount = this.count / this.pageSize;
        } else {
            this.pageCount = this.count / this.pageSize + 1;
        }

        if (this.pageCount == this.pageNum)
            this.isLast = true;

        if (this.pageNum == 1)
            this.isFirst = true;

        return this;
    }

    /**
     * 获取开始记录数
     *
     * @author Marco
     */
    public Integer getBeginIndex() {

        Integer beginIndex = (this.getPageNum() - 1) * this.getPageSize();

        return beginIndex;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        if (null != pageNum)
            this.pageNum = pageNum;
    }

    public void setPageNum(String pageNum) {
        if (null != pageNum && pageNum.length() > 0) {
            this.pageNum = Integer.parseInt(pageNum);
        }
    }

    public void setPageSize(String pageSize) {
        if (null != pageSize && pageSize.length() > 0) {
            this.pageSize = Integer.parseInt(pageSize);
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (null != pageSize)
            this.pageSize = pageSize;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean isFirst) {
        this.isFirst = isFirst;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean isLast) {
        this.isLast = isLast;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

}
