package com.liufei.mall.utils;

import cn.hutool.core.date.DateUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * @author liufei
 * @version 1.0.0
 * @description 介绍hutool 中datax的用法，详细请参考hutool文档：https://hutool.cn/docs/#/
 * @date 2022/9/18
 */
public class DataUtils {

    public static void main(String[] args) {
        //当前时间
        Date date = DateUtil.date();
        //当前时间
        Date date2 = DateUtil.date(Calendar.getInstance());
        //当前时间
        Date date3 = DateUtil.date(System.currentTimeMillis());
        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        System.out.println(now);
        //当前日期字符串，格式：yyyy-MM-dd
        String today = DateUtil.today();
        System.out.println(today);
    }
}
