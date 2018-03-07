package com.huawei.com.rdsdemo.config.dynamic;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
@Configuration
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
@MapperScan(basePackages = "com.huawei.com.rdsdemo.mapper.dynamic", sqlSessionFactoryRef = "dynamicSqlSessionFacotry")
public class DynamicSqlSessionFactoryConfig {

    private final DataSource masterDataSource;
    private final DataSource slaveDataSource;

    @Autowired
    public DynamicSqlSessionFactoryConfig(@Qualifier("masterDataSource") DataSource masterDataSource,
                                          @Qualifier("slaveDataSource") DataSource slaveDataSource) {
        this.masterDataSource = masterDataSource;
        this.slaveDataSource = slaveDataSource;
    }

    @Bean("dynamicDataSource")
    public DynamicDataSource dataSource(){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource);
        Map<Object, Object> dsMap = new HashMap<>();
        dsMap.put("master", masterDataSource);
        dsMap.put("slave", slaveDataSource);
        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }

    @Bean(name = "dynamicSqlSessionFacotry")
    @Primary
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        return factoryBean.getObject();
    }
}
