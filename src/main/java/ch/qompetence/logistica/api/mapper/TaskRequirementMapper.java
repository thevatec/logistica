package ch.qompetence.logistica.api.mapper;

import ch.qompetence.logistica.api.dto.PersonnelDto;
import ch.qompetence.logistica.api.dto.TaskRequirementDto;
import ch.qompetence.logistica.domain.entity.PersonnelEntity;
import ch.qompetence.logistica.domain.entity.TaskRequirementEntity;
import org.mapstruct.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskRequirementMapper {
    TaskRequirementDto toDto(TaskRequirementEntity entity);

    @Mapping(target = "task", ignore = true)
    TaskRequirementEntity toEntity(TaskRequirementDto dto);
}