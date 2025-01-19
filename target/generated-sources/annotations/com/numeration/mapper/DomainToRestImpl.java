package com.numeration.mapper;

import com.numeration.Controllers.RestDto.ConfigurationDTO;
import com.numeration.Controllers.RestDto.CriteriaDTO;
import com.numeration.entities.Configuration;
import com.numeration.entities.Criteria;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-19T12:16:55+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 21.0.3 (Amazon.com Inc.)"
)
@Component
public class DomainToRestImpl implements DomainToRest {

    @Override
    public ConfigurationDTO toConfigurationDTO(Configuration configuration) {
        if ( configuration == null ) {
            return null;
        }

        ConfigurationDTO.ConfigurationDTOBuilder configurationDTO = ConfigurationDTO.builder();

        configurationDTO.name( configuration.getName() );
        configurationDTO.criteriaList( criteriaListToCriteriaDTOList( configuration.getCriteriaList() ) );

        return configurationDTO.build();
    }

    protected CriteriaDTO criteriaToCriteriaDTO(Criteria criteria) {
        if ( criteria == null ) {
            return null;
        }

        CriteriaDTO.CriteriaDTOBuilder criteriaDTO = CriteriaDTO.builder();

        criteriaDTO.sortOrder( criteria.getSortOrder() );
        criteriaDTO.type( criteria.getType() );
        criteriaDTO.format( criteria.getFormat() );
        criteriaDTO.name( criteria.getName() );
        criteriaDTO.prefix( criteria.getPrefix() );
        criteriaDTO.suffix( criteria.getSuffix() );

        return criteriaDTO.build();
    }

    protected List<CriteriaDTO> criteriaListToCriteriaDTOList(List<Criteria> list) {
        if ( list == null ) {
            return null;
        }

        List<CriteriaDTO> list1 = new ArrayList<CriteriaDTO>( list.size() );
        for ( Criteria criteria : list ) {
            list1.add( criteriaToCriteriaDTO( criteria ) );
        }

        return list1;
    }
}
