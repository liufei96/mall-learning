package com.liufei.mall.seed.core;

import lombok.Data;

/**
 * @author liufei
 * @version 1.0.0
 * @description
 * @date 2022/9/5
 */
@Data
public class UpdateCondition<T> {

    private RequestCondition condition;

    private T Model;
}
