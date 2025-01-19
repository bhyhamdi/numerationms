package com.numeration.Controllers;

import com.numeration.Controllers.RestDto.ConfigurationDTO;
import com.numeration.mapper.DomainToRest;
import com.numeration.mapper.RestToDomain;
import com.numeration.services.ConfigurationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/configuration")
@RequiredArgsConstructor
public class ConfigurationControllerImpl implements ConfigurationController {
    private final ConfigurationService configurationService;
    private final RestToDomain restToDomain;
    private final DomainToRest domainToRest;

    @PostMapping
    @Override
    public ConfigurationDTO saveConfig(@RequestBody ConfigurationDTO config) {
        return domainToRest.toConfigurationDTO(configurationService.saveConfig(restToDomain.toConfiguration(config)));
    }

    @GetMapping
    @Override
    public List<ConfigurationDTO> getAllConfigs() {
        return configurationService.getAllConfigs().stream().map(domainToRest::toConfigurationDTO).toList();
    }

}
