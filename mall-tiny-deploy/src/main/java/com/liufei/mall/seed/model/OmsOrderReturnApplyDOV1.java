package com.liufei.mall.seed.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_oms_order_return_apply")
public class OmsOrderReturnApplyDOV1 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 订单id
     */
    @Column(name = "order_id")
    private Long orderId;

    /**
     * 收货地址表id
     */
    @Column(name = "company_address_id")
    private Long companyAddressId;

    /**
     * 退货商品id
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 订单编号
     */
    @Column(name = "order_sn")
    private String orderSn;

    /**
     * 会员用户名
     */
    @Column(name = "member_username")
    private String memberUsername;

    /**
     * 退款金额
     */
    @Column(name = "return_amount")
    private BigDecimal returnAmount;

    /**
     * 退货人姓名
     */
    @Column(name = "return_name")
    private String returnName;

    /**
     * 退货人电话
     */
    @Column(name = "return_phone")
    private String returnPhone;

    /**
     * 申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝
     */
    private Integer status;

    /**
     * 处理时间
     */
    @Column(name = "handle_time")
    private Date handleTime;

    /**
     * 商品图片
     */
    @Column(name = "product_pic")
    private String productPic;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 商品品牌
     */
    @Column(name = "product_brand")
    private String productBrand;

    /**
     * 商品销售属性：颜色：红色；尺码：xl;
     */
    @Column(name = "product_attr")
    private String productAttr;

    /**
     * 退货数量
     */
    @Column(name = "product_count")
    private Integer productCount;

    /**
     * 商品单价
     */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /**
     * 商品实际支付单价
     */
    @Column(name = "product_real_price")
    private BigDecimal productRealPrice;

    /**
     * 原因
     */
    private String reason;

    /**
     * 描述
     */
    private String description;

    /**
     * 凭证图片，以逗号隔开
     */
    @Column(name = "proof_pics")
    private String proofPics;

    /**
     * 处理备注
     */
    @Column(name = "handle_note")
    private String handleNote;

    /**
     * 处理人员
     */
    @Column(name = "handle_man")
    private String handleMan;

    /**
     * 收货人
     */
    @Column(name = "receive_man")
    private String receiveMan;

    /**
     * 收货时间
     */
    @Column(name = "receive_time")
    private Date receiveTime;

    /**
     * 收货备注
     */
    @Column(name = "receive_note")
    private String receiveNote;

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
     * 获取订单id
     *
     * @return order_id - 订单id
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置订单id
     *
     * @param orderId 订单id
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取收货地址表id
     *
     * @return company_address_id - 收货地址表id
     */
    public Long getCompanyAddressId() {
        return companyAddressId;
    }

    /**
     * 设置收货地址表id
     *
     * @param companyAddressId 收货地址表id
     */
    public void setCompanyAddressId(Long companyAddressId) {
        this.companyAddressId = companyAddressId;
    }

    /**
     * 获取退货商品id
     *
     * @return product_id - 退货商品id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 设置退货商品id
     *
     * @param productId 退货商品id
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 获取订单编号
     *
     * @return order_sn - 订单编号
     */
    public String getOrderSn() {
        return orderSn;
    }

    /**
     * 设置订单编号
     *
     * @param orderSn 订单编号
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }

    /**
     * 获取会员用户名
     *
     * @return member_username - 会员用户名
     */
    public String getMemberUsername() {
        return memberUsername;
    }

    /**
     * 设置会员用户名
     *
     * @param memberUsername 会员用户名
     */
    public void setMemberUsername(String memberUsername) {
        this.memberUsername = memberUsername == null ? null : memberUsername.trim();
    }

    /**
     * 获取退款金额
     *
     * @return return_amount - 退款金额
     */
    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    /**
     * 设置退款金额
     *
     * @param returnAmount 退款金额
     */
    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }

    /**
     * 获取退货人姓名
     *
     * @return return_name - 退货人姓名
     */
    public String getReturnName() {
        return returnName;
    }

    /**
     * 设置退货人姓名
     *
     * @param returnName 退货人姓名
     */
    public void setReturnName(String returnName) {
        this.returnName = returnName == null ? null : returnName.trim();
    }

    /**
     * 获取退货人电话
     *
     * @return return_phone - 退货人电话
     */
    public String getReturnPhone() {
        return returnPhone;
    }

    /**
     * 设置退货人电话
     *
     * @param returnPhone 退货人电话
     */
    public void setReturnPhone(String returnPhone) {
        this.returnPhone = returnPhone == null ? null : returnPhone.trim();
    }

    /**
     * 获取申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝
     *
     * @return status - 申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝
     *
     * @param status 申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取处理时间
     *
     * @return handle_time - 处理时间
     */
    public Date getHandleTime() {
        return handleTime;
    }

    /**
     * 设置处理时间
     *
     * @param handleTime 处理时间
     */
    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    /**
     * 获取商品图片
     *
     * @return product_pic - 商品图片
     */
    public String getProductPic() {
        return productPic;
    }

    /**
     * 设置商品图片
     *
     * @param productPic 商品图片
     */
    public void setProductPic(String productPic) {
        this.productPic = productPic == null ? null : productPic.trim();
    }

    /**
     * 获取商品名称
     *
     * @return product_name - 商品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置商品名称
     *
     * @param productName 商品名称
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * 获取商品品牌
     *
     * @return product_brand - 商品品牌
     */
    public String getProductBrand() {
        return productBrand;
    }

    /**
     * 设置商品品牌
     *
     * @param productBrand 商品品牌
     */
    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand == null ? null : productBrand.trim();
    }

    /**
     * 获取商品销售属性：颜色：红色；尺码：xl;
     *
     * @return product_attr - 商品销售属性：颜色：红色；尺码：xl;
     */
    public String getProductAttr() {
        return productAttr;
    }

    /**
     * 设置商品销售属性：颜色：红色；尺码：xl;
     *
     * @param productAttr 商品销售属性：颜色：红色；尺码：xl;
     */
    public void setProductAttr(String productAttr) {
        this.productAttr = productAttr == null ? null : productAttr.trim();
    }

    /**
     * 获取退货数量
     *
     * @return product_count - 退货数量
     */
    public Integer getProductCount() {
        return productCount;
    }

    /**
     * 设置退货数量
     *
     * @param productCount 退货数量
     */
    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    /**
     * 获取商品单价
     *
     * @return product_price - 商品单价
     */
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    /**
     * 设置商品单价
     *
     * @param productPrice 商品单价
     */
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * 获取商品实际支付单价
     *
     * @return product_real_price - 商品实际支付单价
     */
    public BigDecimal getProductRealPrice() {
        return productRealPrice;
    }

    /**
     * 设置商品实际支付单价
     *
     * @param productRealPrice 商品实际支付单价
     */
    public void setProductRealPrice(BigDecimal productRealPrice) {
        this.productRealPrice = productRealPrice;
    }

    /**
     * 获取原因
     *
     * @return reason - 原因
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置原因
     *
     * @param reason 原因
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取凭证图片，以逗号隔开
     *
     * @return proof_pics - 凭证图片，以逗号隔开
     */
    public String getProofPics() {
        return proofPics;
    }

    /**
     * 设置凭证图片，以逗号隔开
     *
     * @param proofPics 凭证图片，以逗号隔开
     */
    public void setProofPics(String proofPics) {
        this.proofPics = proofPics == null ? null : proofPics.trim();
    }

    /**
     * 获取处理备注
     *
     * @return handle_note - 处理备注
     */
    public String getHandleNote() {
        return handleNote;
    }

    /**
     * 设置处理备注
     *
     * @param handleNote 处理备注
     */
    public void setHandleNote(String handleNote) {
        this.handleNote = handleNote == null ? null : handleNote.trim();
    }

    /**
     * 获取处理人员
     *
     * @return handle_man - 处理人员
     */
    public String getHandleMan() {
        return handleMan;
    }

    /**
     * 设置处理人员
     *
     * @param handleMan 处理人员
     */
    public void setHandleMan(String handleMan) {
        this.handleMan = handleMan == null ? null : handleMan.trim();
    }

    /**
     * 获取收货人
     *
     * @return receive_man - 收货人
     */
    public String getReceiveMan() {
        return receiveMan;
    }

    /**
     * 设置收货人
     *
     * @param receiveMan 收货人
     */
    public void setReceiveMan(String receiveMan) {
        this.receiveMan = receiveMan == null ? null : receiveMan.trim();
    }

    /**
     * 获取收货时间
     *
     * @return receive_time - 收货时间
     */
    public Date getReceiveTime() {
        return receiveTime;
    }

    /**
     * 设置收货时间
     *
     * @param receiveTime 收货时间
     */
    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    /**
     * 获取收货备注
     *
     * @return receive_note - 收货备注
     */
    public String getReceiveNote() {
        return receiveNote;
    }

    /**
     * 设置收货备注
     *
     * @param receiveNote 收货备注
     */
    public void setReceiveNote(String receiveNote) {
        this.receiveNote = receiveNote == null ? null : receiveNote.trim();
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