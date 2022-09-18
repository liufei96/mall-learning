package com.liufei.mall.seed.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_pms_product_attribute_category")
public class PmsProductAttributeCategoryDOV1 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * 属性数量
     */
    @Column(name = "attribute_count")
    private Integer attributeCount;

    /**
     * 参数数量
     */
    @Column(name = "param_count")
    private Integer paramCount;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 是否删除，0 是未删除，1是已删除。默认为0
     */
    @Column(name = "is_deleted")
    private Byte deleted;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取属性数量
     *
     * @return attribute_count - 属性数量
     */
    public Integer getAttributeCount() {
        return attributeCount;
    }

    /**
     * 设置属性数量
     *
     * @param attributeCount 属性数量
     */
    public void setAttributeCount(Integer attributeCount) {
        this.attributeCount = attributeCount;
    }

    /**
     * 获取参数数量
     *
     * @return param_count - 参数数量
     */
    public Integer getParamCount() {
        return paramCount;
    }

    /**
     * 设置参数数量
     *
     * @param paramCount 参数数量
     */
    public void setParamCount(Integer paramCount) {
        this.paramCount = paramCount;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取是否删除，0 是未删除，1是已删除。默认为0
     *
     * @return is_deleted - 是否删除，0 是未删除，1是已删除。默认为0
     */
    public Byte getDeleted() {
        return deleted;
    }

    /**
     * 设置是否删除，0 是未删除，1是已删除。默认为0
     *
     * @param deleted 是否删除，0 是未删除，1是已删除。默认为0
     */
    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }
}