package com.huawei.com.rdsdemo.service;

import com.huawei.com.rdsdemo.model.Purchaser;

import java.util.List;

public interface PurchaserService {

    int add(Purchaser purchaser);
    int update(Purchaser purchaser, String id);
    int delete(String id);
    Purchaser find(String id);
    List<Purchaser> findAll();

}
