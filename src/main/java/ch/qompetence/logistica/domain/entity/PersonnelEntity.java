package ch.qompetence.logistica.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity(name = "personnel")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PersonnelEntity {
    @Id
    private String id;

    private String name;
    private String grade;
    private boolean available;

    @ManyToMany
    @JoinTable(name = "personnel_skill",
            joinColumns = @JoinColumn(name = "personnel_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<SkillEntity> skills;

    @OneToMany(mappedBy = "personnel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VacationDayEntity> vacationDays;
}