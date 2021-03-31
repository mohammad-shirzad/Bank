package com.bank.dao.impl;

import com.bank.dao.bean.AddressDao;
import com.bank.data.entity.EAddress;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "AddressDao")
public class AddressDaoImpl extends BaseGenericDaoImpl<EAddress, Long> implements AddressDao {
    @Override
    public List<EAddress> find(Object filter) {
        return null;
    }
}
