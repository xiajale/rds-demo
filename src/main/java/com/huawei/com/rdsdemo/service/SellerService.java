package com.huawei.com.rdsdemo.service;

import com.huawei.com.rdsdemo.model.Seller;

import java.util.List;

public interface SellerService {

    int add(Seller seller);
    int update(Seller seller, String id);
    int delete(String id);
    Seller find(String id);
    List<Seller> findAll();

}
