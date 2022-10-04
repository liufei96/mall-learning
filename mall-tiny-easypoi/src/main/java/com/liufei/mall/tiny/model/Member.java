package com.liufei.mall.tiny.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author liufei
 * @version 1.0.0
 * @description 购物会员
 * @date 2022/10/4
 */
@Data
@EqualsAndHashCode(callSuper = false) // 生成equals和hashCode方法，如果callSuper为false,则不会涉及父类的属性
public class Member {

    @Excel(name = "ID", width = 10)
    private Long id;

    @Excel(name = "用户名", width = 20, needMerge = true)
    private String username;

    private String password;

    @Excel(name = "昵称", width = 20, needMerge = true)
    private String nickname;

    @Excel(name = "出生日期", width = 20, format = "yyyy-MM-dd")
    private Date birthday;

    @Excel(name = "手机号", width = 20, needMerge = true, desensitizationRule = "3_4")
    private String phone;

    private String icon;

    @Excel(name = "性别", width = 10, replace = {"男_0", "女_1"})
    private Integer gender;
}
