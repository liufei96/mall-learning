package com.liufei.mall.seed.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_cms_member_report")
public class CmsMemberReportDOV1 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 举报类型：0->商品评价；1->话题内容；2->用户评论
     */
    @Column(name = "report_type")
    private Integer reportType;

    /**
     * 举报人
     */
    @Column(name = "report_member_name")
    private String reportMemberName;

    @Column(name = "report_object")
    private String reportObject;

    /**
     * 举报状态：0->未处理；1->已处理
     */
    @Column(name = "report_status")
    private Integer reportStatus;

    /**
     * 处理结果：0->无效；1->有效；2->恶意
     */
    @Column(name = "handle_status")
    private Integer handleStatus;

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
     * 获取举报类型：0->商品评价；1->话题内容；2->用户评论
     *
     * @return report_type - 举报类型：0->商品评价；1->话题内容；2->用户评论
     */
    public Integer getReportType() {
        return reportType;
    }

    /**
     * 设置举报类型：0->商品评价；1->话题内容；2->用户评论
     *
     * @param reportType 举报类型：0->商品评价；1->话题内容；2->用户评论
     */
    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }

    /**
     * 获取举报人
     *
     * @return report_member_name - 举报人
     */
    public String getReportMemberName() {
        return reportMemberName;
    }

    /**
     * 设置举报人
     *
     * @param reportMemberName 举报人
     */
    public void setReportMemberName(String reportMemberName) {
        this.reportMemberName = reportMemberName == null ? null : reportMemberName.trim();
    }

    /**
     * @return report_object
     */
    public String getReportObject() {
        return reportObject;
    }

    /**
     * @param reportObject
     */
    public void setReportObject(String reportObject) {
        this.reportObject = reportObject == null ? null : reportObject.trim();
    }

    /**
     * 获取举报状态：0->未处理；1->已处理
     *
     * @return report_status - 举报状态：0->未处理；1->已处理
     */
    public Integer getReportStatus() {
        return reportStatus;
    }

    /**
     * 设置举报状态：0->未处理；1->已处理
     *
     * @param reportStatus 举报状态：0->未处理；1->已处理
     */
    public void setReportStatus(Integer reportStatus) {
        this.reportStatus = reportStatus;
    }

    /**
     * 获取处理结果：0->无效；1->有效；2->恶意
     *
     * @return handle_status - 处理结果：0->无效；1->有效；2->恶意
     */
    public Integer getHandleStatus() {
        return handleStatus;
    }

    /**
     * 设置处理结果：0->无效；1->有效；2->恶意
     *
     * @param handleStatus 处理结果：0->无效；1->有效；2->恶意
     */
    public void setHandleStatus(Integer handleStatus) {
        this.handleStatus = handleStatus;
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