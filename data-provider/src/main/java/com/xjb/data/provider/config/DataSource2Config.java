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
@MapperScan(basePackages = "com.xjb.data.provider.mapper.db2",sqlSessionTemplateRef = "db2SqlSessionTemplate")
public class DataSource2Config {
    @Value("${mybatis.mapper-locations2}")
    private String mapper_locations="";

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    @Primary
    public DataSource db2DataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public SqlSessionFactory db2SqlSessionFactory(@Qualifier("db2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapper_locations));
        return bean.getObject();
    }

    @Bean
    @Primary
    public DataSourceTransactionManager db2TransactionManager(@Qualifier("db2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    @Primary
    public SqlSessionTemplate db2SqlSessionTemplate(@Qualifier("db2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
