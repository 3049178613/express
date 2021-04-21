package com.yidu.express_order.entity;

import java.io.Serializable;

/**
 * @description： 查询订单时数据 实现类
 * @author：彭杰成
 * @date：2021/4/21 0021上午 11:05
 * @version：1.0
 */
public class ShowOrderModel implements Serializable {
    /**
     * 主键
     */
    private Integer orderId;
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
     * 更新订单时间
     */
    private String updatetime;
    /**
     * 联系电话
     */
    private String addressPhone;
    /**
     * 联系人名称
     */
    private String addressName;
    /**
     * 邮编号码
     */
    private String postcode;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String district;
    /**
     * 街道(详细地址)
     */
    private String street;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
