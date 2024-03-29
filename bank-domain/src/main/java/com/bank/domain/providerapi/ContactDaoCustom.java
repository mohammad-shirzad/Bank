package com.bank.domain.providerapi;

import com.bank.domain.data.entity.EContact;
import com.bank.domain.data.filter.EfContact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactDaoCustom {
    @Query(value = "select c from EContact c where " +
            "(:#{#filter.customerNo} is null or c.customerNo = :#{#filter.customerNo}) and " +
            "(:#{#filter.holderId} is null or c.id = :#{#filter.holderId})")
    List<EContact> findByFilter(@Param("filter") EfContact filter);
}
