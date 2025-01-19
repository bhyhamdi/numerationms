package com.numeration.Controllers.RestDto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record   FormDTO(
        @NotNull UUID configureId,
        @NotEmpty List<String> fields
) {
}
