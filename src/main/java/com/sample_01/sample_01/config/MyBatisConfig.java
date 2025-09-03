package com.sample_01.sample_01.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
// 각 DB의 Mapper 패키지를 스캔하고, 사용할 SqlSessionFactory를 지정합니다.
@MapperScan(basePackages = "com.sample_01.sample_01.mapper.mariadb", sqlSessionFactoryRef = "mariadbSqlSessionFactory")
@EnableConfigurationProperties(MybatisProperties.class)
public class MyBatisConfig {

    private final MybatisProperties mybatisProperties;

    public MyBatisConfig(MybatisProperties mybatisProperties) {
        this.mybatisProperties = mybatisProperties;
    }


    // ===== MariaDB MyBatis 설정 =====

    @Bean(name = "mariadbSqlSessionFactory")
    public SqlSessionFactory mariadbSqlSessionFactory(DataSource dataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(applicationContext.getResources("classpath:mappers/mariadb/**/*.xml"));

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        if (this.mybatisProperties.getConfiguration() != null) {
            BeanUtils.copyProperties(this.mybatisProperties.getConfiguration(), configuration);
        }
        factoryBean.setConfiguration(configuration);

        return factoryBean.getObject();
    }

    @Bean(name = "mariadbSqlSessionTemplate")
    public SqlSessionTemplate mariadbSqlSessionTemplate(@Qualifier("mariadbSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "mariadbTransactionManager")
    public PlatformTransactionManager mariadbTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}