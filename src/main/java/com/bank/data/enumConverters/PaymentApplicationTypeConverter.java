package com.bank.data.enumConverters;

import com.bank.data.enums.PaymentApplicationType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class PaymentApplicationTypeConverter implements AttributeConverter<PaymentApplicationType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(PaymentApplicationType attribute) {
        if (attribute == null)
            return null;
        return attribute.getValue();
    }

    @Override
    public PaymentApplicationType convertToEntityAttribute(Integer dbData) {
        if (dbData == null)
            return null;
        return Stream.of(PaymentApplicationType.values())
                .filter(c -> c.getValue().equals(dbData))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
