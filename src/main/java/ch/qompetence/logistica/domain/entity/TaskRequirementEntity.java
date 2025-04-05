package ch.qompetence.logistica.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity(name = "task_requirement")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TaskRequirementEntity {
    @Id @UuidGenerator
    private String id;
    private String skillId;
    private String skillName;
    private int count;
    private String priority;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private TaskEntity task;
}