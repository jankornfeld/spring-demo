package com.example.demo.persistence.converters;

import com.example.demo.persistence.entities.Orientation;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

@Converter(autoApply = true)
public class OrientationConverter implements AttributeConverter<Orientation, String> {
    @Override
    public String convertToDatabaseColumn(Orientation orientation) {
        return Optional.ofNullable(orientation).map(orientation1 -> orientation.name().substring(0,1)).orElse(null);
    }

    @Override
    public Orientation convertToEntityAttribute(String dbValue) {
        return Optional.ofNullable(dbValue).map(this::toOrientation).orElse(null);
    }

    private Orientation toOrientation(String dbValue) {
        return switch (dbValue) {
            case "P" -> Orientation.PORTRAIT;
            case "L" -> Orientation.LANDSCAPE;
            case "S" -> Orientation.SQUARE;
            default -> Orientation.PORTRAIT;
        };
    }
}
