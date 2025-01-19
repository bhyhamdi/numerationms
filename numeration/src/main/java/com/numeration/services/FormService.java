package com.numeration.services;

import com.numeration.entities.Form;
import com.numeration.services.ServiceDTO.FromDomainDTO;

public interface FormService {
    String saveForm(FromDomainDTO fromDomainDTO);
}
