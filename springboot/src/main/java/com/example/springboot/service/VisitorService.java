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
    private VisitorMapper visitorMapper;

    @Autowired
    private ResidentService residentService;

    public List<VisitorDTO> findAll() {
        List<Visitor> entities = visitorRepository.findAll();

        return entities.stream()
                .map(entity -> visitorMapper.toDTO(entity))
                .collect(Collectors.toList());
    }

    public VisitorDTO findById(long id) {
        Optional<Visitor> entity = visitorRepository.findById(id);

        if (entity.isEmpty()) {
            throw new NotFoundException(String.format("Visitor with id %d not found", id));
        }

        return visitorMapper.toDTO(entity.get());
    }

    public VisitorDTO save(VisitorDTO visitorDTO) {
        Resident visitedResident = residentService.findEntityById(visitorDTO.getLastVisitedResidentId())
                .orElseThrow(() -> new NotFoundException("Resident not found"));

        Visitor visitor = visitorMapper.toEntity(visitorDTO, visitedResident);

        return visitorMapper.toDTO(visitorRepository.save(visitor));
    }

    public void deleteById(long id) {
        visitorRepository.deleteById(id);
    }
}
