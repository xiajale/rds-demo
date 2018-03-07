package com.huawei.com.rdsdemo.service;

import com.huawei.com.rdsdemo.model.Good;

import java.util.List;

public interface GoodService {

    int add(Good good);
    int update(Good good, String id);
    int delete(String id);
    Good find(String id);
    List<Good> findAll();

}
