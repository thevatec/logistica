package ch.qompetence.logistica.api.dto;

import lombok.Builder;
import lombok.NonNull;

@Builder(toBuilder = true)
public record CreateTaskRequirementRequest(
        String skillId,
        String skillName,
        int count,
        @NonNull String priority
) {}
