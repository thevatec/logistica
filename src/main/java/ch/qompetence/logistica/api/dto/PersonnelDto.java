package ch.qompetence.logistica.api.dto;

import lombok.NonNull;
import java.util.List;

public record PersonnelDto(
        @NonNull String id,
        @NonNull String name,
        @NonNull String grade,
        boolean available,
        @NonNull List<SkillDto> skills,
        @NonNull List<VacationDayDto> vacationDays
) {}