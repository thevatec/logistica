package ch.qompetence.logistica.api.mapper;

import ch.qompetence.logistica.api.dto.SkillDto;
import ch.qompetence.logistica.domain.entity.SkillEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    SkillDto toDto(SkillEntity entity);
    SkillEntity toEntity(SkillDto dto);
}
