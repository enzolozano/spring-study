package com.example.springboot.dto;

import com.example.springboot.enumerator.VehicleType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class VehicleDTO implements Serializable {

    private long id;

    @NotEmpty(message = "Plate is required")
    private String plate;

    @NotEmpty(message = "Model is required")
    private String model;

    private String color;

    @NotNull(message = "Vehicle type is required")
    private VehicleType type;

    @NotNull(message = "Resident owner ID is required")
    private long residentOwnerId;
}
