package com.example.springboot.mapper;

import com.example.springboot.dto.OperatorDTO;
import com.example.springboot.entity.Operator;
import org.springframework.stereotype.Component;

@Component
public class OperatorMapper implements CrudMapper<OperatorDTO, Operator, Void> {

    @Override
    public OperatorDTO toDTO(Operator entity) {
        OperatorDTO dto = new OperatorDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPassword(entity.getPassword());
        dto.setEmail(entity.getEmail());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    @Override
    public Operator toEntity(OperatorDTO dto) {
        Operator entity = new Operator();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPassword(dto.getPassword());
        entity.setEmail(dto.getEmail());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());

        return entity;
    }

    @Override
    public Operator toEntity(OperatorDTO dto, Void foreignEntity) {
        return null;
    }
}
