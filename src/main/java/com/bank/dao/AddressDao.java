package com.bank.dao;

import com.bank.data.entity.EAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<EAddress, Long> {
}
