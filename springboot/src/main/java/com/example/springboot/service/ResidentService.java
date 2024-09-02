package com.example.springboot.service;

import com.example.springboot.dto.ResidentDTO;
import com.example.springboot.entity.Resident;

import java.util.List;
import java.util.Optional;

public interface ResidentService {
    List<ResidentDTO> findAll();
    Optional<Resident> findEntityById(long id);
    ResidentDTO findById(long id);
    ResidentDTO save(ResidentDTO residentDTO);
    void deleteById(long id);
}
