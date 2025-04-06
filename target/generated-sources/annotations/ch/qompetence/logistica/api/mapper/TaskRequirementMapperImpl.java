package ch.qompetence.logistica.api.mapper;

import ch.qompetence.logistica.api.dto.TaskRequirementDto;
import ch.qompetence.logistica.domain.entity.TaskRequirementEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-06T21:39:07+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Eclipse Adoptium)"
)
@Component
public class TaskRequirementMapperImpl implements TaskRequirementMapper {

    @Override
    public TaskRequirementDto toDto(TaskRequirementEntity entity) {
        if ( entity == null ) {
            return null;
        }

        String id = null;
        String skillId = null;
        String skillName = null;
        int count = 0;
        String priority = null;

        id = entity.getId();
        skillId = entity.getSkillId();
        skillName = entity.getSkillName();
        count = entity.getCount();
        priority = entity.getPriority();

        TaskRequirementDto taskRequirementDto = new TaskRequirementDto( id, skillId, skillName, count, priority );

        return taskRequirementDto;
    }

    @Override
    public TaskRequirementEntity toEntity(TaskRequirementDto dto) {
        if ( dto == null ) {
            return null;
        }

        TaskRequirementEntity.TaskRequirementEntityBuilder taskRequirementEntity = TaskRequirementEntity.builder();

        taskRequirementEntity.id( dto.id() );
        taskRequirementEntity.skillId( dto.skillId() );
        taskRequirementEntity.skillName( dto.skillName() );
        taskRequirementEntity.count( dto.count() );
        taskRequirementEntity.priority( dto.priority() );

        return taskRequirementEntity.build();
    }
}
