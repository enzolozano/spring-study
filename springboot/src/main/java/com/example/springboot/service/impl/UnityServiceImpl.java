package com.example.springboot.service.impl;

import com.example.springboot.dto.UnityDTO;
import com.example.springboot.entity.Operator;
import com.example.springboot.entity.Unity;
import com.example.springboot.exception.model.NotFoundException;
import com.example.springboot.mapper.UnityMapper;
import com.example.springboot.repository.UnityRepository;
import com.example.springboot.service.OperatorService;
import com.example.springboot.service.UnityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UnityServiceImpl implements UnityService {

    @Autowired
    private UnityRepository unityRepository;

    @Autowired
    private UnityMapper unityMapper;

    @Autowired
    private OperatorService operatorService;

    public List<UnityDTO> findAll() {
        List<Unity> entities = unityRepository.findAll();

        return entities.stream()
                .map(entity -> unityMapper.toDTO(entity))
                .collect(Collectors.toList());
    }

    public UnityDTO findById(long id) {
        Optional<Unity> entity = unityRepository.findById(id);

        if (entity.isEmpty()) {
            throw new NotFoundException(String.format("Unity with id %d not found", id));
        }

        return unityMapper.toDTO(entity.get());
    }

    public UnityDTO save(UnityDTO unityDTO) {
        Operator operator = operatorService.findEntityById(unityDTO.getOperatorId())
                .orElseThrow(() -> new NotFoundException("Operator not found"));

        Unity unity = unityMapper.toEntity(unityDTO, operator);

        return unityMapper.toDTO(unityRepository.save(unity));
    }

    public void deleteById(long id) {
        unityRepository.deleteById(id);
    }
}
