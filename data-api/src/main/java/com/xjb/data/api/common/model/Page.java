package com.xjb.data.api.common.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 通用分页对象
 * Created by xjb on 2019/2/25
 *
 * @param <T>
 */
public class Page<T> implements Serializable {


    /**
     * 当前页
     */
    private int pageNow = 1;
    /**
     * 每页数量
     */
    private int pageSize = 10;
    /**
     * 每页最大数量
     */
    private int limit = 10;
    /**
     * 开始序号 方便分页查询
     */
    private int startIndex = 0;
    /**
     * 结束序号  方便分页查询
     */
    private int endIndex = 0;
    /**
     * 页码总数
     */
    private int totalPage = 0;
    /**
     * 数据总数
     */
    private int totalCount = 0;
    /**
     * 分页查询集合
     */
    private List<T> list = new ArrayList<>();

    //设置分页的属性
    public void setPage() {
        int pageNow = this.getPageNow();
        int pageSize = this.getPageSize();
        int totalCount = this.getTotalCount();
        //检查pageSize
        if (pageSize < 1) {
            pageSize = 1;
            this.pageSize = pageSize;
        }

        if (pageSize > limit) {
            pageSize = limit;
            this.pageSize = pageSize;
        }

        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        int startIndex = (pageNow - 1) * pageSize;
        //避免下标越界
        if (startIndex < 0) {
            startIndex = 0;
        }
        if (startIndex > totalCount) {
            startIndex = totalCount;
        }


        int endIndex = startIndex + pageSize;

        //检查下标越界
        if (endIndex > totalCount) {
            endIndex = totalCount;
        }
        this.setEndIndex(endIndex);
        this.setTotalPage(totalPage);
        this.setStartIndex(startIndex);

    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }


    public void setPageSize(int pageSize) {
        if (pageSize >= limit)
            pageSize = limit;
        if (pageSize < 1)
            pageSize = 1;
        this.pageSize = pageSize;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
