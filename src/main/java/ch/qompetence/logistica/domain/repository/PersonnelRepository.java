package ch.qompetence.logistica.domain.repository;

import ch.qompetence.logistica.domain.entity.PersonnelEntity;
import ch.qompetence.logistica.domain.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelRepository extends JpaRepository<PersonnelEntity, String> {}