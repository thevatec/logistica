package ch.qompetence.logistica.api.dto;

import lombok.NonNull;

public record TaskRequirementDto(
        @NonNull String id,
        String skillId,
        String skillName,
        int count,
        @NonNull String priority
) {}