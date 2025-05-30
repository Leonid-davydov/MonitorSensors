package com.example.demo.repository;

import com.example.demo.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
    List<Sensor> findByNameContaining(String query);

    List<Sensor> findByModelContaining(String query);

    @Query(value = "SELECT * FROM sensor " +
            "WHERE name ILIKE '%' || :namePart || '%' " +
            "AND model ILIKE '%' || :modelPart || '%'",
            nativeQuery = true)
    List<Sensor> findByNameAndModelContainingIgnoreCase(
            @Param("namePart") String namePart,
            @Param("modelPart") String modelPart
    );
}
