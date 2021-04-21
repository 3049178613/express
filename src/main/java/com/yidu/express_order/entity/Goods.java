package com.yidu.express_order.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Goods)实体类
 *
 * @author makejava
 * @since 2021-04-15 11:23:41
 */
@Component
public class Goods implements Serializable {
    private static final long serialVersionUID = 126737343839431319L;
    
    private Integer goodsId;
    
    private String goodstype;
    
    private Object goodsweight;
    
    private Object estimateprice;
    
    private Integer number;
    
    private Integer goodsState;
    
    private String audit;
    
    private String auditopinion;
    
    private Integer stieId;
    
    private String barcode;
    
    private Integer orderId;


    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodstype() {
        return goodstype;
    }

    public void setGoodstype(String goodstype) {
        this.goodstype = goodstype;
    }

    public Object getGoodsweight() {
        return goodsweight;
    }

    public void setGoodsweight(Object goodsweight) {
        this.goodsweight = goodsweight;
    }

    public Object getEstimateprice() {
        return estimateprice;
    }

    public void setEstimateprice(Object estimateprice) {
        this.estimateprice = estimateprice;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(Integer goodsState) {
        this.goodsState = goodsState;
    }

    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit;
    }

    public String getAuditopinion() {
        return auditopinion;
    }

    public void setAuditopinion(String auditopinion) {
        this.auditopinion = auditopinion;
    }

    public Integer getStieId() {
        return stieId;
    }

    public void setStieId(Integer stieId) {
        this.stieId = stieId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

}