package com.liufei.mall.tiny.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liufei
 * @version 1.0.0
 * @description
 * @date 2022/9/20
 */
@Data
public class UmsAdminRoleRelation implements Serializable {

    private Long id;

    private Long adminId;

    private Long roleId;
}
