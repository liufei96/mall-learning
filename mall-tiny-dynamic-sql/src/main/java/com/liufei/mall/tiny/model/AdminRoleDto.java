package com.liufei.mall.tiny.model;

import lombok.Data;

import java.util.List;

/**
 * @author liufei
 * @version 1.0.0
 * @description
 * @date 2022/9/20
 */
@Data
public class AdminRoleDto extends UmsAdmin {

    private List<UmsRole> roleList;

}
