package ch.qompetence.logistica.api.mapper;

import ch.qompetence.logistica.api.dto.AssignmentDto;
import ch.qompetence.logistica.api.dto.TaskDto;
import ch.qompetence.logistica.domain.entity.AssignmentEntity;
import ch.qompetence.logistica.domain.entity.TaskEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AssignmentMapper {
    @Mapping(source = "task.id", target = "taskId")
    @Mapping(source = "personnel.id", target = "personnelId")
    @Mapping(source = "requirement.id", target = "requirementId")
    AssignmentDto toDto(AssignmentEntity entity);

    @Mapping(source = "taskId", target = "task.id")
    @Mapping(source = "personnelId", target = "personnel.id")
    @Mapping(source = "requirementId", target = "requirement.id")
    AssignmentEntity toEntity(AssignmentDto dto);

    void updateAssignmentFromDto(AssignmentDto dto, @MappingTarget AssignmentEntity entity);

}