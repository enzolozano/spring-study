package com.example.springboot.service;

import com.example.springboot.dto.ResidentDTO;
import com.example.springboot.entity.Resident;
import com.example.springboot.mapper.ResidentMapper;
import com.example.springboot.repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResidentService {

    @Autowired
    private ResidentRepository residentRepository;

    public List<ResidentDTO> findAll() {
        return residentRepository.findAll()
                .stream()
                .map(ResidentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<Resident> findEntityById(long id) {
        return residentRepository.findById(id);
    }

    public Optional<ResidentDTO> findById(long id) {
        return residentRepository.findById(id)
                .map(ResidentMapper::toDTO);
    }

    public Optional<ResidentDTO> findByDocument(String document) {
        return residentRepository.findByDocument(document)
                .map(ResidentMapper::toDTO);
    }

    public ResidentDTO save(ResidentDTO residentDTO) {
        Resident resident = ResidentMapper.toEntity(residentDTO);

        return ResidentMapper.toDTO(residentRepository.save(resident));
    }

    public void deleteById(long id) {
        residentRepository.deleteById(id);
    }
}
