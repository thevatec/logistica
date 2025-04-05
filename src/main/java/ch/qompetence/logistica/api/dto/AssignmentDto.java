package ch.qompetence.logistica.api.dto;

import lombok.NonNull;

public record AssignmentDto(
        @NonNull String id,
        @NonNull String taskId,
        @NonNull String personnelId,
        @NonNull String status,
        String requirementId
) {}