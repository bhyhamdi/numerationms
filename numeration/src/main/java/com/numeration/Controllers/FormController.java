package com.numeration.Controllers;

import com.numeration.Controllers.RestDto.FormDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User", description = "APIs for managing Forms")
public interface FormController {

    @Operation(
            summary = "Save a Form",
            description = "Saves a new user to the Form",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Form saved successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid input")
            }
    )
    String saveForm(FormDTO userDTO);
}