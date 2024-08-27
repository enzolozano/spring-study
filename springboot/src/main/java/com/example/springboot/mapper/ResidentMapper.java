package com.example.springboot.mapper;

import com.example.springboot.dto.ResidentDTO;
import com.example.springboot.entity.Resident;
import com.example.springboot.enumerator.Gender;
import org.springframework.stereotype.Component;

@Component
public class ResidentMapper implements CrudMapper<ResidentDTO, Resident, Void> {
    @Override
    public ResidentDTO toDTO(Resident entity) {
        ResidentDTO dto = new ResidentDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDocument(entity.getDocument());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setBirthDate(entity.getBirthDate());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setObservation(entity.getObservation());
        dto.setAddress(entity.getAddress());
        dto.setGender(Gender.fromInt(entity.getGender()));
        dto.setPhoto(entity.getPhoto());

        return dto;
    }

    @Override
    public Resident toEntity(ResidentDTO dto) {
        Resident entity = new Resident();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDocument(dto.getDocument());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setBirthDate(dto.getBirthDate());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setObservation(dto.getObservation());
        entity.setAddress(dto.getAddress());
        entity.setGender(dto.getGender().getValue());
        entity.setPhoto(dto.getPhoto());

        return entity;
    }

    @Override
    public Resident toEntity(ResidentDTO dto, Void foreignEntity) {
        return null;
    }
}
