package com.example.demo.controller;

import com.example.demo.dto.SensorDto;
import com.example.demo.service.SensorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Sensor API")
@RestController
@RequestMapping("/api/v1/sensors")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @Operation(summary = "Create new sensor")
    @PreAuthorize("hasRole('Administrator')")
    @PostMapping
    public ResponseEntity<SensorDto> createSensor(@RequestBody @Valid SensorDto sensor) {
        SensorDto savedSensor = sensorService.save(sensor);
        return new ResponseEntity<>(savedSensor, HttpStatus.CREATED);
    }

    @Operation(summary = "Get list of sensors")
    @PreAuthorize("hasAnyRole('Administrator', 'Viewer')")
    @GetMapping
    public ResponseEntity<List<SensorDto>> getSensors(@RequestParam(required = false) String namePart, @RequestParam(required = false) String modelPart) {
        List<SensorDto> sensors;

        if (namePart == null && modelPart == null) {
            sensors = sensorService.getAll();
        } else {
            sensors = sensorService.findByNameAndModelContainingIgnoreCase(namePart == null ? "" : namePart, modelPart == null ? "" : modelPart);
        }

        return new ResponseEntity<>(sensors, HttpStatus.OK);
    }

    @Operation(summary = "Update existing sensor")
    @PreAuthorize("hasRole('Administrator')")
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSensor(@PathVariable Long id, @RequestBody @Valid SensorDto sensor) {
        sensorService.update(id, sensor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Delete sensor")
    @PreAuthorize("hasRole('Administrator')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSensorById(@PathVariable Long id) {
        sensorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
