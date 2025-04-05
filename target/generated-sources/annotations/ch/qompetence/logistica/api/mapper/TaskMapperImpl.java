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
    date = "2025-04-05T18:58:24+0200",
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

        String id = null;
        String name = null;
        String location = null;
        String startDate = null;
        String endDate = null;
        boolean mealsProvided = false;
        boolean accommodationProvided = false;
        String mealsDetails = null;
        String accommodationDetails = null;
        List<TaskRequirementDto> requirements = null;

        id = entity.getId();
        name = entity.getName();
        location = entity.getLocation();
        startDate = entity.getStartDate();
        endDate = entity.getEndDate();
        mealsProvided = entity.isMealsProvided();
        accommodationProvided = entity.isAccommodationProvided();
        mealsDetails = entity.getMealsDetails();
        accommodationDetails = entity.getAccommodationDetails();
        requirements = taskRequirementEntityListToTaskRequirementDtoList( entity.getRequirements() );

        TaskDto taskDto = new TaskDto( id, name, location, startDate, endDate, mealsProvided, accommodationProvided, mealsDetails, accommodationDetails, requirements );

        return taskDto;
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
