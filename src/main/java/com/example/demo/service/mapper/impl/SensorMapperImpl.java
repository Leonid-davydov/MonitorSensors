package com.example.demo.service.mapper.impl;

import com.example.demo.dto.RangeDto;
import com.example.demo.dto.SensorDto;
import com.example.demo.entity.Sensor;
import com.example.demo.entity.Type;
import com.example.demo.entity.Unit;
import com.example.demo.service.mapper.SensorMapper;
import org.springframework.stereotype.Component;

@Component
public class SensorMapperImpl implements SensorMapper {
    @Override
    public Sensor mapToEntity(SensorDto dto) {
        return Sensor.builder()
                .id(dto.getId())
                .name(dto.getName())
                .model(dto.getModel())
                .rangeFrom(dto.getRange().getFrom())
                .rangeTo(dto.getRange().getTo())
                .type(new Type(dto.getType()))
                .unit(new Unit(dto.getUnit()))
                .location(dto.getLocation())
                .description(dto.getDescription())
                .build();
    }

    @Override
    public SensorDto mapToDto(Sensor entity) {
        return SensorDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .model(entity.getModel())
                .range(new RangeDto(entity.getRangeFrom(), entity.getRangeTo()))
                .type(entity.getType().getName())
                .unit(entity.getUnit().getName())
                .location(entity.getLocation())
                .description(entity.getDescription())
                .build();
    }
}
