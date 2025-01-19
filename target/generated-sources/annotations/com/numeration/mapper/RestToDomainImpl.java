package com.numeration.mapper;

import com.numeration.Controllers.RestDto.ConfigurationDTO;
import com.numeration.Controllers.RestDto.CriteriaDTO;
import com.numeration.Controllers.RestDto.FormDTO;
import com.numeration.entities.Configuration;
import com.numeration.entities.Criteria;
import com.numeration.services.ServiceDTO.FromDomainDTO;
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
public class RestToDomainImpl implements RestToDomain {

    @Override
    public Configuration toConfiguration(ConfigurationDTO configurationDTO) {
        if ( configurationDTO == null ) {
            return null;
        }

        Configuration.ConfigurationBuilder configuration = Configuration.builder();

        configuration.name( configurationDTO.name() );
        configuration.criteriaList( criteriaDTOListToCriteriaList( configurationDTO.criteriaList() ) );

        return configuration.build();
    }

    @Override
    public FromDomainDTO toForm(FormDTO formDTO) {
        if ( formDTO == null ) {
            return null;
        }

        FromDomainDTO.FromDomainDTOBuilder fromDomainDTO = FromDomainDTO.builder();

        fromDomainDTO.configureId( formDTO.configureId() );
        List<String> list = formDTO.fields();
        if ( list != null ) {
            fromDomainDTO.fields( new ArrayList<String>( list ) );
        }

        return fromDomainDTO.build();
    }

    protected Criteria criteriaDTOToCriteria(CriteriaDTO criteriaDTO) {
        if ( criteriaDTO == null ) {
            return null;
        }

        Criteria.CriteriaBuilder criteria = Criteria.builder();

        criteria.sortOrder( criteriaDTO.sortOrder() );
        criteria.type( criteriaDTO.type() );
        criteria.name( criteriaDTO.name() );
        criteria.format( criteriaDTO.format() );
        criteria.prefix( criteriaDTO.prefix() );
        criteria.suffix( criteriaDTO.suffix() );

        return criteria.build();
    }

    protected List<Criteria> criteriaDTOListToCriteriaList(List<CriteriaDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Criteria> list1 = new ArrayList<Criteria>( list.size() );
        for ( CriteriaDTO criteriaDTO : list ) {
            list1.add( criteriaDTOToCriteria( criteriaDTO ) );
        }

        return list1;
    }
}
