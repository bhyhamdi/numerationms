package com.numeration.services;

import com.numeration.entities.Configuration;
import com.numeration.entities.reposiorty.ConfigurationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConfigurationServiceImpl  implements ConfigurationService {
    private final ConfigurationRepository configurationRepository;

    public Configuration saveConfig(Configuration config) {
        return configurationRepository.save(config) ;
    }

    public List<Configuration> getAllConfigs() {
        return configurationRepository.findAll();
    }
}
