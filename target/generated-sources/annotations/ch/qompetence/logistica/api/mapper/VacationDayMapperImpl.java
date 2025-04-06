package ch.qompetence.logistica.api.mapper;

import ch.qompetence.logistica.api.dto.VacationDayDto;
import ch.qompetence.logistica.domain.entity.PersonnelEntity;
import ch.qompetence.logistica.domain.entity.VacationDayEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-06T22:15:22+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Eclipse Adoptium)"
)
@Component
public class VacationDayMapperImpl implements VacationDayMapper {

    @Override
    public VacationDayDto toDto(VacationDayEntity entity) {
        if ( entity == null ) {
            return null;
        }

        String personnelId = null;
        String id = null;
        String date = null;

        personnelId = entityPersonnelId( entity );
        id = entity.getId();
        date = entity.getDate();

        VacationDayDto vacationDayDto = new VacationDayDto( id, date, personnelId );

        return vacationDayDto;
    }

    @Override
    public VacationDayEntity toEntity(VacationDayDto dto) {
        if ( dto == null ) {
            return null;
        }

        VacationDayEntity.VacationDayEntityBuilder vacationDayEntity = VacationDayEntity.builder();

        vacationDayEntity.id( dto.id() );
        vacationDayEntity.date( dto.date() );

        return vacationDayEntity.build();
    }

    private String entityPersonnelId(VacationDayEntity vacationDayEntity) {
        if ( vacationDayEntity == null ) {
            return null;
        }
        PersonnelEntity personnel = vacationDayEntity.getPersonnel();
        if ( personnel == null ) {
            return null;
        }
        String id = personnel.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
