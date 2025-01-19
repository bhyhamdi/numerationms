package com.numeration.services;

import com.numeration.entities.Configuration;
import com.numeration.entities.Criteria;
import com.numeration.entities.Form;
import com.numeration.entities.reposiorty.ConfigurationRepository;
import com.numeration.entities.reposiorty.FormRepository;
import com.numeration.enums.CriteriaType;
import com.numeration.services.ServiceDTO.FromDomainDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FormServiceImpl implements FormService {
    private final FormRepository formRepository;
    private final ConfigurationRepository configurationRepository;

    @Override
    public String saveForm(FromDomainDTO form) {
        Configuration configuration = configurationRepository
                .findById(form.getConfigureId())
                .orElseThrow(() -> new RuntimeException("Configuration not found by id " + form.getConfigureId()));

        String numeration = generateNumeration(configuration.getCriteriaList(), form.getFields());
         formRepository.save(
                Form.builder()
                        .config(configuration)
                        .numeration(numeration)
                        .fields(formatFields(form.getFields()))
                        .build());
        return numeration ;
    }

    private String formatFields(List<String> fields) {
        return String.join(";", fields);
    }

    private String generateNumeration(List<Criteria> criteriaList, List<String> fields) {
        criteriaList.sort(Comparator.comparingInt(Criteria::getSortOrder));
        return criteriaList.stream()
                .map(criteria -> {
                    String value = (criteria.getType() == CriteriaType.COMPUTER)
                            ? String.valueOf(configurationRepository.count() + 1)
                            : fields.get(criteriaList.indexOf(criteria));
                    return formatValue(criteria, value);
                })
                .collect(Collectors.joining());
    }


    private String formatValue(Criteria criteria, String value) {
        switch (criteria.getType()) {
            case STRING:
                return formatString(value, criteria);
            case DATE:
                return formatDate(value, criteria);
            case COMPUTER:
                return formatComputer(value, criteria);
            default:
                throw new RuntimeException("Unknown criteria type: " + criteria.getType());
        }
    }

    private String formatString(String value, Criteria criteria) {
        String[] parts = criteria.getFormat().split("-");
        int start = Integer.parseInt(parts[0]);
        int end = Integer.parseInt(parts[1]);
        String substring = value.substring(start, end + 1);

        String prefix = criteria.getPrefix() != null ? criteria.getPrefix() : "";
        String suffix = criteria.getSuffix() != null ? criteria.getSuffix() : "";

        return prefix + substring + suffix;
    }

    private String formatDate(String value, Criteria criteria) {
        LocalDate date = LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        String formattedDate = date.format(DateTimeFormatter.ofPattern(criteria.getFormat()));

        String prefix = criteria.getPrefix() != null ? criteria.getPrefix() : "";
        String suffix = criteria.getSuffix() != null ? criteria.getSuffix() : "";

        return prefix + formattedDate + suffix;
    }
    private String formatComputer(String value, Criteria criteria) {
        int counter = Integer.parseInt(value);
        String counterStr = String.format("%0" + criteria.getFormat().substring(1) + "d", counter);
        String prefix = criteria.getPrefix() != null ? criteria.getPrefix() : "";
        String suffix = criteria.getSuffix() != null ? criteria.getSuffix() : "";
        return prefix + counterStr + suffix;
    }
}