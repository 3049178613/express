package com.yidu.express_order.entity;

import java.io.Serializable;

/**
 * @description： 下单数据类,用于存放用户下单时存放的数据
 * @author：彭杰成
 * @date：2021/4/13 0013下午 7:03
 * @version：1.0
 */
public class PlaceAnOrderData implements Serializable {
    /**
     * 寄件人名
     */
    private String sendName;
    /**
     * 收件人名
     */
    private String recName;
    /**
     * 寄件联系电话
     */
    private String sendMobile;
    /**
     * 收件联系电话
     */
    private String recMobile;
    /**
     * 寄件地址
     */
    private String sendAddress;
    /**
     * 寄件详细地址
     */
    private String sendAddr;
    /**
     * 收件地址
     */
    private String recAddress;
    /**
     * 收件详细地址
     */
    private String recAddr;
    /**
     * 物品类型
     */
    private String goodsType;
    /**
     * 物品重量
     */
    private Integer goodsWeight;

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public String getRecName() {
        return recName;
    }

    public void setRecName(String recName) {
        this.recName = recName;
    }

    public String getSendMobile() {
        return sendMobile;
    }

    public void setSendMobile(String sendMobile) {
        this.sendMobile = sendMobile;
    }

    public String getRecMobile() {
        return recMobile;
    }

    public void setRecMobile(String recMobile) {
        this.recMobile = recMobile;
    }

    public String getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
    }

    public String getSendAddr() {
        return sendAddr;
    }

    public void setSendAddr(String sendAddr) {
        this.sendAddr = sendAddr;
    }

    public String getRecAddress() {
        return recAddress;
    }

    public void setRecAddress(String recAddress) {
        this.recAddress = recAddress;
    }

    public String getRecAddr() {
        return recAddr;
    }

    public void setRecAddr(String recAddr) {
        this.recAddr = recAddr;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public Integer getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(Integer goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    @Override
    public String toString() {
        return "PlaceAnOrderData{" +
                "sendName='" + sendName + '\'' +
                ", recName='" + recName + '\'' +
                ", sendMobile='" + sendMobile + '\'' +
                ", recMobile='" + recMobile + '\'' +
                ", sendAddress='" + sendAddress + '\'' +
                ", sendAddr='" + sendAddr + '\'' +
                ", recAddress='" + recAddress + '\'' +
                ", recAddr='" + recAddr + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", goodsWeight=" + goodsWeight +
                '}';
    }
}
