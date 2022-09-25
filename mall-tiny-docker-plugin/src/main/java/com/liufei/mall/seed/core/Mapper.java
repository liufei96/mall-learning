package com.liufei.mall.seed.core;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * @author liufei
 * @version 1.0.0
 * @description 定制版Mybatis Mapper插件接口，如需其他接口请参考官方文档自行添加
 * @date 2022/9/4
 */
public interface Mapper <T> extends
        BaseMapper<T>,
        ConditionMapper<T>,
        IdsMapper<T>,
        InsertListMapper<T> {
}
