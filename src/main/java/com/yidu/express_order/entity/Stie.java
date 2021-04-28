package com.yidu.express_order.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Stie)实体类
 *
 * @author makejava
 * @since 2021-04-27 15:06:03
 */
@Component
public class Stie implements Serializable {
    private static final long serialVersionUID = 326482950699951529L;
    /**
    * 网点id
    */
    private Integer stieId;
    /**
    * 网点地址
    */
    private String stieAddress;
    /**
    * 网点类型 1：省 2:市 3：区 4：街道
    */
    private Integer stieLevel;
    /**
    * 父级id
    */
    private String parentId;
    /**
    * 子级id
    */
    private String childrenId;


    public Integer getStieId() {
        return stieId;
    }

    public void setStieId(Integer stieId) {
        this.stieId = stieId;
    }

    public String getStieAddress() {
        return stieAddress;
    }

    public void setStieAddress(String stieAddress) {
        this.stieAddress = stieAddress;
    }

    public Integer getStieLevel() {
        return stieLevel;
    }

    public void setStieLevel(Integer stieLevel) {
        this.stieLevel = stieLevel;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getChildrenId() {
        return childrenId;
    }

    public void setChildrenId(String childrenId) {
        this.childrenId = childrenId;
    }

}