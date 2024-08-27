package com.example.springboot.mapper;

public interface CrudMapper<TDTO, TEnt, TFEnt extends Object> {
    TDTO toDTO(TEnt entity);
    TEnt toEntity(TDTO dto);
    TEnt toEntity(TDTO dto, TFEnt foreignEntity );
}
