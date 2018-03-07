package com.huawei.com.rdsdemo.model;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_seller")
public class Seller {

    @Id
    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}