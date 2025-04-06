package ch.qompetence.logistica.service;

import ch.qompetence.logistica.api.dto.CreateTaskRequest;
import ch.qompetence.logistica.api.dto.TaskDto;
import ch.qompetence.logistica.api.mapper.TaskMapper;
import ch.qompetence.logistica.domain.repository.SkillRepository;
import ch.qompetence.logistica.domain.repository.TaskRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final SkillRepository skillRepository;

    public TaskDto createTask(@NonNull final CreateTaskRequest request) {
        final var updatedRequirements = request.requirements().stream()
                .map(requirement -> requirement.toBuilder()
                        .skillName(skillRepository.findById(requirement.skillId())
                                .orElseThrow(() -> new RuntimeException("Skill not found"))
                                .getName())
                        .build())
                .toList();
        final var updatedRequest = request.toBuilder().requirements(updatedRequirements).build();
        final var taskEntity = taskMapper.toEntity(updatedRequest);
        if (taskEntity.getRequirements() != null) {
            taskEntity.setRequirements(taskEntity.getRequirements().stream()
                    .peek(requirement -> requirement.setTask(taskEntity))
                    .toList());
        }
        final var savedTask = taskRepository.save(taskEntity);
        return taskMapper.toDto(savedTask);
    }


    @Transactional(readOnly = true)
    public List<TaskDto> getAllTasks() {
        final var tasks = taskRepository.findAll();
        return tasks.stream()
                .map(taskMapper::toDto)
                .toList();
    }

    @Transactional
    public void deleteTask(String id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task with id " + id + " not found");
        }
        taskRepository.deleteById(id);
    }

    @Transactional
    public TaskDto updateTask(String id, TaskDto dto) {
        final var entity = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found: " + id));
        final var dtoWithId = dto.toBuilder().id(id).build();
        taskMapper.updateTaskFromDto(dtoWithId, entity);
        taskRepository.save(entity);
        return taskMapper.toDto(entity);
    }
}