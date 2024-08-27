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

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ResidentService residentService;

    public List<VehicleDTO> findAll() {
        return vehicleRepository.findAll()
                .stream()
                .map(VehicleMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<VehicleDTO> findById(long id) {
        return vehicleRepository.findById(id)
                .map(VehicleMapper::toDTO);
    }

    public VehicleDTO save(VehicleDTO vehicleDTO) {
        Resident resident = residentService.findEntityById(vehicleDTO.getResidentOwnerId())
                .orElseThrow(() -> new NotFoundException("Resident not found"));

        Vehicle vehicle = VehicleMapper.toEntity(vehicleDTO, resident);

        return VehicleMapper.toDTO(vehicleRepository.save(vehicle));
    }

    public void deleteById(long id) {
        vehicleRepository.deleteById(id);
    }
}
