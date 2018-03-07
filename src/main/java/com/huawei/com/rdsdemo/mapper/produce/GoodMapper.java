package com.huawei.com.rdsdemo.mapper.produce;

import com.huawei.com.rdsdemo.model.Good;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

@Repository
public interface GoodMapper extends BaseMapper<Good> {
}
