package com.liufei.mall.seed.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_sms_coupon")
public class SmsCouponDOV1 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 优惠卷类型；0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券
     */
    private Integer type;

    private String name;

    /**
     * 使用平台：0->全部；1->移动；2->PC
     */
    private Integer platform;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 每人限领张数
     */
    @Column(name = "per_limit")
    private Integer perLimit;

    /**
     * 使用门槛；0表示无门槛
     */
    @Column(name = "min_point")
    private BigDecimal minPoint;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    /**
     * 使用类型：0->全场通用；1->指定分类；2->指定商品
     */
    @Column(name = "use_type")
    private Integer useType;

    /**
     * 备注
     */
    private String note;

    /**
     * 发行数量
     */
    @Column(name = "publish_count")
    private Integer publishCount;

    /**
     * 已使用数量
     */
    @Column(name = "use_count")
    private Integer useCount;

    /**
     * 领取数量
     */
    @Column(name = "receive_count")
    private Integer receiveCount;

    /**
     * 可以领取的日期
     */
    @Column(name = "enable_time")
    private Date enableTime;

    /**
     * 优惠码
     */
    private String code;

    /**
     * 可领取的会员类型：0->无限时
     */
    @Column(name = "member_level")
    private Integer memberLevel;

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
     * 获取优惠卷类型；0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券
     *
     * @return type - 优惠卷类型；0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置优惠卷类型；0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券
     *
     * @param type 优惠卷类型；0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券
     */
    public void setType(Integer type) {
        this.type = type;
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
     * 获取使用平台：0->全部；1->移动；2->PC
     *
     * @return platform - 使用平台：0->全部；1->移动；2->PC
     */
    public Integer getPlatform() {
        return platform;
    }

    /**
     * 设置使用平台：0->全部；1->移动；2->PC
     *
     * @param platform 使用平台：0->全部；1->移动；2->PC
     */
    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    /**
     * 获取数量
     *
     * @return count - 数量
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置数量
     *
     * @param count 数量
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取金额
     *
     * @return amount - 金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置金额
     *
     * @param amount 金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 获取每人限领张数
     *
     * @return per_limit - 每人限领张数
     */
    public Integer getPerLimit() {
        return perLimit;
    }

    /**
     * 设置每人限领张数
     *
     * @param perLimit 每人限领张数
     */
    public void setPerLimit(Integer perLimit) {
        this.perLimit = perLimit;
    }

    /**
     * 获取使用门槛；0表示无门槛
     *
     * @return min_point - 使用门槛；0表示无门槛
     */
    public BigDecimal getMinPoint() {
        return minPoint;
    }

    /**
     * 设置使用门槛；0表示无门槛
     *
     * @param minPoint 使用门槛；0表示无门槛
     */
    public void setMinPoint(BigDecimal minPoint) {
        this.minPoint = minPoint;
    }

    /**
     * @return start_time
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return end_time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取使用类型：0->全场通用；1->指定分类；2->指定商品
     *
     * @return use_type - 使用类型：0->全场通用；1->指定分类；2->指定商品
     */
    public Integer getUseType() {
        return useType;
    }

    /**
     * 设置使用类型：0->全场通用；1->指定分类；2->指定商品
     *
     * @param useType 使用类型：0->全场通用；1->指定分类；2->指定商品
     */
    public void setUseType(Integer useType) {
        this.useType = useType;
    }

    /**
     * 获取备注
     *
     * @return note - 备注
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置备注
     *
     * @param note 备注
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    /**
     * 获取发行数量
     *
     * @return publish_count - 发行数量
     */
    public Integer getPublishCount() {
        return publishCount;
    }

    /**
     * 设置发行数量
     *
     * @param publishCount 发行数量
     */
    public void setPublishCount(Integer publishCount) {
        this.publishCount = publishCount;
    }

    /**
     * 获取已使用数量
     *
     * @return use_count - 已使用数量
     */
    public Integer getUseCount() {
        return useCount;
    }

    /**
     * 设置已使用数量
     *
     * @param useCount 已使用数量
     */
    public void setUseCount(Integer useCount) {
        this.useCount = useCount;
    }

    /**
     * 获取领取数量
     *
     * @return receive_count - 领取数量
     */
    public Integer getReceiveCount() {
        return receiveCount;
    }

    /**
     * 设置领取数量
     *
     * @param receiveCount 领取数量
     */
    public void setReceiveCount(Integer receiveCount) {
        this.receiveCount = receiveCount;
    }

    /**
     * 获取可以领取的日期
     *
     * @return enable_time - 可以领取的日期
     */
    public Date getEnableTime() {
        return enableTime;
    }

    /**
     * 设置可以领取的日期
     *
     * @param enableTime 可以领取的日期
     */
    public void setEnableTime(Date enableTime) {
        this.enableTime = enableTime;
    }

    /**
     * 获取优惠码
     *
     * @return code - 优惠码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置优惠码
     *
     * @param code 优惠码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取可领取的会员类型：0->无限时
     *
     * @return member_level - 可领取的会员类型：0->无限时
     */
    public Integer getMemberLevel() {
        return memberLevel;
    }

    /**
     * 设置可领取的会员类型：0->无限时
     *
     * @param memberLevel 可领取的会员类型：0->无限时
     */
    public void setMemberLevel(Integer memberLevel) {
        this.memberLevel = memberLevel;
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