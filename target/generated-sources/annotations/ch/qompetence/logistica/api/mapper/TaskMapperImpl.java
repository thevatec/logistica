package ch.qompetence.logistica.api.mapper;

import ch.qompetence.logistica.api.dto.CreateTaskRequest;
import ch.qompetence.logistica.api.dto.CreateTaskRequirementRequest;
import ch.qompetence.logistica.api.dto.TaskDto;
import ch.qompetence.logistica.api.dto.TaskRequirementDto;
import ch.qompetence.logistica.domain.entity.TaskEntity;
import ch.qompetence.logistica.domain.entity.TaskRequirementEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-06T22:32:37+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Eclipse Adoptium)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Autowired
    private TaskRequirementMapper taskRequirementMapper;

    @Override
    public TaskDto toDto(TaskEntity entity) {
        if ( entity == null ) {
            return null;
        }

        TaskDto.TaskDtoBuilder taskDto = TaskDto.builder();

        taskDto.id( entity.getId() );
        taskDto.name( entity.getName() );
        taskDto.location( entity.getLocation() );
        taskDto.startDate( entity.getStartDate() );
        taskDto.endDate( entity.getEndDate() );
        taskDto.mealsProvided( entity.isMealsProvided() );
        taskDto.accommodationProvided( entity.isAccommodationProvided() );
        taskDto.mealsDetails( entity.getMealsDetails() );
        taskDto.accommodationDetails( entity.getAccommodationDetails() );
        taskDto.requirements( taskRequirementEntityListToTaskRequirementDtoList( entity.getRequirements() ) );

        return taskDto.build();
    }

    @Override
    public TaskEntity toEntity(TaskDto dto) {
        if ( dto == null ) {
            return null;
        }

        TaskEntity.TaskEntityBuilder taskEntity = TaskEntity.builder();

        taskEntity.id( dto.id() );
        taskEntity.name( dto.name() );
        taskEntity.location( dto.location() );
        taskEntity.startDate( dto.startDate() );
        taskEntity.endDate( dto.endDate() );
        taskEntity.mealsProvided( dto.mealsProvided() );
        taskEntity.accommodationProvided( dto.accommodationProvided() );
        taskEntity.mealsDetails( dto.mealsDetails() );
        taskEntity.accommodationDetails( dto.accommodationDetails() );
        taskEntity.requirements( taskRequirementDtoListToTaskRequirementEntityList( dto.requirements() ) );

        return taskEntity.build();
    }

    @Override
    public TaskEntity toEntity(CreateTaskRequest request) {
        if ( request == null ) {
            return null;
        }

        TaskEntity.TaskEntityBuilder taskEntity = TaskEntity.builder();

        taskEntity.name( request.name() );
        taskEntity.location( request.location() );
        taskEntity.startDate( request.startDate() );
        taskEntity.endDate( request.endDate() );
        taskEntity.mealsProvided( request.mealsProvided() );
        taskEntity.accommodationProvided( request.accommodationProvided() );
        taskEntity.mealsDetails( request.mealsDetails() );
        taskEntity.accommodationDetails( request.accommodationDetails() );
        taskEntity.requirements( createTaskRequirementRequestListToTaskRequirementEntityList( request.requirements() ) );

        return taskEntity.build();
    }

    @Override
    public void updateTaskFromDto(TaskDto dto, TaskEntity entity) {
        if ( dto == null ) {
            return;
        }

        entity.setId( dto.id() );
        entity.setName( dto.name() );
        entity.setLocation( dto.location() );
        entity.setStartDate( dto.startDate() );
        entity.setEndDate( dto.endDate() );
        entity.setMealsProvided( dto.mealsProvided() );
        entity.setAccommodationProvided( dto.accommodationProvided() );
        entity.setMealsDetails( dto.mealsDetails() );
        entity.setAccommodationDetails( dto.accommodationDetails() );
        if ( entity.getRequirements() != null ) {
            List<TaskRequirementEntity> list = taskRequirementDtoListToTaskRequirementEntityList( dto.requirements() );
            if ( list != null ) {
                entity.getRequirements().clear();
                entity.getRequirements().addAll( list );
            }
            else {
                entity.setRequirements( null );
            }
        }
        else {
            List<TaskRequirementEntity> list = taskRequirementDtoListToTaskRequirementEntityList( dto.requirements() );
            if ( list != null ) {
                entity.setRequirements( list );
            }
        }

        setTaskInRequirements( entity );
    }

    protected List<TaskRequirementDto> taskRequirementEntityListToTaskRequirementDtoList(List<TaskRequirementEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<TaskRequirementDto> list1 = new ArrayList<TaskRequirementDto>( list.size() );
        for ( TaskRequirementEntity taskRequirementEntity : list ) {
            list1.add( taskRequirementMapper.toDto( taskRequirementEntity ) );
        }

        return list1;
    }

    protected List<TaskRequirementEntity> taskRequirementDtoListToTaskRequirementEntityList(List<TaskRequirementDto> list) {
        if ( list == null ) {
            return null;
        }

        List<TaskRequirementEntity> list1 = new ArrayList<TaskRequirementEntity>( list.size() );
        for ( TaskRequirementDto taskRequirementDto : list ) {
            list1.add( taskRequirementMapper.toEntity( taskRequirementDto ) );
        }

        return list1;
    }

    protected TaskRequirementEntity createTaskRequirementRequestToTaskRequirementEntity(CreateTaskRequirementRequest createTaskRequirementRequest) {
        if ( createTaskRequirementRequest == null ) {
            return null;
        }

        TaskRequirementEntity.TaskRequirementEntityBuilder taskRequirementEntity = TaskRequirementEntity.builder();

        taskRequirementEntity.skillId( createTaskRequirementRequest.skillId() );
        taskRequirementEntity.skillName( createTaskRequirementRequest.skillName() );
        taskRequirementEntity.count( createTaskRequirementRequest.count() );
        taskRequirementEntity.priority( createTaskRequirementRequest.priority() );

        return taskRequirementEntity.build();
    }

    protected List<TaskRequirementEntity> createTaskRequirementRequestListToTaskRequirementEntityList(List<CreateTaskRequirementRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<TaskRequirementEntity> list1 = new ArrayList<TaskRequirementEntity>( list.size() );
        for ( CreateTaskRequirementRequest createTaskRequirementRequest : list ) {
            list1.add( createTaskRequirementRequestToTaskRequirementEntity( createTaskRequirementRequest ) );
        }

        return list1;
    }
}
