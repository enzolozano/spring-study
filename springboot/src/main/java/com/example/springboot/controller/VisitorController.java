package com.example.springboot.controller;

import com.example.springboot.dto.VisitorDTO;
import com.example.springboot.exception.model.NotFoundException;
import com.example.springboot.service.VisitorService;
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
@RequestMapping("api/v1/visitors")
@Tag(name = "Visitor", description = "Operations related to visitors")
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @Operation(description = "List all the visitors")
    @ApiResponse(responseCode = "200", description = "Return all the visitors")
    @GetMapping
    public List<VisitorDTO> getAllVisitors() {
        return visitorService.findAll();
    }

    @Operation(description = "List the visitor by his ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the visitor"),
            @ApiResponse(responseCode = "404", description = "The visitor could not be found")
    })
    @GetMapping("/{id}")
    public VisitorDTO getVisitorById(@PathVariable Long id) {
        Optional<VisitorDTO> visitorDTO = visitorService.findById(id);

        if (visitorDTO.isEmpty()) {
            throw new NotFoundException(String.format("Visitor with id %d not found", id));
        }

        return visitorDTO.get();
    }

    @Operation(description = "Create a new visitor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Visitor created successfully"),
            @ApiResponse(responseCode = "400", description = "Incorrect fields")
    })
    @PostMapping
    public VisitorDTO createVisitor(@Valid @RequestBody VisitorDTO visitorDTO) {
        return visitorService.save(visitorDTO);
    }

    @Operation(description = "Delete a visitor from database")
    @DeleteMapping("/{id}")
    public void deleteVisitor(@PathVariable Long id) {
        visitorService.deleteById(id);
    }
}
