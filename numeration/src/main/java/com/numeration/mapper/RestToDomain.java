package com.numeration.mapper;

import com.numeration.Controllers.RestDto.ConfigurationDTO;
import com.numeration.Controllers.RestDto.FormDTO;
import com.numeration.entities.Configuration;
import com.numeration.services.ServiceDTO.FromDomainDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestToDomain {
    Configuration toConfiguration(ConfigurationDTO configurationDTO);

    FromDomainDTO toForm(FormDTO formDTO);
}
