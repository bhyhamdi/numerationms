package com.numeration.Controllers;

import com.numeration.Controllers.RestDto.FormDTO;
import com.numeration.mapper.DomainToRest;
import com.numeration.mapper.RestToDomain;
import com.numeration.services.FormService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/form")
@RequiredArgsConstructor
public class FormControllerImpl implements FormController {
    private final FormService formService;
    private final RestToDomain restToDomain;
    private final DomainToRest domainToRest;

    @PostMapping
    @Override
    public String saveForm(FormDTO formDTO) {
        return formService.saveForm(restToDomain.toForm(formDTO));
    }
}
