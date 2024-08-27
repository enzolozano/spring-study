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
    private VehicleMapper vehicleMapper;

    @Autowired
    private ResidentService residentService;

    public List<VehicleDTO> findAll() {
        List<Vehicle> entities = vehicleRepository.findAll();

        return entities.stream()
                .map(entity -> vehicleMapper.toDTO(entity))
                .collect(Collectors.toList());
    }

    public VehicleDTO findById(long id) {
        Optional<Vehicle> entity = vehicleRepository.findById(id);

        if (entity.isEmpty()) {
            throw new NotFoundException(String.format("Vehicle with id %d not found", id));
        }

        return vehicleMapper.toDTO(entity.get());
    }

    public VehicleDTO save(VehicleDTO vehicleDTO) {
        Resident resident = residentService.findEntityById(vehicleDTO.getResidentOwnerId())
                .orElseThrow(() -> new NotFoundException("Resident not found"));

        Vehicle vehicle = vehicleMapper.toEntity(vehicleDTO, resident);

        return vehicleMapper.toDTO(vehicleRepository.save(vehicle));
    }

    public void deleteById(long id) {
        vehicleRepository.deleteById(id);
    }
}
