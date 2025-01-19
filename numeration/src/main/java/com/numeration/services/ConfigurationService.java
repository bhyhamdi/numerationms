package com.numeration.services;

import com.numeration.entities.Configuration;

import java.util.List;

public interface ConfigurationService {
    Configuration saveConfig(Configuration config) ;
    List<Configuration> getAllConfigs();
}
