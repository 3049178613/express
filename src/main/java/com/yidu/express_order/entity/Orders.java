package com.yidu.express_order.entity;

import java.io.Serializable;

/**
 * (Orders)实体类
 *
 * @author makejava
 * @since 2021-04-26 14:38:02
 */
public class Orders implements Serializable {
    private static final long serialVersionUID = 223062412269309961L;
    /**
     * 主键
     */
    private Integer orderId;
    /**
     * 客户表主键
     */
    private Integer customerId;
    /**
     * 下单时间
     */
    private String ordertime;
    /**
     * 订单状态
     * 0=取消
     * 1=正常
     * 2=揽收
     * 3=派送
     * 4=到货
     * 5=退货
     */
    private Integer orderstate;
    /**
     * 订单号
     */
    private String ordernumber;
    /**
     * 收货地址主键
     */
    private Integer addressIdDirection;
    /**
     * 寄货地址主键
     */
    private Integer addressIdSender;
    /**
     * 支付方式
     */
    private Integer payWay;
    /**
     * 更新订单时间
     */
    private String updatetime;
    /**
     * 用户表主键
     */
    private Integer userId;
    /**
     * 取消订单原因
     */
    private String reasonofcancellation;


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public Integer getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(Integer orderstate) {
        this.orderstate = orderstate;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    public Integer getAddressIdDirection() {
        return addressIdDirection;
    }

    public void setAddressIdDirection(Integer addressIdDirection) {
        this.addressIdDirection = addressIdDirection;
    }

    public Integer getAddressIdSender() {
        return addressIdSender;
    }

    public void setAddressIdSender(Integer addressIdSender) {
        this.addressIdSender = addressIdSender;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReasonofcancellation() {
        return reasonofcancellation;
    }

    public void setReasonofcancellation(String reasonofcancellation) {
        this.reasonofcancellation = reasonofcancellation;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", ordertime='" + ordertime + '\'' +
                ", orderstate=" + orderstate +
                ", ordernumber='" + ordernumber + '\'' +
                ", addressIdDirection=" + addressIdDirection +
                ", addressIdSender=" + addressIdSender +
                ", payWay=" + payWay +
                ", updatetime='" + updatetime + '\'' +
                ", userId=" + userId +
                ", reasonofcancellation='" + reasonofcancellation + '\'' +
                '}';
    }
}