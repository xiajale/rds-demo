package com.huawei.com.rdsdemo.model;

import java.util.Date;

public class Order {
    private String id;

    private String sellerId;

    private String purchaserId;

    private String goodId;

    private Date issueAt;

    private Date expireAt;

    private String arriveAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    public String getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(String purchaserId) {
        this.purchaserId = purchaserId == null ? null : purchaserId.trim();
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId == null ? null : goodId.trim();
    }

    public Date getIssueAt() {
        return issueAt;
    }

    public void setIssueAt(Date issueAt) {
        this.issueAt = issueAt;
    }

    public Date getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Date expireAt) {
        this.expireAt = expireAt;
    }

    public String getArriveAt() {
        return arriveAt;
    }

    public void setArriveAt(String arriveAt) {
        this.arriveAt = arriveAt == null ? null : arriveAt.trim();
    }
}