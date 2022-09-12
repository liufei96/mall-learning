package com.liufei.mall.seed.core;

import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author liufei
 * @version 1.0.0
 * @description 基于通用Mybatis Mapper插件的Service接口的实现
 * @date 2022/9/4
 */
public abstract class AbstractService<T> implements Service<T> {

    @Autowired
    protected Mapper<T> mapper;

    private Class<T> modelClass;

    public AbstractService () {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    /**
     * 不会把对象为值为null的值加上
     * @param model
     * @return
     */
    public int save(T model) {
        return mapper.insertSelective(model);
    }

    public int save(List<T> models) {
        return mapper.insertList(models);
    }

    public int deleteById(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public int deleteByIds(String ids) {
        return mapper.deleteByIds(ids);
    }

    public int update(T model) {
        return mapper.updateByPrimaryKey(model);
    }

    public int updateByCondition(T model, Condition condition) {
        return mapper.updateByConditionSelective(model, condition);
    }

    public T findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    public List<T> findByIds(String ids) {
        return mapper.selectByIds(ids);
    }

    public T findBy(String fieldName, Object value) {
        try {
            T model = modelClass.newInstance();
            Field field = modelClass.getField(fieldName);
            field.setAccessible(true);
            field.set(model, value);
            return mapper.selectOne(model);
        }  catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public List<T> findByCondition(Condition condition) {
        return mapper.selectByCondition(condition);
    }

    public List<T> findAll() {
        return mapper.selectAll();
    }

    public int count(Object obj) {
        return mapper.selectCountByCondition(obj);
    }

    public int deleteByCondition(Condition condition) {
        return mapper.deleteByCondition(condition);
    }
}
