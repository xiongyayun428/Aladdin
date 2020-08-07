package com.xiongyayun.aladdin.common.mybatisplus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Page
 *
 * @author: <a href="mailto:xiongyayun428@163.com">Yayun.Xiong</a>
 * @date: 2020/8/6
 */
@JsonInclude()
@JsonIgnoreProperties({ "pages", "current", "size", "optimizeCountSql", "searchCount", "hitCount", "orders" })
@JsonPropertyOrder({"total", "pageCount", "pageNum", "pageSize", "hasPrevious", "hasNext", "records"})
public class Page<T> extends com.baomidou.mybatisplus.extension.plugins.pagination.Page<T> implements com.xiongyayun.aladdin.common.mybatisplus.IPage<T> {

    public Page() {
    }

    /**
     * 分页构造函数
     *
     * @param pageNum     当前页
     * @param pageSize    每页显示条数
     */
    public Page(long pageNum, long pageSize) {
        this(pageNum, pageSize, 0);
    }

    public Page(long pageNum, long pageSize, long total) {
        this(pageNum, pageSize, total, true);
    }

    public Page(long pageNum, long pageSize, boolean searchCount) {
        this(pageNum, pageSize, 0, searchCount);
    }

    public Page(long pageNum, long pageSize, long total, boolean searchCount) {
        super(pageNum, pageSize, total, searchCount);
    }

    /**
     * 当前页
     * @return
     */
    @Override
    public long getPageNum() {
        return getCurrent();
    }

    public Page<T> setPageNum(long pageNum) {
        setCurrent(pageNum);
        return this;
    }

    /**
     * 每页显示条数，默认 10
     * @return
     */
    @Override
    public long getPageSize() {
        return getSize();
    }

    public Page<T> setPageSize(long pageSize) {
        setSize(pageSize);
        return this;
    }

    /**
     * 当前分页总页数
     * @return
     */
    @Override
    public long getPageCount() {
        return getPages();
    }

    public Page<T> setPageCount(long pageCount) {
        setPages(pageCount);
        return this;
    }
}
