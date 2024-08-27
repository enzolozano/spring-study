package com.example.springboot.mapper;

import com.example.springboot.dto.VehicleDTO;
import com.example.springboot.entity.Resident;
import com.example.springboot.entity.Vehicle;

public class VehicleMapper {

    public static VehicleDTO toDTO(Vehicle vehicle) {
        VehicleDTO dto = new VehicleDTO();

        dto.setId(vehicle.getId());
        dto.setPlate(vehicle.getPlate());
        dto.setColor(vehicle.getColor());
        dto.setModel(vehicle.getModel());
        dto.setResidentOwnerId(vehicle.getResidentOwner().getId());

        return dto;
    }

    public static Vehicle toEntity(VehicleDTO vehicleDTO, Resident residentOwner) {
        Vehicle entity = new Vehicle();

        entity.setId(vehicleDTO.getId());
        entity.setPlate(vehicleDTO.getPlate());
        entity.setColor(vehicleDTO.getColor());
        entity.setModel(vehicleDTO.getModel());
        entity.setResidentOwner(residentOwner);

        return entity;
    }
}
