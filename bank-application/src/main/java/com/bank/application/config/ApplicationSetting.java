package com.bank.application.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.bank.domain.providerapi", entityManagerFactoryRef = "emf")
@ComponentScan(basePackages = {"com.bank"})
@PropertySource("classpath:application.properties")
public class ApplicationSetting {

    @Autowired
    private ApplicationConfig appConfig;

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(appConfig.getDbDriverClassName());
        dataSource.setUrl(appConfig.getDbUrl());
        dataSource.setUsername(appConfig.getDbUsername());
        dataSource.setPassword(appConfig.getDbPassword());
        return dataSource;
    }

    @Bean(name = "emf")
    public LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(getDataSource());
        bean.setJpaVendorAdapter(getVendorAdaptor());
        bean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        bean.setJpaProperties(getHibernateProperties());
        bean.setPackagesToScan("com.bank.domain.data");
        bean.afterPropertiesSet();
        return bean;
    }

    private HibernateJpaVendorAdapter getVendorAdaptor() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager jpaTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(getLocalContainerEntityManagerFactoryBean().getObject());
        transactionManager.setJpaProperties(getHibernateProperties());
        return transactionManager;
    }

    private Properties getHibernateProperties() {
        Properties hibernateProp = new Properties();
        hibernateProp.put("hibernate.dialect", appConfig.getDbHibernateDialect());
        hibernateProp.put("hibernate.current_session_context_class", "thread");
        return hibernateProp;
    }
}
