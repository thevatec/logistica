package ch.qompetence.logistica.api.mapper;

import ch.qompetence.logistica.api.dto.SkillDto;
import ch.qompetence.logistica.domain.entity.SkillEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-06T22:15:22+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Eclipse Adoptium)"
)
@Component
public class SkillMapperImpl implements SkillMapper {

    @Override
    public SkillDto toDto(SkillEntity entity) {
        if ( entity == null ) {
            return null;
        }

        String id = null;
        String name = null;

        id = entity.getId();
        name = entity.getName();

        SkillDto skillDto = new SkillDto( id, name );

        return skillDto;
    }

    @Override
    public SkillEntity toEntity(SkillDto dto) {
        if ( dto == null ) {
            return null;
        }

        SkillEntity.SkillEntityBuilder skillEntity = SkillEntity.builder();

        skillEntity.id( dto.id() );
        skillEntity.name( dto.name() );

        return skillEntity.build();
    }
}
