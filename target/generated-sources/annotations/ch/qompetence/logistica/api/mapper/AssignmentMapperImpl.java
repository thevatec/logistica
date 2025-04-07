package ch.qompetence.logistica.api.mapper;

import ch.qompetence.logistica.api.dto.AssignmentDto;
import ch.qompetence.logistica.domain.entity.AssignmentEntity;
import ch.qompetence.logistica.domain.entity.PersonnelEntity;
import ch.qompetence.logistica.domain.entity.TaskEntity;
import ch.qompetence.logistica.domain.entity.TaskRequirementEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-07T13:49:02+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Eclipse Adoptium)"
)
@Component
public class AssignmentMapperImpl implements AssignmentMapper {

    @Override
    public AssignmentDto toDto(AssignmentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        String taskId = null;
        String personnelId = null;
        String requirementId = null;
        String id = null;
        String status = null;

        taskId = entityTaskId( entity );
        personnelId = entityPersonnelId( entity );
        requirementId = entityRequirementId( entity );
        id = entity.getId();
        status = entity.getStatus();

        AssignmentDto assignmentDto = new AssignmentDto( id, taskId, personnelId, status, requirementId );

        return assignmentDto;
    }

    @Override
    public AssignmentEntity toEntity(AssignmentDto dto) {
        if ( dto == null ) {
            return null;
        }

        AssignmentEntity.AssignmentEntityBuilder assignmentEntity = AssignmentEntity.builder();

        assignmentEntity.task( assignmentDtoToTaskEntity( dto ) );
        assignmentEntity.personnel( assignmentDtoToPersonnelEntity( dto ) );
        assignmentEntity.requirement( assignmentDtoToTaskRequirementEntity( dto ) );
        assignmentEntity.id( dto.id() );
        assignmentEntity.status( dto.status() );

        return assignmentEntity.build();
    }

    @Override
    public void updateAssignmentFromDto(AssignmentDto dto, AssignmentEntity entity) {
        if ( dto == null ) {
            return;
        }

        entity.setId( dto.id() );
        entity.setStatus( dto.status() );
    }

    private String entityTaskId(AssignmentEntity assignmentEntity) {
        if ( assignmentEntity == null ) {
            return null;
        }
        TaskEntity task = assignmentEntity.getTask();
        if ( task == null ) {
            return null;
        }
        String id = task.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String entityPersonnelId(AssignmentEntity assignmentEntity) {
        if ( assignmentEntity == null ) {
            return null;
        }
        PersonnelEntity personnel = assignmentEntity.getPersonnel();
        if ( personnel == null ) {
            return null;
        }
        String id = personnel.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String entityRequirementId(AssignmentEntity assignmentEntity) {
        if ( assignmentEntity == null ) {
            return null;
        }
        TaskRequirementEntity requirement = assignmentEntity.getRequirement();
        if ( requirement == null ) {
            return null;
        }
        String id = requirement.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected TaskEntity assignmentDtoToTaskEntity(AssignmentDto assignmentDto) {
        if ( assignmentDto == null ) {
            return null;
        }

        TaskEntity.TaskEntityBuilder taskEntity = TaskEntity.builder();

        taskEntity.id( assignmentDto.taskId() );

        return taskEntity.build();
    }

    protected PersonnelEntity assignmentDtoToPersonnelEntity(AssignmentDto assignmentDto) {
        if ( assignmentDto == null ) {
            return null;
        }

        PersonnelEntity.PersonnelEntityBuilder personnelEntity = PersonnelEntity.builder();

        personnelEntity.id( assignmentDto.personnelId() );

        return personnelEntity.build();
    }

    protected TaskRequirementEntity assignmentDtoToTaskRequirementEntity(AssignmentDto assignmentDto) {
        if ( assignmentDto == null ) {
            return null;
        }

        TaskRequirementEntity.TaskRequirementEntityBuilder taskRequirementEntity = TaskRequirementEntity.builder();

        taskRequirementEntity.id( assignmentDto.requirementId() );

        return taskRequirementEntity.build();
    }
}
