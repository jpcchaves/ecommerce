package com.jpcchaves.ecommerce.service;

import com.jpcchaves.ecommerce.model.PessoaFisica;
import com.jpcchaves.ecommerce.model.PessoaJuridica;

public interface PessoaService {

  PessoaJuridica salvarPJ(PessoaJuridica pessoaJuridica);

  PessoaFisica salvarPF(PessoaFisica pessoaFisica);
}
