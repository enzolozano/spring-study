package com.example.springboot.service;

import com.example.springboot.dto.UnityDTO;

import java.util.List;

public interface UnityService {
    List<UnityDTO> findAll();
    UnityDTO findById(long id);
    UnityDTO save(UnityDTO unityDTO);
    void deleteById(long id);
}
