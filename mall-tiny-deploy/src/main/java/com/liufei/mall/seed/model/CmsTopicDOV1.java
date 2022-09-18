package com.liufei.mall.seed.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_cms_topic")
public class CmsTopicDOV1 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    private String name;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    /**
     * 参与人数
     */
    @Column(name = "attend_count")
    private Integer attendCount;

    /**
     * 关注人数
     */
    @Column(name = "attention_count")
    private Integer attentionCount;

    @Column(name = "read_count")
    private Integer readCount;

    /**
     * 奖品名称
     */
    @Column(name = "award_name")
    private String awardName;

    /**
     * 参与方式
     */
    @Column(name = "attend_type")
    private String attendType;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 是否删除，0 是未删除，1是已删除。默认为0
     */
    @Column(name = "is_deleted")
    private Byte deleted;

    /**
     * 话题内容
     */
    private String content;

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
     * @return category_id
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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
     * 获取参与人数
     *
     * @return attend_count - 参与人数
     */
    public Integer getAttendCount() {
        return attendCount;
    }

    /**
     * 设置参与人数
     *
     * @param attendCount 参与人数
     */
    public void setAttendCount(Integer attendCount) {
        this.attendCount = attendCount;
    }

    /**
     * 获取关注人数
     *
     * @return attention_count - 关注人数
     */
    public Integer getAttentionCount() {
        return attentionCount;
    }

    /**
     * 设置关注人数
     *
     * @param attentionCount 关注人数
     */
    public void setAttentionCount(Integer attentionCount) {
        this.attentionCount = attentionCount;
    }

    /**
     * @return read_count
     */
    public Integer getReadCount() {
        return readCount;
    }

    /**
     * @param readCount
     */
    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    /**
     * 获取奖品名称
     *
     * @return award_name - 奖品名称
     */
    public String getAwardName() {
        return awardName;
    }

    /**
     * 设置奖品名称
     *
     * @param awardName 奖品名称
     */
    public void setAwardName(String awardName) {
        this.awardName = awardName == null ? null : awardName.trim();
    }

    /**
     * 获取参与方式
     *
     * @return attend_type - 参与方式
     */
    public String getAttendType() {
        return attendType;
    }

    /**
     * 设置参与方式
     *
     * @param attendType 参与方式
     */
    public void setAttendType(String attendType) {
        this.attendType = attendType == null ? null : attendType.trim();
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

    /**
     * 获取话题内容
     *
     * @return content - 话题内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置话题内容
     *
     * @param content 话题内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}