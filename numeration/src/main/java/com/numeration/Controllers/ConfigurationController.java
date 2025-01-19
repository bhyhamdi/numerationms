package com.numeration.Controllers;

import com.numeration.Controllers.RestDto.ConfigurationDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Configuration", description = "APIs for managing configurations")
public interface ConfigurationController {

    @Operation(
            summary = "Save a configuration",
            description = "Saves a new configuration to the system",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Configuration saved successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid input")
            }
    )
    ConfigurationDTO saveConfig(ConfigurationDTO config);

    @Operation(
            summary = "Get all configurations",
            description = "Retrieves a list of all configurations",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of configurations retrieved successfully")
            }
    )
    List<ConfigurationDTO> getAllConfigs();
}