package com.drogas.TaskBack.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskRequestDTO(
        @NotBlank String description,
        @NotNull Boolean completed
) { }
