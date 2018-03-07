package com.huawei.com.rdsdemo.service.impl;

import com.huawei.com.rdsdemo.mapper.produce.GoodMapper;
import com.huawei.com.rdsdemo.model.Good;
import com.huawei.com.rdsdemo.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("goodService")
public class GoodServiceImpl implements GoodService {

    private final GoodMapper goodMapper;

    @Autowired
    public GoodServiceImpl(GoodMapper goodMapper) {
        this.goodMapper = goodMapper;
    }

    @Override
    public int add(Good good) {
        good.setId(UUID.randomUUID().toString());
        return goodMapper.insert(good);
    }

    @Override
    public int update(Good good, String id) {
        good.setId(id);
        return goodMapper.updateByPrimaryKey(good);
    }

    @Override
    public int delete(String id) {
        return goodMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Good find(String id) {
        return goodMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Good> findAll() {
        return goodMapper.selectAll();
    }
}
