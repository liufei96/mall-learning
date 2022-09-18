package com.liufei.mall.seed.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_ums_member_rule_setting")
public class UmsMemberRuleSettingDOV1 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 连续签到天数
     */
    @Column(name = "continue_sign_day")
    private Integer continueSignDay;

    /**
     * 连续签到赠送数量
     */
    @Column(name = "continue_sign_point")
    private Integer continueSignPoint;

    /**
     * 每消费多少元获取1个点
     */
    @Column(name = "consume_per_point")
    private BigDecimal consumePerPoint;

    /**
     * 最低获取点数的订单金额
     */
    @Column(name = "low_order_amount")
    private BigDecimal lowOrderAmount;

    /**
     * 每笔订单最高获取点数
     */
    @Column(name = "max_point_per_order")
    private Integer maxPointPerOrder;

    /**
     * 类型：0->积分规则；1->成长值规则
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
     * 获取连续签到天数
     *
     * @return continue_sign_day - 连续签到天数
     */
    public Integer getContinueSignDay() {
        return continueSignDay;
    }

    /**
     * 设置连续签到天数
     *
     * @param continueSignDay 连续签到天数
     */
    public void setContinueSignDay(Integer continueSignDay) {
        this.continueSignDay = continueSignDay;
    }

    /**
     * 获取连续签到赠送数量
     *
     * @return continue_sign_point - 连续签到赠送数量
     */
    public Integer getContinueSignPoint() {
        return continueSignPoint;
    }

    /**
     * 设置连续签到赠送数量
     *
     * @param continueSignPoint 连续签到赠送数量
     */
    public void setContinueSignPoint(Integer continueSignPoint) {
        this.continueSignPoint = continueSignPoint;
    }

    /**
     * 获取每消费多少元获取1个点
     *
     * @return consume_per_point - 每消费多少元获取1个点
     */
    public BigDecimal getConsumePerPoint() {
        return consumePerPoint;
    }

    /**
     * 设置每消费多少元获取1个点
     *
     * @param consumePerPoint 每消费多少元获取1个点
     */
    public void setConsumePerPoint(BigDecimal consumePerPoint) {
        this.consumePerPoint = consumePerPoint;
    }

    /**
     * 获取最低获取点数的订单金额
     *
     * @return low_order_amount - 最低获取点数的订单金额
     */
    public BigDecimal getLowOrderAmount() {
        return lowOrderAmount;
    }

    /**
     * 设置最低获取点数的订单金额
     *
     * @param lowOrderAmount 最低获取点数的订单金额
     */
    public void setLowOrderAmount(BigDecimal lowOrderAmount) {
        this.lowOrderAmount = lowOrderAmount;
    }

    /**
     * 获取每笔订单最高获取点数
     *
     * @return max_point_per_order - 每笔订单最高获取点数
     */
    public Integer getMaxPointPerOrder() {
        return maxPointPerOrder;
    }

    /**
     * 设置每笔订单最高获取点数
     *
     * @param maxPointPerOrder 每笔订单最高获取点数
     */
    public void setMaxPointPerOrder(Integer maxPointPerOrder) {
        this.maxPointPerOrder = maxPointPerOrder;
    }

    /**
     * 获取类型：0->积分规则；1->成长值规则
     *
     * @return type - 类型：0->积分规则；1->成长值规则
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型：0->积分规则；1->成长值规则
     *
     * @param type 类型：0->积分规则；1->成长值规则
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