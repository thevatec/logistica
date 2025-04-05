package ch.qompetence.logistica.service;

import ch.qompetence.logistica.api.dto.SkillDto;
import ch.qompetence.logistica.api.mapper.SkillMapper;
import ch.qompetence.logistica.domain.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;

    @Transactional(readOnly = true)
    public List<SkillDto> getAllSkills() {
        final var skills = skillRepository.findAll();
        return skills.stream()
                .map(skillMapper::toDto)
                .collect(Collectors.toList());
    }
}