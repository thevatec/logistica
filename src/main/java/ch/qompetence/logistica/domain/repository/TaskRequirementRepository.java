package ch.qompetence.logistica.domain.repository;

import ch.qompetence.logistica.domain.entity.TaskRequirementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRequirementRepository extends JpaRepository<TaskRequirementEntity, String> {}
