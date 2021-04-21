package com.yidu.express_order.entity;

import java.io.Serializable;

/**
 * (Address)实体类
 *
 * @author makejava
 * @since 2021-04-20 11:50:40
 */
public class Address implements Serializable {
    private static final long serialVersionUID = -36629759172555766L;
    /**
     * 主键
     */
    private Integer addressId;
    /**
     *客户表主键
     */
    private Integer customerId;
    /**
     * 地址类型
     * 1 = 发货地址
     * 2 = 收货地址
     */
    private Integer addressState;
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
    /**
     * 地址状态
     * 1=可以用
     * 0=不可用
     */
    private Integer state;
    /**
     * 添加时间(相同地址不添加数据,只更新时间)
     */
    private String addressTime;


    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getAddressState() {
        return addressState;
    }

    public void setAddressState(Integer addressState) {
        this.addressState = addressState;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getAddressTime() {
        return addressTime;
    }

    public void setAddressTime(String addressTime) {
        this.addressTime = addressTime;
    }
}