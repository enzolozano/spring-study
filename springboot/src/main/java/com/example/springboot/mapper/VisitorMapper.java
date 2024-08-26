package com.example.springboot.mapper;

import com.example.springboot.dto.VisitorDTO;
import com.example.springboot.entity.Resident;
import com.example.springboot.entity.Visitor;

public class VisitorMapper {

    public static VisitorDTO toDTO(Visitor visitor) {
        VisitorDTO dto = new VisitorDTO();

        dto.setId(visitor.getId());
        dto.setName(visitor.getName());
        dto.setDocument(visitor.getDocument());
        dto.setPhoneNumber(visitor.getPhoneNumber());
        dto.setCreatedAt(visitor.getCreatedAt());
        dto.setLastVisit(visitor.getLastVisit());
        dto.setObservation(visitor.getObservation());
        dto.setLastVisitedResidentId(visitor.getLastVisitedResident().getId());

        return dto;
    }

    public static Visitor toEntity(VisitorDTO visitorDTO, Resident visitedResident) {
        Visitor entity = new Visitor();

        entity.setId(visitorDTO.getId());
        entity.setName(visitorDTO.getName());
        entity.setDocument(visitorDTO.getDocument());
        entity.setPhoneNumber(visitorDTO.getPhoneNumber());
        entity.setCreatedAt(visitorDTO.getCreatedAt());
        entity.setLastVisit(visitorDTO.getLastVisit());
        entity.setObservation(visitorDTO.getObservation());
        entity.setLastVisitedResident(visitedResident);

        return entity;
    }
}
