package com.example.springboot.mapper;

import com.example.springboot.dto.VisitorDTO;
import com.example.springboot.entity.Resident;
import com.example.springboot.entity.Visitor;
import org.springframework.stereotype.Component;

@Component
public class VisitorMapper implements CrudMapper<VisitorDTO, Visitor, Resident> {
    @Override
    public VisitorDTO toDTO(Visitor entity) {
        VisitorDTO dto = new VisitorDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDocument(entity.getDocument());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setLastVisit(entity.getLastVisit());
        dto.setObservation(entity.getObservation());
        dto.setLastVisitedResidentId(entity.getLastVisitedResident().getId());

        return dto;
    }

    @Override
    public Visitor toEntity(VisitorDTO dto) {
        return null;
    }

    @Override
    public Visitor toEntity(VisitorDTO dto, Resident foreignEntity) {
        Visitor entity = new Visitor();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDocument(dto.getDocument());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setLastVisit(dto.getLastVisit());
        entity.setObservation(dto.getObservation());
        entity.setLastVisitedResident(foreignEntity);

        return entity;
    }
}
