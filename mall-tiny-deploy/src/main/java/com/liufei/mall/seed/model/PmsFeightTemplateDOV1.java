package com.liufei.mall.seed.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_pms_feight_template")
public class PmsFeightTemplateDOV1 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * 计费类型:0->按重量；1->按件数
     */
    @Column(name = "charge_type")
    private Integer chargeType;

    /**
     * 首重kg
     */
    @Column(name = "first_weight")
    private BigDecimal firstWeight;

    /**
     * 首费（元）
     */
    @Column(name = "first_fee")
    private BigDecimal firstFee;

    @Column(name = "continue_weight")
    private BigDecimal continueWeight;

    @Column(name = "continue_fee")
    private BigDecimal continueFee;

    /**
     * 目的地（省、市）
     */
    private String dest;

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
     * 获取计费类型:0->按重量；1->按件数
     *
     * @return charge_type - 计费类型:0->按重量；1->按件数
     */
    public Integer getChargeType() {
        return chargeType;
    }

    /**
     * 设置计费类型:0->按重量；1->按件数
     *
     * @param chargeType 计费类型:0->按重量；1->按件数
     */
    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }

    /**
     * 获取首重kg
     *
     * @return first_weight - 首重kg
     */
    public BigDecimal getFirstWeight() {
        return firstWeight;
    }

    /**
     * 设置首重kg
     *
     * @param firstWeight 首重kg
     */
    public void setFirstWeight(BigDecimal firstWeight) {
        this.firstWeight = firstWeight;
    }

    /**
     * 获取首费（元）
     *
     * @return first_fee - 首费（元）
     */
    public BigDecimal getFirstFee() {
        return firstFee;
    }

    /**
     * 设置首费（元）
     *
     * @param firstFee 首费（元）
     */
    public void setFirstFee(BigDecimal firstFee) {
        this.firstFee = firstFee;
    }

    /**
     * @return continue_weight
     */
    public BigDecimal getContinueWeight() {
        return continueWeight;
    }

    /**
     * @param continueWeight
     */
    public void setContinueWeight(BigDecimal continueWeight) {
        this.continueWeight = continueWeight;
    }

    /**
     * @return continue_fee
     */
    public BigDecimal getContinueFee() {
        return continueFee;
    }

    /**
     * @param continueFee
     */
    public void setContinueFee(BigDecimal continueFee) {
        this.continueFee = continueFee;
    }

    /**
     * 获取目的地（省、市）
     *
     * @return dest - 目的地（省、市）
     */
    public String getDest() {
        return dest;
    }

    /**
     * 设置目的地（省、市）
     *
     * @param dest 目的地（省、市）
     */
    public void setDest(String dest) {
        this.dest = dest == null ? null : dest.trim();
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