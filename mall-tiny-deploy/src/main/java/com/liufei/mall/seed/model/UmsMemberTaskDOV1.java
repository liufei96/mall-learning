package com.liufei.mall.seed.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_ums_member_task")
public class UmsMemberTaskDOV1 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * 赠送成长值
     */
    private Integer growth;

    /**
     * 赠送积分
     */
    private Integer integration;

    /**
     * 任务类型：0->新手任务；1->日常任务
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
     * 获取赠送成长值
     *
     * @return growth - 赠送成长值
     */
    public Integer getGrowth() {
        return growth;
    }

    /**
     * 设置赠送成长值
     *
     * @param growth 赠送成长值
     */
    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    /**
     * 获取赠送积分
     *
     * @return integration - 赠送积分
     */
    public Integer getIntegration() {
        return integration;
    }

    /**
     * 设置赠送积分
     *
     * @param integration 赠送积分
     */
    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    /**
     * 获取任务类型：0->新手任务；1->日常任务
     *
     * @return type - 任务类型：0->新手任务；1->日常任务
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置任务类型：0->新手任务；1->日常任务
     *
     * @param type 任务类型：0->新手任务；1->日常任务
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