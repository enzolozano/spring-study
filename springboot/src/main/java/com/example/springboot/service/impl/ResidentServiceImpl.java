package com.example.springboot.service.impl;

import com.example.springboot.dto.ResidentDTO;
import com.example.springboot.entity.Resident;
import com.example.springboot.exception.model.NotFoundException;
import com.example.springboot.mapper.ResidentMapper;
import com.example.springboot.repository.ResidentRepository;
import com.example.springboot.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResidentServiceImpl implements ResidentService {

    @Autowired
    private ResidentRepository residentRepository;

    @Autowired
    private ResidentMapper residentMapper;

    public List<ResidentDTO> findAll() {
        List<Resident> entities = residentRepository.findAll();

        return entities.stream()
                .map(entity -> residentMapper.toDTO(entity))
                .collect(Collectors.toList());
    }

    public Optional<Resident> findEntityById(long id) {
        return residentRepository.findById(id);
    }

    public ResidentDTO findById(long id) {
        Optional<Resident> entity = residentRepository.findById(id);

        if (entity.isEmpty()) {
            throw new NotFoundException(String.format("Resident with id %d not found", id));
        }

        return residentMapper.toDTO(entity.get());
    }

    public ResidentDTO save(ResidentDTO residentDTO) {
        Resident resident = residentMapper.toEntity(residentDTO);

        return residentMapper.toDTO(residentRepository.save(resident));
    }

    public void deleteById(long id) {
        residentRepository.deleteById(id);
    }
}
