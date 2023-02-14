package com.bank.domain.business.utility;

import com.bank.domain.data.entity.ECard;
import com.bank.domain.data.view.EvCardIssueDetailData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ObjectMapper {
    ObjectMapper INSTANCE = Mappers.getMapper(ObjectMapper.class);

    EvCardIssueDetailData toEvCardIssueDetailData(ECard card);
}
