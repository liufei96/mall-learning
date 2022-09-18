package com.liufei.mall.seed.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_ums_member_level")
public class UmsMemberLevelDOV1 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "growth_point")
    private Integer growthPoint;

    /**
     * 是否为默认等级：0->不是；1->是
     */
    @Column(name = "default_status")
    private Integer defaultStatus;

    /**
     * 免运费标准
     */
    @Column(name = "free_freight_point")
    private BigDecimal freeFreightPoint;

    /**
     * 每次评价获取的成长值
     */
    @Column(name = "comment_growth_point")
    private Integer commentGrowthPoint;

    /**
     * 是否有免邮特权
     */
    @Column(name = "privilege_free_freight")
    private Integer privilegeFreeFreight;

    /**
     * 是否有签到特权
     */
    @Column(name = "privilege_sign_in")
    private Integer privilegeSignIn;

    /**
     * 是否有评论获奖励特权
     */
    @Column(name = "privilege_comment")
    private Integer privilegeComment;

    /**
     * 是否有专享活动特权
     */
    @Column(name = "privilege_promotion")
    private Integer privilegePromotion;

    /**
     * 是否有会员价格特权
     */
    @Column(name = "privilege_member_price")
    private Integer privilegeMemberPrice;

    /**
     * 是否有生日特权
     */
    @Column(name = "privilege_birthday")
    private Integer privilegeBirthday;

    private String note;

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
     * @return growth_point
     */
    public Integer getGrowthPoint() {
        return growthPoint;
    }

    /**
     * @param growthPoint
     */
    public void setGrowthPoint(Integer growthPoint) {
        this.growthPoint = growthPoint;
    }

    /**
     * 获取是否为默认等级：0->不是；1->是
     *
     * @return default_status - 是否为默认等级：0->不是；1->是
     */
    public Integer getDefaultStatus() {
        return defaultStatus;
    }

    /**
     * 设置是否为默认等级：0->不是；1->是
     *
     * @param defaultStatus 是否为默认等级：0->不是；1->是
     */
    public void setDefaultStatus(Integer defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    /**
     * 获取免运费标准
     *
     * @return free_freight_point - 免运费标准
     */
    public BigDecimal getFreeFreightPoint() {
        return freeFreightPoint;
    }

    /**
     * 设置免运费标准
     *
     * @param freeFreightPoint 免运费标准
     */
    public void setFreeFreightPoint(BigDecimal freeFreightPoint) {
        this.freeFreightPoint = freeFreightPoint;
    }

    /**
     * 获取每次评价获取的成长值
     *
     * @return comment_growth_point - 每次评价获取的成长值
     */
    public Integer getCommentGrowthPoint() {
        return commentGrowthPoint;
    }

    /**
     * 设置每次评价获取的成长值
     *
     * @param commentGrowthPoint 每次评价获取的成长值
     */
    public void setCommentGrowthPoint(Integer commentGrowthPoint) {
        this.commentGrowthPoint = commentGrowthPoint;
    }

    /**
     * 获取是否有免邮特权
     *
     * @return privilege_free_freight - 是否有免邮特权
     */
    public Integer getPrivilegeFreeFreight() {
        return privilegeFreeFreight;
    }

    /**
     * 设置是否有免邮特权
     *
     * @param privilegeFreeFreight 是否有免邮特权
     */
    public void setPrivilegeFreeFreight(Integer privilegeFreeFreight) {
        this.privilegeFreeFreight = privilegeFreeFreight;
    }

    /**
     * 获取是否有签到特权
     *
     * @return privilege_sign_in - 是否有签到特权
     */
    public Integer getPrivilegeSignIn() {
        return privilegeSignIn;
    }

    /**
     * 设置是否有签到特权
     *
     * @param privilegeSignIn 是否有签到特权
     */
    public void setPrivilegeSignIn(Integer privilegeSignIn) {
        this.privilegeSignIn = privilegeSignIn;
    }

    /**
     * 获取是否有评论获奖励特权
     *
     * @return privilege_comment - 是否有评论获奖励特权
     */
    public Integer getPrivilegeComment() {
        return privilegeComment;
    }

    /**
     * 设置是否有评论获奖励特权
     *
     * @param privilegeComment 是否有评论获奖励特权
     */
    public void setPrivilegeComment(Integer privilegeComment) {
        this.privilegeComment = privilegeComment;
    }

    /**
     * 获取是否有专享活动特权
     *
     * @return privilege_promotion - 是否有专享活动特权
     */
    public Integer getPrivilegePromotion() {
        return privilegePromotion;
    }

    /**
     * 设置是否有专享活动特权
     *
     * @param privilegePromotion 是否有专享活动特权
     */
    public void setPrivilegePromotion(Integer privilegePromotion) {
        this.privilegePromotion = privilegePromotion;
    }

    /**
     * 获取是否有会员价格特权
     *
     * @return privilege_member_price - 是否有会员价格特权
     */
    public Integer getPrivilegeMemberPrice() {
        return privilegeMemberPrice;
    }

    /**
     * 设置是否有会员价格特权
     *
     * @param privilegeMemberPrice 是否有会员价格特权
     */
    public void setPrivilegeMemberPrice(Integer privilegeMemberPrice) {
        this.privilegeMemberPrice = privilegeMemberPrice;
    }

    /**
     * 获取是否有生日特权
     *
     * @return privilege_birthday - 是否有生日特权
     */
    public Integer getPrivilegeBirthday() {
        return privilegeBirthday;
    }

    /**
     * 设置是否有生日特权
     *
     * @param privilegeBirthday 是否有生日特权
     */
    public void setPrivilegeBirthday(Integer privilegeBirthday) {
        this.privilegeBirthday = privilegeBirthday;
    }

    /**
     * @return note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
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