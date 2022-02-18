package com.bank.dao.repository;

import com.bank.data.entity.EContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDao extends JpaRepository<EContact, String>, ContactDaoCustom {
}
