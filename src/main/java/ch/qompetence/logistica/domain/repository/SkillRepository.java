package ch.qompetence.logistica.domain.repository;

import ch.qompetence.logistica.domain.entity.PersonnelEntity;
import ch.qompetence.logistica.domain.entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<SkillEntity, String> {
    SkillEntity findByName(String name);
}