package com.bank.domain.providerapi;

import com.bank.domain.data.entity.EContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDao extends JpaRepository<EContact, String>, ContactDaoCustom {
}
