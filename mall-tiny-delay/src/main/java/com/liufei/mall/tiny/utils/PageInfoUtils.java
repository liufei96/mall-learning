package com.liufei.mall.tiny.utils;

import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;

/**
 * @author liufei
 * @version 1.0.0
 * @description 分页工具类
 * @date 2022/9/12
 */
public class PageInfoUtils {

    /**
     * 将SpringData分页后的list转为分页信息
     */
    public static <T> PageInfo<T> restPage(Page<T> page) {
        PageInfo<T> pageInfo = new PageInfo<T>();
        pageInfo.setTotal(page.getTotalPages());
        pageInfo.setPageNum(page.getNumber());
        pageInfo.setPageSize(page.getSize());
        pageInfo.setTotal(page.getTotalElements());
        pageInfo.setList(page.getContent());
        return pageInfo;
    }


}
