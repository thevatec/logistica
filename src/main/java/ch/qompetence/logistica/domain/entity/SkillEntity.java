package ch.qompetence.logistica.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity(name = "skill")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class SkillEntity {
    @Id
    private String id;
    private String name;

}
