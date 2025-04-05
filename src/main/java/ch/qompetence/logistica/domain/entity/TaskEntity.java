package ch.qompetence.logistica.domain.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity(name = "task")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TaskEntity {

    @Id @UuidGenerator
    private String id;

    private String name;
    private String location;
    private String startDate;
    private String endDate;
    private boolean mealsProvided;
    private boolean accommodationProvided;
    private String mealsDetails;
    private String accommodationDetails;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaskRequirementEntity> requirements;
}
