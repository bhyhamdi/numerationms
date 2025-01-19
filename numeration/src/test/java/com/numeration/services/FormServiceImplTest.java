package com.numeration.services;

import com.numeration.entities.Configuration;
import com.numeration.entities.Criteria;
import com.numeration.entities.Form;
import com.numeration.entities.reposiorty.ConfigurationRepository;
import com.numeration.entities.reposiorty.FormRepository;
import com.numeration.enums.CriteriaType;
import com.numeration.services.ServiceDTO.FromDomainDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FormServiceImplTest {

    @Mock
    private FormRepository formRepository;

    @Mock
    private ConfigurationRepository configurationRepository;

    @InjectMocks
    private FormServiceImpl formService;

    private Configuration configuration;
    private FromDomainDTO formDTO;

    @BeforeEach
    public void setUp() {
        // Configuration de test
        Criteria criteria1 = Criteria.builder()
                .sortOrder(1)
                .type(CriteriaType.STRING)
                .format("0-2")
                .name("name")
                .suffix("-")
                .build();

        Criteria criteria2 = Criteria.builder()
                .sortOrder(2)
                .type(CriteriaType.DATE)
                .format("yyyy")
                .name("naissance")
                .build();

        Criteria criteria3 = Criteria.builder()
                .sortOrder(3)
                .type(CriteriaType.STRING)
                .format("0-4")
                .name("surname")
                .suffix("_")
                .build();

        Criteria criteria4 = Criteria.builder()
                .sortOrder(4)
                .type(CriteriaType.COMPUTER)
                .format("*5")
                .name("coumpter")
                .prefix("C")
                .build();

        configuration = Configuration.builder()
                .id(UUID.randomUUID())
                .name("userconf1")
                .criteriaList(new ArrayList<>(List.of(criteria1, criteria2, criteria3, criteria4))) // Liste mutable
                .build();

        formDTO = FromDomainDTO.builder()
                .configureId(configuration.getId())
                .fields(List.of("hamdi", "1995/02/02", "belhadj youssef"))
                .build();
    }

    @Test
    public void testSaveForm_Success() {
        // GIVE
        when(configurationRepository.findById(configuration.getId())).thenReturn(Optional.of(configuration));
        when(configurationRepository.count()).thenReturn(10L);
        when(formRepository.save(any(Form.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // WHEN
        String result = formService.saveForm(formDTO);

        // THEN
        assertEquals("ham-1995belha_C00011", result);

    }


}
