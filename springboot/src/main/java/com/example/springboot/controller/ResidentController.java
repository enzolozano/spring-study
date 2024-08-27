package com.example.springboot.controller;

import com.example.springboot.dto.ResidentDTO;
import com.example.springboot.service.ResidentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/residents")
@Tag(name = "Resident", description = "Operations related to residents")
public class ResidentController {

    @Autowired
    private ResidentService residentService;

    @Operation(description = "List all the residents")
    @ApiResponse(responseCode = "200", description = "Return all the residents")
    @GetMapping
    public List<ResidentDTO> getAllResidents() {
        return residentService.findAll();
    }

    @Operation(description = "Get the resident by his ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the resident"),
            @ApiResponse(responseCode = "404", description = "The resident could not be found")
    })
    @GetMapping("/{id}")
    public ResidentDTO getResidentById(@PathVariable Long id) {
        return residentService.findById(id);
    }

    @Operation(description = "Create a new resident")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Resident created successfully"),
            @ApiResponse(responseCode = "400", description = "Incorrect fields")
    })
    @PostMapping
    public ResidentDTO createResident(@Valid @RequestBody ResidentDTO residentDTO) {
        return residentService.save(residentDTO);
    }

    @Operation(description = "Delete a resident from database by his ID")
    @DeleteMapping("/{id}")
    public void deleteResident(@PathVariable Long id) {
        residentService.deleteById(id);
    }
}
