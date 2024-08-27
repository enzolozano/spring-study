package com.example.springboot.controller;

import com.example.springboot.dto.VehicleDTO;
import com.example.springboot.exception.model.NotFoundException;
import com.example.springboot.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/vehicles")
@Tag(name = "Vehicle", description = "Operations related to vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Operation(description = "List all the vehicles")
    @ApiResponse(responseCode = "200", description = "Return all the vehicles")
    @GetMapping
    public List<VehicleDTO> getAllVehicles() {
        return vehicleService.findAll();
    }

    @Operation(description = "Get the vehicle by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return the vehicle"),
            @ApiResponse(responseCode = "404", description = "The vehicle could not be found")
    })
    @GetMapping("/{id}")
    public VehicleDTO getVehicleById(@PathVariable Long id) {
        Optional<VehicleDTO> vehicleDTO = vehicleService.findById(id);

        if (vehicleDTO.isEmpty()) {
            throw new NotFoundException(String.format("Vehicle with id %d not found", id));
        }

        return vehicleDTO.get();
    }

    @Operation(description = "Create a new vehicle")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Vehicle created successfully"),
            @ApiResponse(responseCode = "400", description = "Incorrect fields")
    })
    @PostMapping
    public VehicleDTO save(@Valid @RequestBody VehicleDTO vehicleDTO) {
        return vehicleService.save(vehicleDTO);
    }

    @Operation(description = "Delete a vehicle from database by its ID")
    @DeleteMapping("/{id}")
    public void deleteVehicleById(@PathVariable Long id) {
        vehicleService.deleteById(id);
    }
}
