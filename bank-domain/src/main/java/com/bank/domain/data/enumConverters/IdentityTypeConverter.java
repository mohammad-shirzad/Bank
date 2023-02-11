package com.bank.domain.data.enumConverters;

import com.bank.domain.data.enums.IdentityType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class IdentityTypeConverter implements AttributeConverter<IdentityType, Character> {
    @Override
    public Character convertToDatabaseColumn(IdentityType attribute) {
        if (attribute == null)
            return null;
        return attribute.getValue();
    }

    @Override
    public IdentityType convertToEntityAttribute(Character dbData) {
        if (dbData == null)
            return null;
        return Stream.of(IdentityType.values())
                .filter(c -> c.getValue().equals(dbData))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
