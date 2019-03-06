package com.xjb.data.provider.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by xjb on 2019/3/6
 **/
@Configuration
@MapperScan(basePackages = "com.xjb.data.provider.mapper.db1",sqlSessionTemplateRef = "db1SqlSessionTemplate")
public class DataSource1Config {

    @Value("${mybatis.mapper-locations1}")
    private String mapper_locations="";

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.db1")

    public DataSource db1DataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory db1SqlSessionFactory(@Qualifier("db1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapper_locations));
        return bean.getObject();
    }

    @Bean
    public DataSourceTransactionManager db1TransactionManager(@Qualifier("db1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionTemplate db1SqlSessionTemplate(@Qualifier("db1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
