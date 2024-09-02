package com.example.springboot.service;

import com.example.springboot.dto.VehicleDTO;
import com.example.springboot.entity.Resident;
import com.example.springboot.entity.Vehicle;
import com.example.springboot.exception.model.NotFoundException;
import com.example.springboot.mapper.VehicleMapper;
import com.example.springboot.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface VehicleService {
    List<VehicleDTO> findAll();
    VehicleDTO findById(long id);
    VehicleDTO save(VehicleDTO vehicleDTO);
    void deleteById(long id);
}