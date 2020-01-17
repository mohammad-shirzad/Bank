package com.bank.dao.impl;

import com.bank.dao.bean.CustomerDao;
import com.bank.data.entity.ECustomer;
import com.bank.data.filter.EfCustomer;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleType;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository(value = "CustomerDao")
public class CustomerDaoImpl extends BaseGenericDaoImpl<ECustomer> implements CustomerDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDaoImpl.class);

    @Override
    public List<ECustomer> find(Object filter) throws SQLException {
        EfCustomer efCustomer = (EfCustomer) filter;
        Query query = em.createNamedQuery("customer.findCustomer");
        query.setParameter("customerNo", efCustomer.getCustomerNo());
        query.setParameter("identityNo", efCustomer.getIdentityNo());

        return query.getResultList();
    }
}
