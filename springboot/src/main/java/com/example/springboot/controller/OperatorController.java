package com.example.springboot.controller;

import com.example.springboot.dto.OperatorDTO;
import com.example.springboot.service.OperatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/operators")
@Tag(name = "Operator", description = "Operations related to operators")
public class OperatorController {

    @Autowired
    private OperatorService operatorService;

    @Operation(description = "List all the operators")
    @ApiResponse(responseCode = "200", description = "Return all the operators")
    @GetMapping
    public List<OperatorDTO> getAllOperators() {
        return operatorService.findAll();
    }

    @Operation(description = "Get the operator by his ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the operator"),
            @ApiResponse(responseCode = "404", description = "The operator could not be found")
    })
    @GetMapping("/{id}")
    public OperatorDTO getOperatorById(@PathVariable Long id) {
        return operatorService.findById(id);
    }

    @Operation(description = "Create a new operator")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Operator created successfully"),
            @ApiResponse(responseCode = "400", description = "Incorrect fields")
    })
    @PostMapping
    public OperatorDTO createOperator(@Valid @RequestBody OperatorDTO operatorDTO) {
        return operatorService.save(operatorDTO);
    }

    @Operation(description = "Delete a operator from database by his ID")
    @DeleteMapping("/{id}")
    public void deleteOperator(@PathVariable Long id) {
        operatorService.deleteById(id);
    }
}
