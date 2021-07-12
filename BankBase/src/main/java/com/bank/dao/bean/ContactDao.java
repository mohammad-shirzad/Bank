package com.bank.dao.bean;

import com.bank.data.entity.EContact;

public interface ContactDao extends ExtendedRepository<EContact, String>, ContactDaoCustom {
}
