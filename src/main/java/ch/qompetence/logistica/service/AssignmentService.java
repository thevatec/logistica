package ch.qompetence.logistica.service;

import ch.qompetence.logistica.api.dto.AssignmentDto;
import ch.qompetence.logistica.api.mapper.AssignmentMapper;
import ch.qompetence.logistica.domain.entity.AssignmentEntity;
import ch.qompetence.logistica.domain.repository.AssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final AssignmentMapper assignmentMapper;

    @Transactional(readOnly = true)
    public List<AssignmentDto> getAllAssignments() {
        return assignmentRepository.findAll().stream()
                .map(assignmentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<AssignmentDto> updateAssignments(List<AssignmentDto> assignments) {
        assignmentRepository.deleteAll();
        List<AssignmentEntity> updatedEntities = new ArrayList<>();
        for (AssignmentDto dto : assignments) {
            // Lade das existierende Assignment aus der DB
            var optionalEntity = assignmentRepository.findById(dto.id());
            AssignmentEntity entity;
            if (optionalEntity.isPresent()) {
                entity = optionalEntity.get();
                // Aktualisiere das bestehende Entity – es ist bereits attached
                assignmentMapper.updateAssignmentFromDto(dto, entity);
            } else {
                // Neues Assignment, falls nicht vorhanden
                entity = assignmentMapper.toEntity(dto);
            }
            updatedEntities.add(entity);
        }
        // Speichere alle Entities; da sie im aktuellen Persistence Context sind,
        // sollte Hibernate ein direktes Update durchführen.
        assignmentRepository.saveAll(updatedEntities);
        return updatedEntities.stream()
                .map(assignmentMapper::toDto)
                .toList();
    }
}