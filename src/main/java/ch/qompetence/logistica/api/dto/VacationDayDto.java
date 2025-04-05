package ch.qompetence.logistica.api.dto;

import lombok.NonNull;

import java.util.List;


import lombok.NonNull;

public record VacationDayDto(@NonNull String id, @NonNull String date, @NonNull String personnelId) {}