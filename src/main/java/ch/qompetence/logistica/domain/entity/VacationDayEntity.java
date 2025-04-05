package ch.qompetence.logistica.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity(name = "vacation_day")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class VacationDayEntity {
    @Id @UuidGenerator
    private String id;
    private String date;

    @ManyToOne
    @JoinColumn(name = "personnel_id", nullable = false)
    private PersonnelEntity personnel;
}