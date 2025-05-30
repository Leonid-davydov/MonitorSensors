package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sensor")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(nullable = false)
    private Integer rangeFrom;

    @Column(nullable = false)
    private Integer rangeTo;

    @ManyToOne
    @JoinColumn(name = "type_name",referencedColumnName = "name")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "unit_name", referencedColumnName = "name")
    private Unit unit;


    @Column(name = "location")
    private String location;

    private String description;
}
