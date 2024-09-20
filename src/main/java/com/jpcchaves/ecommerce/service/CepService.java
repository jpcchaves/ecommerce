package com.jpcchaves.ecommerce.service;

import com.jpcchaves.ecommerce.model.dto.ViaCepDTO;

public interface CepService {

    ViaCepDTO consultaCep(String cep);
}
