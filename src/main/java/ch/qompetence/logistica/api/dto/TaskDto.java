package ch.qompetence.logistica.api.dto;

import lombok.Builder;
import lombok.NonNull;

import java.util.List;

@Builder(toBuilder = true)
public record TaskDto(
        @NonNull String id,
        @NonNull String name,
        @NonNull String location,
        @NonNull String startDate,
        @NonNull String endDate,
        boolean mealsProvided,
        boolean accommodationProvided,
        String mealsDetails,
        String accommodationDetails,
        @NonNull List<TaskRequirementDto> requirements
) {}