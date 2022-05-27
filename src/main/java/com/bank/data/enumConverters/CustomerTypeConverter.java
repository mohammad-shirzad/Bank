package com.bank.data.enumConverters;

import com.bank.data.enums.CustomerType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class CustomerTypeConverter implements AttributeConverter<CustomerType, Character> {

    @Override
    public Character convertToDatabaseColumn(CustomerType attribute) {
        if (attribute == null)
            return null;
        return attribute.getValue();
    }

    @Override
    public CustomerType convertToEntityAttribute(Character dbData) {
        if (dbData == null)
            return null;
        return Stream.of(CustomerType.values())
                .filter(c -> c.getValue() == dbData)
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
