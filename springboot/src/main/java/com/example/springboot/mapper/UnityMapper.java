package com.example.springboot.mapper;

import com.example.springboot.dto.UnityDTO;
import com.example.springboot.entity.Operator;
import com.example.springboot.entity.Unity;
import org.springframework.stereotype.Component;

@Component
public class UnityMapper implements CrudMapper<UnityDTO, Unity, Operator> {
    @Override
    public UnityDTO toDTO(Unity entity) {
        UnityDTO dto = new UnityDTO();

        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setBlock(entity.getBlock());
        dto.setLot(entity.getLot());
        dto.setObservation(entity.getObservation());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setOperatorId(entity.getOperator().getId());

        return dto;
    }

    @Override
    public Unity toEntity(UnityDTO dto) {
        return null;
    }

    @Override
    public Unity toEntity(UnityDTO dto, Operator foreignEntity) {
        Unity entity = new Unity();

        entity.setId(dto.getId());
        entity.setDescription(dto.getDescription());
        entity.setBlock(dto.getBlock());
        entity.setLot(dto.getLot());
        entity.setObservation(dto.getObservation());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setOperator(foreignEntity);

        return entity;
    }
}
