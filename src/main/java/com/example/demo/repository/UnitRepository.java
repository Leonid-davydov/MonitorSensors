package com.example.demo.repository;

import com.example.demo.entity.Sensor;
import com.example.demo.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, Long> {
}
