package com.example.springboot.mapper;

import com.example.springboot.dto.ResidentDTO;
import com.example.springboot.entity.Resident;
import com.example.springboot.enumerator.Gender;

public class ResidentMapper {

    public static ResidentDTO toDTO(Resident resident) {
        ResidentDTO dto = new ResidentDTO();

        dto.setId(resident.getId());
        dto.setName(resident.getName());
        dto.setDocument(resident.getDocument());
        dto.setPhoneNumber(resident.getPhoneNumber());
        dto.setBirthDate(resident.getBirthDate());
        dto.setCreatedAt(resident.getCreatedAt());
        dto.setUpdatedAt(resident.getUpdatedAt());
        dto.setObservation(resident.getObservation());
        dto.setAddress(resident.getAddress());
        dto.setGender(Gender.fromInt(resident.getGender()));
        dto.setPhoto(resident.getPhoto());

        return dto;
    }

    public static Resident toEntity(ResidentDTO residentDTO) {
        Resident entity = new Resident();

        entity.setId(residentDTO.getId());
        entity.setName(residentDTO.getName());
        entity.setDocument(residentDTO.getDocument());
        entity.setPhoneNumber(residentDTO.getPhoneNumber());
        entity.setBirthDate(residentDTO.getBirthDate());
        entity.setCreatedAt(residentDTO.getCreatedAt());
        entity.setUpdatedAt(residentDTO.getUpdatedAt());
        entity.setObservation(residentDTO.getObservation());
        entity.setAddress(residentDTO.getAddress());
        entity.setGender(residentDTO.getGender().getValue());
        entity.setPhoto(residentDTO.getPhoto());

        return entity;
    }
}
