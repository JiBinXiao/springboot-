package com.xjb.data.provider.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
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
//basePackages属性配置需要扫描的mybatis的mapper文件位置,sqlSessionFactory属性配置具体的 sqlSessionFactory.
@MapperScan(basePackages = "com.xjb.data.provider.mapper.db1",sqlSessionTemplateRef = "db1SqlSessionTemplate")
public class DataSource1Config {

    @Value("${mybatis.mapper-locations1}")
    private String mapper_locations="";

    @Bean
    //ConfigurationProperties读取并且设置我们在application.properties配置的内容.
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    //@Primary这个注解用来标识当存在多个相同的类型的bean时,优先选用哪个bean注入,
    // 需要注意的是,配置多数据源的时候,必须有一个且只能有一个@Primary注解
    @Primary
    public DataSource db1DataSource(){


        return new DruidDataSource();
    }

    @Bean
    @Primary
    public SqlSessionFactory db1SqlSessionFactory(@Qualifier("db1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapper_locations));
        return bean.getObject();
    }

    @Bean
    @Primary
    public DataSourceTransactionManager db1TransactionManager(@Qualifier("db1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    @Primary
    public SqlSessionTemplate db1SqlSessionTemplate(@Qualifier("db1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
