package com.example.springboot.controller;

import com.example.springboot.dto.UnityDTO;
import com.example.springboot.service.UnityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/unities")
@Tag(name = "Unity", description = "Operations related to unities")
public class UnityController {

    @Autowired
    private UnityService unityService;

    @Operation(description = "List all the unities")
    @ApiResponse(responseCode = "200", description = "Return all the unities")
    @GetMapping
    public List<UnityDTO> getAllUnities() {
        return unityService.findAll();
    }

    @Operation(description = "Get the unity by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return the unity"),
            @ApiResponse(responseCode = "404", description = "The unity could not be found")
    })
    @GetMapping("/{id}")
    public UnityDTO getUnityById(@PathVariable Long id) {
        return unityService.findById(id);
    }

    @Operation(description = "Create a new unity")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Unity created successfully"),
            @ApiResponse(responseCode = "400", description = "Incorrect fields")
    })
    @PostMapping
    public UnityDTO save(@Valid @RequestBody UnityDTO unityDTO) {
        return unityService.save(unityDTO);
    }

    @Operation(description = "Delete a unity from database by its ID")
    @DeleteMapping("/{id}")
    public void deleteUnityById(@PathVariable Long id) {
        unityService.deleteById(id);
    }
}
