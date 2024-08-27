package com.example.springboot.service;

import com.example.springboot.dto.OperatorDTO;
import com.example.springboot.entity.Operator;
import com.example.springboot.exception.model.NotFoundException;
import com.example.springboot.mapper.OperatorMapper;
import com.example.springboot.repository.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OperatorService {

    @Autowired
    private OperatorRepository operatorRepository;

    @Autowired
    private OperatorMapper operatorMapper;

    public boolean operatorExists(String email, String password) {
        Optional<Operator> operator = operatorRepository.findTopByEmailAndPassword(email, password);

        return operator.isPresent();
    }

    public Optional<Operator> findEntityById(long id) {
        return operatorRepository.findById(id);
    }

    public List<OperatorDTO> findAll() {
        List<Operator> entities = operatorRepository.findAll();

        return entities.stream()
                .map(entity -> operatorMapper.toDTO(entity))
                .collect(Collectors.toList());
    }

    public OperatorDTO findById(long id) {
        Optional<Operator> entity = operatorRepository.findById(id);

        if (entity.isEmpty()) {
            throw new NotFoundException(String.format("Operator with id %d not found", id));
        }

        return operatorMapper.toDTO(entity.get());
    }

    public OperatorDTO save(OperatorDTO operatorDTO) {
        Operator entity = operatorMapper.toEntity(operatorDTO);

        return operatorMapper.toDTO(operatorRepository.save(entity));
    }

    public void deleteById(long id) {
        operatorRepository.deleteById(id);
    }
}
