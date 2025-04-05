package ch.qompetence.logistica.api.mapper;

import ch.qompetence.logistica.api.dto.CreateTaskRequest;
import ch.qompetence.logistica.api.dto.TaskDto;
import ch.qompetence.logistica.api.dto.TaskRequirementDto;
import ch.qompetence.logistica.domain.entity.TaskEntity;
import ch.qompetence.logistica.domain.entity.TaskRequirementEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {TaskRequirementMapper.class})
public interface TaskMapper {
    TaskDto toDto(TaskEntity entity);
    TaskEntity toEntity(TaskDto dto);

    TaskEntity toEntity(CreateTaskRequest request);

    @AfterMapping
    default void setTaskInRequirements(@MappingTarget TaskEntity task) {
        if (task.getRequirements() != null) {
            task.setRequirements(task.getRequirements().stream()
                    .peek(req -> req.setTask(task))
                    .collect(Collectors.toList()));
        }
    }
}