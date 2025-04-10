package com.societyscore.authservice.Util.Enums.Converter;

import com.societyscore.authservice.Util.Enums.TypeEnum;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TypeEnumConverter implements AttributeConverter<TypeEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TypeEnum status) {
        return (status != null) ? status.getCode() : null;
    }

    @Override
    public TypeEnum convertToEntityAttribute(Integer dbData) {
        return (dbData != null) ? TypeEnum.fromCode(dbData) : null;
    }
}
