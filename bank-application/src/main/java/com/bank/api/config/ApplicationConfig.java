package com.bank.api.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
public class ApplicationConfig {
    private static String CONFIG_NAME = "application.properties";
    public static Map<String, Object> CONFIG_MAP = new HashMap<>();

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName((String) CONFIG_MAP.get("db.driverClassName"));
        dataSource.setUrl((String) CONFIG_MAP.get("db.url"));
        dataSource.setUsername((String) CONFIG_MAP.get("db.username"));
        dataSource.setPassword((String) CONFIG_MAP.get("db.password"));
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
        hibernateProp.put("hibernate.dialect", CONFIG_MAP.get("hibernate.dialect"));
        hibernateProp.put("hibernate.show_sql", CONFIG_MAP.get("hibernate.show_sql"));
        hibernateProp.put("hibernate.current_session_context_class", "thread");
        hibernateProp.put("hibernate.format_sql", CONFIG_MAP.get("hibernate.format_sql"));
        return hibernateProp;
    }
}
