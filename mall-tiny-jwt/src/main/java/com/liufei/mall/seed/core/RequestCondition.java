package com.liufei.mall.seed.core;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * @author liufei
 * @version 1.0.0
 * @description 统一查询条件工具类。主要供前端使用
 * @date 2022/9/4
 */
@Data
public class RequestCondition {

    private final static Logger log = LoggerFactory.getLogger(RequestCondition.class);

    private Map<String, Object> equalConditions = new HashMap<>();
    private Map<String, Object> notEqualConditions = new HashMap<>();
    private Map<String, Object> greaterThanConditions = new HashMap<>();
    private Map<String, Object> lessThanConditions = new HashMap<>();
    private Map<String, Object> greaterThanOrEqualConditions = new HashMap<>();
    private Map<String, Object> lessThanOrEqualConditions = new HashMap<>();
    private Map<String, String> likeEqualConditions = new HashMap<>();
    private Map<String, String> notLikeEqualConditions = new HashMap<>();
    private Map<String, String> orLikeEqualConditions = new HashMap<>();
    private Map<String, Collection> andInConditions = new HashMap<>();
    private String[] excludePropertiesCondition;
    private String[] includePropertiesCondition;
    private String orderBy;
    private Boolean asc;

    private void addEqualCondition(Example.Criteria criteria, Set<String> propertySet) {
        if (equalConditions != null) {
            for (Map.Entry<String, Object> entry : equalConditions.entrySet()) {
                if (propertySet.contains(entry.getKey())) {
                    criteria.andEqualTo(entry.getKey(), entry.getValue());
                } else {
                    log.warn("request condition field:" + entry.getKey() + " not exists");
                }
            }
        }
    }

    private void addNotEqualConditions(Example.Criteria criteria, Set<String> propertySet) {
        if (notEqualConditions != null) {
            for (Map.Entry<String, Object> entry : notEqualConditions.entrySet()) {
                if (propertySet.contains(entry.getKey())) {
                    criteria.andNotEqualTo(entry.getKey(), entry.getValue());
                } else {
                    log.warn("request condition field:" + entry.getKey() + " not exists");
                }
            }
        }
    }

    private void addGreaterThanConditions (Example.Criteria criteria, Set<String> propertySet) {
        if (greaterThanConditions != null) {
            for (Map.Entry<String, Object> entry : greaterThanConditions.entrySet()) {
                if (propertySet.contains(entry.getKey())) {
                    criteria.andGreaterThan(entry.getKey(), entry.getValue());
                } else {
                    log.warn("request condition field:" + entry.getKey() + " not exists");
                }
            }
        }
    }

    private void addLessThanConditions (Example.Criteria criteria, Set<String> propertySet) {
        if (lessThanConditions != null) {
            for (Map.Entry<String, Object> entry : lessThanConditions.entrySet()) {
                if (propertySet.contains(entry.getKey())) {
                    criteria.andLessThan(entry.getKey(), entry.getValue());
                } else {
                    log.warn("request condition field:" + entry.getKey() + " not exists");
                }
            }
        }
    }

    private void addGreaterThanOrEqualConditions (Example.Criteria criteria, Set<String> propertySet) {
        if (greaterThanOrEqualConditions != null) {
            for (Map.Entry<String, Object> entry : greaterThanOrEqualConditions.entrySet()) {
                if (propertySet.contains(entry.getKey())) {
                    criteria.andGreaterThanOrEqualTo(entry.getKey(), entry.getValue());
                } else {
                    log.warn("request condition field:" + entry.getKey() + " not exists");
                }
            }
        }
    }

    private void addLessThanOrEqualConditions (Example.Criteria criteria, Set<String> propertySet) {
        if (lessThanOrEqualConditions != null) {
            for (Map.Entry<String, Object> entry : lessThanOrEqualConditions.entrySet()) {
                if (propertySet.contains(entry.getKey())) {
                    criteria.andLessThanOrEqualTo(entry.getKey(), entry.getValue());
                } else {
                    log.warn("request condition field:" + entry.getKey() + " not exists");
                }
            }
        }
    }

    private void addLikeEqualConditions (Example.Criteria criteria, Set<String> propertySet) {
        if (likeEqualConditions != null) {
            for (Map.Entry<String, String> entry : likeEqualConditions.entrySet()) {
                if (propertySet.contains(entry.getKey())) {
                    criteria.andLike(entry.getKey(), entry.getValue());
                } else {
                    log.warn("request condition field:" + entry.getKey() + " not exists");
                }
            }
        }
    }

    private void addNotLikeEqualConditions (Example.Criteria criteria, Set<String> propertySet) {
        if (notLikeEqualConditions != null) {
            for (Map.Entry<String, String> entry : notLikeEqualConditions.entrySet()) {
                if (propertySet.contains(entry.getKey())) {
                    criteria.andNotLike(entry.getKey(), entry.getValue());
                } else {
                    log.warn("request condition field:" + entry.getKey() + " not exists");
                }
            }
        }
    }

    private void addOrLikeEqualConditions (Example.Criteria criteria, Set<String> propertySet) {
        if (orLikeEqualConditions != null) {
            for (Map.Entry<String, String> entry : orLikeEqualConditions.entrySet()) {
                if (propertySet.contains(entry.getKey())) {
                    criteria.orLike(entry.getKey(), entry.getValue());
                } else {
                    log.warn("request condition field:" + entry.getKey() + " not exists");
                }
            }
        }
    }

    private void addAndInConditions (Example.Criteria criteria, Set<String> propertySet) {
        if (andInConditions != null) {
            for (Map.Entry<String, Collection> entry : andInConditions.entrySet()) {
                if (propertySet.contains(entry.getKey())) {
                    criteria.andIn(entry.getKey(), entry.getValue());
                } else {
                    log.warn("request condition field:" + entry.getKey() + " not exists");
                }
            }
        }
    }

    public Condition generateRequestCondition(Class<?> entityClass) {
        Condition condition = new Condition(entityClass);
        Set<String> propertySet = condition.getPropertyMap().keySet();

        Example.Criteria criteria = condition.createCriteria();
        updateCriteria(criteria, propertySet);
        criteria.andEqualTo("deleted", 0);

        if (excludePropertiesCondition != null) {
            condition.excludeProperties(excludePropertiesCondition);
        }

        if (includePropertiesCondition != null) {
            condition.selectProperties(includePropertiesCondition);
        }

        if (orderBy != null && propertySet.contains(orderBy)) {
            if (asc == null || asc) {
                condition.orderBy(orderBy).asc();
            } else {
                condition.orderBy(orderBy).desc();
            }
        }
        return condition;
    }

    public Condition generateNonDeleteRequestCondition(Class<?> entityClass) {
        Condition condition = new Condition(entityClass);
        Set<String> propertySet = condition.getPropertyMap().keySet();

        Example.Criteria criteria = condition.createCriteria();
        updateCriteria(criteria, propertySet);

        if (excludePropertiesCondition != null) {
            condition.excludeProperties(excludePropertiesCondition);
        }

        if (includePropertiesCondition != null) {
            condition.selectProperties(includePropertiesCondition);
        }

        if (orderBy != null && propertySet.contains(orderBy)) {
            if (asc == null || asc) {
                condition.orderBy(orderBy).asc();
            } else {
                condition.orderBy(orderBy).desc();
            }
        }
        return condition;
    }

    private void updateCriteria (Example.Criteria criteria, Set<String> propertySet) {
        addEqualCondition(criteria, propertySet);
        addNotEqualConditions(criteria, propertySet);
        addGreaterThanConditions(criteria, propertySet);
        addLessThanConditions(criteria, propertySet);
        addGreaterThanOrEqualConditions(criteria, propertySet);
        addLessThanOrEqualConditions(criteria, propertySet);
        addLikeEqualConditions(criteria, propertySet);
        addNotLikeEqualConditions(criteria, propertySet);
        addOrLikeEqualConditions(criteria, propertySet);
        addAndInConditions(criteria, propertySet);
    }
}
