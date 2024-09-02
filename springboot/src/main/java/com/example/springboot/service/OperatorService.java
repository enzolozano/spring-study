package com.example.springboot.service;

import com.example.springboot.dto.OperatorDTO;
import com.example.springboot.entity.Operator;

import java.util.List;
import java.util.Optional;

public interface OperatorService {
    boolean operatorExists(String email, String password);
    Optional<Operator> findEntityById(long id);
    List<OperatorDTO> findAll();
    OperatorDTO findById(long id);
    OperatorDTO save(OperatorDTO operatorDTO);
    void deleteById(long id);
}
