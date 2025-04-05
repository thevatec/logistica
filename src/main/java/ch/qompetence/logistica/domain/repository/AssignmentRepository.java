package ch.qompetence.logistica.domain.repository;

import ch.qompetence.logistica.domain.entity.AssignmentEntity;
import ch.qompetence.logistica.domain.entity.PersonnelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository extends JpaRepository<AssignmentEntity, String> {}