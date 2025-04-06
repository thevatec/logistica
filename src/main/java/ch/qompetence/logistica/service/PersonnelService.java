package ch.qompetence.logistica.service;

import ch.qompetence.logistica.api.dto.PersonnelDto;
import ch.qompetence.logistica.domain.entity.PersonnelEntity;
import ch.qompetence.logistica.api.mapper.PersonnelMapper;
import ch.qompetence.logistica.domain.repository.PersonnelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonnelService {

    private final PersonnelRepository personnelRepository;
    private final PersonnelMapper personnelMapper;

    @Transactional(readOnly = true)
    public List<PersonnelDto> getAllPersonnel() {
        final var personnelEntities = personnelRepository.findAll();
        return personnelEntities.stream()
                .map(personnelMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteTask(String id) {
        if (!personnelRepository.existsById(id)) {
            throw new RuntimeException("Task with id " + id + " not found");
        }
        personnelRepository.deleteById(id);
    }


    @Transactional
    public void deleteAllTask() {
        personnelRepository.deleteAll();
    }
}