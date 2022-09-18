package com.liufei.mall.seed.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_pms_product_attribute")
public class PmsProductAttributeDOV1 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_attribute_category_id")
    private Long productAttributeCategoryId;

    private String name;

    /**
     * 属性选择类型：0->唯一；1->单选；2->多选
     */
    @Column(name = "select_type")
    private Integer selectType;

    /**
     * 属性录入方式：0->手工录入；1->从列表中选取
     */
    @Column(name = "input_type")
    private Integer inputType;

    /**
     * 可选值列表，以逗号隔开
     */
    @Column(name = "input_list")
    private String inputList;

    /**
     * 排序字段：最高的可以单独上传图片
     */
    private Integer sort;

    /**
     * 分类筛选样式：1->普通；1->颜色
     */
    @Column(name = "filter_type")
    private Integer filterType;

    /**
     * 检索类型；0->不需要进行检索；1->关键字检索；2->范围检索
     */
    @Column(name = "search_type")
    private Integer searchType;

    /**
     * 相同属性产品是否关联；0->不关联；1->关联
     */
    @Column(name = "related_status")
    private Integer relatedStatus;

    /**
     * 是否支持手动新增；0->不支持；1->支持
     */
    @Column(name = "hand_add_status")
    private Integer handAddStatus;

    /**
     * 属性的类型；0->规格；1->参数
     */
    private Integer type;

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
     * @return product_attribute_category_id
     */
    public Long getProductAttributeCategoryId() {
        return productAttributeCategoryId;
    }

    /**
     * @param productAttributeCategoryId
     */
    public void setProductAttributeCategoryId(Long productAttributeCategoryId) {
        this.productAttributeCategoryId = productAttributeCategoryId;
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
     * 获取属性选择类型：0->唯一；1->单选；2->多选
     *
     * @return select_type - 属性选择类型：0->唯一；1->单选；2->多选
     */
    public Integer getSelectType() {
        return selectType;
    }

    /**
     * 设置属性选择类型：0->唯一；1->单选；2->多选
     *
     * @param selectType 属性选择类型：0->唯一；1->单选；2->多选
     */
    public void setSelectType(Integer selectType) {
        this.selectType = selectType;
    }

    /**
     * 获取属性录入方式：0->手工录入；1->从列表中选取
     *
     * @return input_type - 属性录入方式：0->手工录入；1->从列表中选取
     */
    public Integer getInputType() {
        return inputType;
    }

    /**
     * 设置属性录入方式：0->手工录入；1->从列表中选取
     *
     * @param inputType 属性录入方式：0->手工录入；1->从列表中选取
     */
    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }

    /**
     * 获取可选值列表，以逗号隔开
     *
     * @return input_list - 可选值列表，以逗号隔开
     */
    public String getInputList() {
        return inputList;
    }

    /**
     * 设置可选值列表，以逗号隔开
     *
     * @param inputList 可选值列表，以逗号隔开
     */
    public void setInputList(String inputList) {
        this.inputList = inputList == null ? null : inputList.trim();
    }

    /**
     * 获取排序字段：最高的可以单独上传图片
     *
     * @return sort - 排序字段：最高的可以单独上传图片
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序字段：最高的可以单独上传图片
     *
     * @param sort 排序字段：最高的可以单独上传图片
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取分类筛选样式：1->普通；1->颜色
     *
     * @return filter_type - 分类筛选样式：1->普通；1->颜色
     */
    public Integer getFilterType() {
        return filterType;
    }

    /**
     * 设置分类筛选样式：1->普通；1->颜色
     *
     * @param filterType 分类筛选样式：1->普通；1->颜色
     */
    public void setFilterType(Integer filterType) {
        this.filterType = filterType;
    }

    /**
     * 获取检索类型；0->不需要进行检索；1->关键字检索；2->范围检索
     *
     * @return search_type - 检索类型；0->不需要进行检索；1->关键字检索；2->范围检索
     */
    public Integer getSearchType() {
        return searchType;
    }

    /**
     * 设置检索类型；0->不需要进行检索；1->关键字检索；2->范围检索
     *
     * @param searchType 检索类型；0->不需要进行检索；1->关键字检索；2->范围检索
     */
    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }

    /**
     * 获取相同属性产品是否关联；0->不关联；1->关联
     *
     * @return related_status - 相同属性产品是否关联；0->不关联；1->关联
     */
    public Integer getRelatedStatus() {
        return relatedStatus;
    }

    /**
     * 设置相同属性产品是否关联；0->不关联；1->关联
     *
     * @param relatedStatus 相同属性产品是否关联；0->不关联；1->关联
     */
    public void setRelatedStatus(Integer relatedStatus) {
        this.relatedStatus = relatedStatus;
    }

    /**
     * 获取是否支持手动新增；0->不支持；1->支持
     *
     * @return hand_add_status - 是否支持手动新增；0->不支持；1->支持
     */
    public Integer getHandAddStatus() {
        return handAddStatus;
    }

    /**
     * 设置是否支持手动新增；0->不支持；1->支持
     *
     * @param handAddStatus 是否支持手动新增；0->不支持；1->支持
     */
    public void setHandAddStatus(Integer handAddStatus) {
        this.handAddStatus = handAddStatus;
    }

    /**
     * 获取属性的类型；0->规格；1->参数
     *
     * @return type - 属性的类型；0->规格；1->参数
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置属性的类型；0->规格；1->参数
     *
     * @param type 属性的类型；0->规格；1->参数
     */
    public void setType(Integer type) {
        this.type = type;
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