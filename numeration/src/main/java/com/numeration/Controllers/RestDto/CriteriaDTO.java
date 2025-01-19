package com.numeration.Controllers.RestDto;

import com.numeration.enums.CriteriaType;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CriteriaDTO(
        @NotNull Integer sortOrder,
        @NotNull CriteriaType type,
        @NotNull String format,
        @NotNull String name,
        String prefix,
        String suffix
) {
}
