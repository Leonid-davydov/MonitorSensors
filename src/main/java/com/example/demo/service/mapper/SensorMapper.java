package com.example.demo.service.mapper;

import com.example.demo.dto.SensorDto;
import com.example.demo.entity.Sensor;

public interface SensorMapper {

    Sensor mapToEntity(SensorDto dto);

    SensorDto mapToDto(Sensor entity);
}
