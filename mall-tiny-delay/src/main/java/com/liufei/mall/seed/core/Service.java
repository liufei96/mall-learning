package com.liufei.mall.seed.core;

import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * @author liufei
 * @version 1.0.0
 * @description
 * @date 2022/9/4
 */
public interface Service<T> {

    int save(T model);

    int save(List<T> models);

    int deleteById(Integer id);

    int deleteByIds(String ids);

    int update(T model);

    int updateByCondition(T model, Condition condition);

    T findById(Integer id);

    T findBy(String fieldName, Object value);

    List<T> findByIds(String ids);

    List<T> findByCondition(Condition condition);

    List<T> findAll();

    int count(Object obj);

    int deleteByCondition(Condition condition);
}
