package com.example.demo.service.impl;

import com.example.demo.dto.SensorDto;
import com.example.demo.entity.Sensor;
import com.example.demo.repository.SensorRepository;
import com.example.demo.service.SensorService;
import com.example.demo.service.mapper.SensorMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SensorServiceImpl implements SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private SensorMapper sensorMapper;

    @Override
    public SensorDto save(SensorDto sensorDto) {
        Sensor sensor = sensorMapper.mapToEntity(sensorDto);
        sensor.setId(null);
        return sensorMapper.mapToDto(sensorRepository.save(sensor));
    }

    @Override
    public List<SensorDto> getAll() {
        return sensorRepository.findAll().stream().map(sensorMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<SensorDto> findByNameAndModelContainingIgnoreCase(String namePart, String modelPart) {
        return sensorRepository.findByNameAndModelContainingIgnoreCase(namePart, modelPart).stream().map(sensorMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<SensorDto> getByNameContaining(String query) {
        return sensorRepository.findByNameContaining(query).stream().map(sensorMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<SensorDto> getByModelContaining(String query) {
        return sensorRepository.findByModelContaining(query).stream().map(sensorMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void update(Long id, SensorDto sensorDto) {
        Optional<Sensor> sensorOptional = sensorRepository.findById(id);

        if (sensorOptional.isPresent()) {
            Sensor sensor = sensorMapper.mapToEntity(sensorDto);
            sensor.setId(id);
            sensorRepository.save(sensor);
        } else {
            throw new EntityNotFoundException(String.format("No such entity with id %s", id));
        }
    }

    @Override
    public void deleteById(Long id) {
        sensorRepository.deleteById(id);
    }
}
