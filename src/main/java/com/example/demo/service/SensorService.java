package com.example.demo.service;

import com.example.demo.dto.SensorDto;
import com.example.demo.entity.Sensor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SensorService {

    SensorDto save(SensorDto sensorDto);

    List<SensorDto> getAll();

    List<SensorDto> findByNameAndModelContainingIgnoreCase(String namePart, String modelPart);

    List<SensorDto> getByNameContaining(String query);

    List<SensorDto> getByModelContaining(String query);

    void update(Long id, SensorDto sensorDto);

    void deleteById(Long id);

}
