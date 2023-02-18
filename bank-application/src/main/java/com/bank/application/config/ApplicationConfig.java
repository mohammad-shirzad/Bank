package com.bank.application.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
    @Value("${db.username}")
    private String dbUsername;
    @Value("${db.password}")
    private String dbPassword;
    @Value("${db.driverClassName}")
    private String dbDriverClassName;
    @Value("${db.url}")
    private String dbUrl;
    @Value("${db.hibernate.dialect}")
    private String dbHibernateDialect;
    @Value("${customer.bank.name}")
    private String customerBankName;

    public String getDbUsername() {
        return dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getDbDriverClassName() {
        return dbDriverClassName;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbHibernateDialect() {
        return dbHibernateDialect;
    }

    public String getCustomerBankName() {
        return customerBankName;
    }
}
