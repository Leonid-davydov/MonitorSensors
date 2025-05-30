package com.example.demo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SensorDto {

    private long id;

    @NotBlank(message = "Name field is required")
    @Size(min = 3, max = 30, message = "The name must be between 3 and 30 characters long")
    private String name;

    @NotBlank(message = "Model field is required")
    @Size(max = 15, message = "The model field must not exceed 15 characters")
    private String model;

    @NotNull(message = "Range field is required")
    @Valid
    private RangeDto range;

    @NotBlank(message = "Type field is required")
    private String type;

    private String unit;

    @Size(max = 40, message = "The location field must not exceed 40 characters")
    private String location;

    @Size(max = 40, message = "The description field must not exceed 200 characters")
    private String description;
}
