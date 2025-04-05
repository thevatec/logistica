package ch.qompetence.logistica.api.mapper;

import ch.qompetence.logistica.api.dto.PersonnelDto;
import ch.qompetence.logistica.api.dto.SkillDto;
import ch.qompetence.logistica.api.dto.VacationDayDto;
import ch.qompetence.logistica.domain.entity.PersonnelEntity;
import ch.qompetence.logistica.domain.entity.SkillEntity;
import ch.qompetence.logistica.domain.entity.VacationDayEntity;
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
public class PersonnelMapperImpl implements PersonnelMapper {

    @Autowired
    private SkillMapper skillMapper;
    @Autowired
    private VacationDayMapper vacationDayMapper;

    @Override
    public PersonnelDto toDto(PersonnelEntity entity) {
        if ( entity == null ) {
            return null;
        }

        String id = null;
        String name = null;
        String grade = null;
        boolean available = false;
        List<SkillDto> skills = null;
        List<VacationDayDto> vacationDays = null;

        id = entity.getId();
        name = entity.getName();
        grade = entity.getGrade();
        available = entity.isAvailable();
        skills = skillEntityListToSkillDtoList( entity.getSkills() );
        vacationDays = vacationDayEntityListToVacationDayDtoList( entity.getVacationDays() );

        PersonnelDto personnelDto = new PersonnelDto( id, name, grade, available, skills, vacationDays );

        return personnelDto;
    }

    @Override
    public PersonnelEntity toEntity(PersonnelDto dto) {
        if ( dto == null ) {
            return null;
        }

        PersonnelEntity.PersonnelEntityBuilder personnelEntity = PersonnelEntity.builder();

        personnelEntity.id( dto.id() );
        personnelEntity.name( dto.name() );
        personnelEntity.grade( dto.grade() );
        personnelEntity.available( dto.available() );
        personnelEntity.skills( skillDtoListToSkillEntityList( dto.skills() ) );
        personnelEntity.vacationDays( vacationDayDtoListToVacationDayEntityList( dto.vacationDays() ) );

        return personnelEntity.build();
    }

    protected List<SkillDto> skillEntityListToSkillDtoList(List<SkillEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SkillDto> list1 = new ArrayList<SkillDto>( list.size() );
        for ( SkillEntity skillEntity : list ) {
            list1.add( skillMapper.toDto( skillEntity ) );
        }

        return list1;
    }

    protected List<VacationDayDto> vacationDayEntityListToVacationDayDtoList(List<VacationDayEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<VacationDayDto> list1 = new ArrayList<VacationDayDto>( list.size() );
        for ( VacationDayEntity vacationDayEntity : list ) {
            list1.add( vacationDayMapper.toDto( vacationDayEntity ) );
        }

        return list1;
    }

    protected List<SkillEntity> skillDtoListToSkillEntityList(List<SkillDto> list) {
        if ( list == null ) {
            return null;
        }

        List<SkillEntity> list1 = new ArrayList<SkillEntity>( list.size() );
        for ( SkillDto skillDto : list ) {
            list1.add( skillMapper.toEntity( skillDto ) );
        }

        return list1;
    }

    protected List<VacationDayEntity> vacationDayDtoListToVacationDayEntityList(List<VacationDayDto> list) {
        if ( list == null ) {
            return null;
        }

        List<VacationDayEntity> list1 = new ArrayList<VacationDayEntity>( list.size() );
        for ( VacationDayDto vacationDayDto : list ) {
            list1.add( vacationDayMapper.toEntity( vacationDayDto ) );
        }

        return list1;
    }
}
