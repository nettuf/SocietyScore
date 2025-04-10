package com.societyscore.authservice.Util.Enums.Converter;

import com.societyscore.authservice.Util.Enums.StatusEnum;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusEnumConverter implements AttributeConverter<StatusEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(StatusEnum status) {
        return (status != null) ? status.getCode() : null;
    }

    @Override
    public StatusEnum convertToEntityAttribute(Integer dbData) {
        return (dbData != null) ? StatusEnum.fromCode(dbData) : null;
    }
}
