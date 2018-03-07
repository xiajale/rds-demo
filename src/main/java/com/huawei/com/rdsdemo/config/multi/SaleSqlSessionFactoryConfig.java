package com.huawei.com.rdsdemo.config.multi;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

@Component
@Configuration
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
@MapperScan(basePackages = "com.huawei.com.rdsdemo.mapper.sale", sqlSessionFactoryRef = "saleSqlSessionFactory")
public class SaleSqlSessionFactoryConfig {

    @Bean(name = "saleDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.multi.sale")
    public DataSource dataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "saleSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        return factoryBean.getObject();
    }
}
