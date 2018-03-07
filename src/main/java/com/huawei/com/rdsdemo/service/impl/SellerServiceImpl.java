package com.huawei.com.rdsdemo.service.impl;

import com.huawei.com.rdsdemo.config.dynamic.DS;
import com.huawei.com.rdsdemo.mapper.dynamic.SellerMapper;
import com.huawei.com.rdsdemo.model.Seller;
import com.huawei.com.rdsdemo.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("sellerService")
public class SellerServiceImpl implements SellerService {

    private final SellerMapper sellerMapper;

    @Autowired
    public SellerServiceImpl(SellerMapper sellerMapper) {
        this.sellerMapper = sellerMapper;
    }

    @Override
    public int add(Seller seller) {
        seller.setId(UUID.randomUUID().toString());
        slaveAdd(seller);
        return masterAdd(seller);
    }

    @Override
    public int update(Seller seller, String id) {
        slaveUpdate(seller, id);
        return masterUpdate(seller, id);
    }

    @Override
    public int delete(String id) {
        slaveDelete(id);
        return masterDelete(id);
    }

    @Override
    public Seller find(String id) {
        return masterFind(id);
    }

    @Override
    public List<Seller> findAll() {
        return slaveFindAll();
    }

    @DS("master")
    public int masterAdd(Seller seller) {
        return sellerMapper.insert(seller);
    }

    @DS("slave")
    public int slaveAdd(Seller seller) {
        return sellerMapper.insert(seller);
    }

    @DS("master")
    public int masterUpdate(Seller seller, String id) {
        seller.setId(id);
        return sellerMapper.updateByPrimaryKey(seller);
    }

    @DS("slave")
    public int slaveUpdate(Seller seller, String id) {
        seller.setId(id);
        return sellerMapper.updateByPrimaryKey(seller);
    }

    @DS("master")
    public int masterDelete(String id) {
        return sellerMapper.deleteByPrimaryKey(id);
    }

    @DS("slave")
    public int slaveDelete(String id) {
        return sellerMapper.deleteByPrimaryKey(id);
    }

    @DS("master")
    public Seller masterFind(String id) {
        return sellerMapper.selectByPrimaryKey(id);
    }

    @DS("slave")
    public Seller slaveFind(String id) {
        return sellerMapper.selectByPrimaryKey(id);
    }

    @DS("master")
    public List<Seller> masterFindAll() {
        return sellerMapper.selectAll();
    }

    @DS("slave")
    public List<Seller> slaveFindAll() {
        return sellerMapper.selectAll();
    }
}
