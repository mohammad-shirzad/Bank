package com.bank.domain.providerapi;

import com.bank.domain.data.entity.EAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<EAddress, Long> {
}
