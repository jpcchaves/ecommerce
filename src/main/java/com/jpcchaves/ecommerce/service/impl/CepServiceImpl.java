package com.jpcchaves.ecommerce.service.impl;

import com.jpcchaves.ecommerce.model.dto.ViaCepDTO;
import com.jpcchaves.ecommerce.service.CepService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepServiceImpl implements CepService {


    @Override
    public ViaCepDTO consultaCep(String cep) {

        new StringBuilder(cep).reverse();

        return new RestTemplate()
                .getForEntity(String.format("https://viacep.com.br/ws/%s/json", cep), ViaCepDTO.class)
                .getBody();
    }
}
