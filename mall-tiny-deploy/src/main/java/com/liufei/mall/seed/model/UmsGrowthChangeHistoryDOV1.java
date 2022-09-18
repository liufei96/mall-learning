package com.liufei.mall.seed.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_ums_growth_change_history")
public class UmsGrowthChangeHistoryDOV1 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    /**
     * 改变类型：0->增加；1->减少
     */
    @Column(name = "change_type")
    private Integer changeType;

    /**
     * 积分改变数量
     */
    @Column(name = "change_count")
    private Integer changeCount;

    /**
     * 操作人员
     */
    @Column(name = "operate_man")
    private String operateMan;

    /**
     * 操作备注
     */
    @Column(name = "operate_note")
    private String operateNote;

    /**
     * 积分来源：0->购物；1->管理员修改
     */
    @Column(name = "source_type")
    private Integer sourceType;

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
     * @return member_id
     */
    public Long getMemberId() {
        return memberId;
    }

    /**
     * @param memberId
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    /**
     * 获取改变类型：0->增加；1->减少
     *
     * @return change_type - 改变类型：0->增加；1->减少
     */
    public Integer getChangeType() {
        return changeType;
    }

    /**
     * 设置改变类型：0->增加；1->减少
     *
     * @param changeType 改变类型：0->增加；1->减少
     */
    public void setChangeType(Integer changeType) {
        this.changeType = changeType;
    }

    /**
     * 获取积分改变数量
     *
     * @return change_count - 积分改变数量
     */
    public Integer getChangeCount() {
        return changeCount;
    }

    /**
     * 设置积分改变数量
     *
     * @param changeCount 积分改变数量
     */
    public void setChangeCount(Integer changeCount) {
        this.changeCount = changeCount;
    }

    /**
     * 获取操作人员
     *
     * @return operate_man - 操作人员
     */
    public String getOperateMan() {
        return operateMan;
    }

    /**
     * 设置操作人员
     *
     * @param operateMan 操作人员
     */
    public void setOperateMan(String operateMan) {
        this.operateMan = operateMan == null ? null : operateMan.trim();
    }

    /**
     * 获取操作备注
     *
     * @return operate_note - 操作备注
     */
    public String getOperateNote() {
        return operateNote;
    }

    /**
     * 设置操作备注
     *
     * @param operateNote 操作备注
     */
    public void setOperateNote(String operateNote) {
        this.operateNote = operateNote == null ? null : operateNote.trim();
    }

    /**
     * 获取积分来源：0->购物；1->管理员修改
     *
     * @return source_type - 积分来源：0->购物；1->管理员修改
     */
    public Integer getSourceType() {
        return sourceType;
    }

    /**
     * 设置积分来源：0->购物；1->管理员修改
     *
     * @param sourceType 积分来源：0->购物；1->管理员修改
     */
    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
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