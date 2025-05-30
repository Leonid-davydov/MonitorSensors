package com.example.demo.dto;

import com.example.demo.validation.annotation.ValidRange;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ValidRange
public class RangeDto {

    @NotNull(message = "From field is required")
    private Integer from;

    @NotNull(message = "To field is required")
    private Integer to;
}
