package ch.qompetence.logistica.api.mapper;

import ch.qompetence.logistica.api.dto.PersonnelDto;
import ch.qompetence.logistica.api.dto.VacationDayDto;
import ch.qompetence.logistica.domain.entity.PersonnelEntity;
import ch.qompetence.logistica.domain.entity.VacationDayEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SkillMapper.class, VacationDayMapper.class})
public interface PersonnelMapper {
    PersonnelDto toDto(PersonnelEntity entity);
    PersonnelEntity toEntity(PersonnelDto dto);
}