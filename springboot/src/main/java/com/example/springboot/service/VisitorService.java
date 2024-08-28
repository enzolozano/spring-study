package com.example.springboot.service;

import com.example.springboot.dto.VisitorDTO;

import java.util.List;

public interface VisitorService {
    List<VisitorDTO> findAll();
    VisitorDTO findById(long id);
    VisitorDTO save(VisitorDTO visitorDTO);
    void deleteById(long id);
}
