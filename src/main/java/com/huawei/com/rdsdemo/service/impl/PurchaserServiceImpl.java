package com.huawei.com.rdsdemo.service.impl;

import com.huawei.com.rdsdemo.config.dynamic.DS;
import com.huawei.com.rdsdemo.mapper.dynamic.PurchaserMapper;
import com.huawei.com.rdsdemo.model.Purchaser;
import com.huawei.com.rdsdemo.service.PurchaserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("purchaserService")
public class PurchaserServiceImpl implements PurchaserService {

    private final PurchaserMapper purchaserMapper;

    @Autowired
    public PurchaserServiceImpl(PurchaserMapper purchaserMapper) {
        this.purchaserMapper = purchaserMapper;
    }

    @Override
    public int add(Purchaser purchaser) {
        purchaser.setId(UUID.randomUUID().toString());
        slaveAdd(purchaser);
        return masterAdd(purchaser);
    }

    @Override
    public int update(Purchaser purchaser, String id) {
        slaveUpdate(purchaser, id);
        return masterUpdate(purchaser, id);
    }

    @Override
    public int delete(String id) {
        slaveDelete(id);
        return masterDelete(id);
    }

    @Override
    public Purchaser find(String id) {
        return masterFind(id);
    }

    @Override
    public List<Purchaser> findAll() {
        return slaveFindAll();
    }

    @DS("master")
    private int masterAdd(Purchaser purchaser) {
        return purchaserMapper.insert(purchaser);
    }

    @DS("slave")
    private int slaveAdd(Purchaser purchaser) {
        return purchaserMapper.insert(purchaser);
    }

    @DS("master")
    private int masterUpdate(Purchaser purchaser, String id) {
        purchaser.setId(id);
        return purchaserMapper.updateByPrimaryKey(purchaser);
    }

    @DS("slave")
    private int slaveUpdate(Purchaser purchaser, String id) {
        purchaser.setId(id);
        return purchaserMapper.updateByPrimaryKey(purchaser);
    }

    @DS("master")
    public int masterDelete(String id) {
        return purchaserMapper.deleteByPrimaryKey(id);
    }

    @DS("slave")
    public int slaveDelete(String id) {
        return purchaserMapper.deleteByPrimaryKey(id);
    }

    @DS("master")
    public Purchaser masterFind(String id) {
        return purchaserMapper.selectByPrimaryKey(id);
    }

    @DS("slave")
    public Purchaser slaveFind(String id) {
        return purchaserMapper.selectByPrimaryKey(id);
    }

    @DS("master")
    public List<Purchaser> masterFindAll() {
        return purchaserMapper.selectAll();
    }

    @DS("slave")
    public List<Purchaser> slaveFindAll() {
        return purchaserMapper.selectAll();
    }
}
