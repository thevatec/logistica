package ch.qompetence.logistica.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity(name = "assignment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AssignmentEntity {
    @Id
    private String id;
    private String status;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private TaskEntity task;

    @ManyToOne
    @JoinColumn(name = "personnel_id", nullable = false)
    private PersonnelEntity personnel;

    @ManyToOne
    @JoinColumn(name = "requirement_id")
    private TaskRequirementEntity requirement;
}