package ch.qompetence.logistica.api.mapper;

import ch.qompetence.logistica.api.dto.SkillDto;
import ch.qompetence.logistica.api.dto.VacationDayDto;
import ch.qompetence.logistica.domain.entity.SkillEntity;
import ch.qompetence.logistica.domain.entity.VacationDayEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VacationDayMapper {
    @Mapping(source = "personnel.id", target = "personnelId")
    VacationDayDto toDto(VacationDayEntity entity);

    // Achtung: Bei der Umwandlung von DTO zu Entity muss das Personnel-Objekt separat befüllt werden.
    @Mapping(target = "personnel", ignore = true)
    VacationDayEntity toEntity(VacationDayDto dto);
}