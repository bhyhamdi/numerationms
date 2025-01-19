package com.numeration.mapper;

import com.numeration.Controllers.RestDto.ConfigurationDTO;
import com.numeration.entities.Configuration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DomainToRest {
    ConfigurationDTO toConfigurationDTO(Configuration configuration);

}
