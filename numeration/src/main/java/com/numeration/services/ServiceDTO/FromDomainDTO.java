package com.numeration.services.ServiceDTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FromDomainDTO {
   private UUID configureId;
    private List<String> fields;
}
