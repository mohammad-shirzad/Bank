package com.bank.dao.impl;

import com.bank.dao.bean.CustomerDao;
import com.bank.data.entity.ECustomer;
import com.bank.data.filter.EfCustomer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Repository(value = "CustomerDao")
public class CustomerDaoImpl extends BaseGenericDaoImpl<ECustomer> implements CustomerDao {
    @Override
    public List<ECustomer> find(Object filter) {
        EfCustomer efCustomer = (EfCustomer) filter;
        StoredProcedureQuery storedProcedureQuery = em.createNamedStoredProcedureQuery("findCustomers");
        storedProcedureQuery.setParameter("customerNo", efCustomer.getCustomerNo());
        storedProcedureQuery.setParameter("identityNo", efCustomer.getIdentityNo());
        storedProcedureQuery.setParameter("identityTypeValue", efCustomer.getIdentityType().getValue());
        storedProcedureQuery.setParameter("customerTypeValue", efCustomer.getCustomerType().getValue());

        return ((List<ECustomer>) storedProcedureQuery.getResultList());
    }

    @Override
    public ECustomer findCustomerByIdentityNo(String identityNo) {
        List<ECustomer> customers = ((List<ECustomer>) em.createNamedQuery("customer.findByIdentityNumber")
                .setParameter("identityNo", identityNo).getResultList());
        return customers.isEmpty() ? null : customers.get(0);


    }
}
