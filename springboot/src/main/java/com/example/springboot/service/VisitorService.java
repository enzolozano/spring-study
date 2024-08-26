package com.example.springboot.service;

import com.example.springboot.dto.VisitorDTO;
import com.example.springboot.entity.Resident;
import com.example.springboot.entity.Visitor;
import com.example.springboot.exception.model.NotFoundException;
import com.example.springboot.mapper.VisitorMapper;
import com.example.springboot.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VisitorService {

    @Autowired
    private VisitorRepository visitorRepository;

    @Autowired
    private ResidentService residentService;

    public List<VisitorDTO> findAll() {
        return visitorRepository.findAll()
                .stream()
                .map(VisitorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<VisitorDTO> findById(long id) {
        return visitorRepository.findById(id)
                .map(VisitorMapper::toDTO);
    }

    public VisitorDTO save(VisitorDTO visitorDTO) {
        Resident visitedResident = residentService.findEntityById(visitorDTO.getLastVisitedResidentId())
                .orElseThrow(() -> new NotFoundException("Resident not found"));

        Visitor visitor = VisitorMapper.toEntity(visitorDTO, visitedResident);

        return VisitorMapper.toDTO(visitorRepository.save(visitor));
    }

    public void deleteById(long id) {
        visitorRepository.deleteById(id);
    }
}
