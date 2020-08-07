package com.xiongyayun.aladdin.common.mybatisplus;

import java.util.List;

/**
 * IPage
 *
 * @author: <a href="mailto:xiongyayun428@163.com">Yayun.Xiong</a>
 * @date: 2020/8/6
 */
public interface IPage<T> {
    /**
     * 当前页
     * @return
     */
    long getPageNum();

    /**
     * 每页显示条数
     * @return
     */
    long getPageSize();

    /**
     * 当前分页总页数
     * @return
     */
    long getPageCount();

    /**
     * 当前分页总记录数
     * @return
     */
    long getTotal();

    /**
     * 当前分页查询数据列表
     * @return
     */
    List<T> getRecords();

    /**
     * 是否存在上一页
     * @return true / false
     */
    default boolean isHasPrevious() {
        return getPageNum() > 1;
    }

    /**
     * 是否存在下一页
     * @return true / false
     */
    default boolean isHasNext() {
        return getPageNum() < getPageCount();
    }
}
