package com.numeration.Controllers.RestDto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;

@Builder
public record ConfigurationDTO(@NotNull String name, List<CriteriaDTO> criteriaList) {
}
