package com.example.springboot.mapper;

import com.example.springboot.dto.VehicleDTO;
import com.example.springboot.entity.Resident;
import com.example.springboot.entity.Vehicle;
import com.example.springboot.enumerator.VehicleType;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper implements CrudMapper<VehicleDTO, Vehicle, Resident>  {
    @Override
    public VehicleDTO toDTO(Vehicle entity) {
        VehicleDTO dto = new VehicleDTO();

        dto.setId(entity.getId());
        dto.setPlate(entity.getPlate());
        dto.setColor(entity.getColor());
        dto.setModel(entity.getModel());
        dto.setType(VehicleType.fromInt(entity.getType()));
        dto.setResidentOwnerId(entity.getResidentOwner().getId());

        return dto;
    }

    @Override
    public Vehicle toEntity(VehicleDTO dto) {
        return null;
    }

    @Override
    public Vehicle toEntity(VehicleDTO dto, Resident foreignEntity) {
        Vehicle entity = new Vehicle();

        entity.setId(dto.getId());
        entity.setPlate(dto.getPlate());
        entity.setColor(dto.getColor());
        entity.setModel(dto.getModel());
        entity.setType(dto.getType().getValue());
        entity.setResidentOwner(foreignEntity);

        return entity;
    }
}
