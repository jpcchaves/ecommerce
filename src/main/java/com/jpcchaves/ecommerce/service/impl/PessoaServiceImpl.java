package com.jpcchaves.ecommerce.service.impl;

import com.jpcchaves.ecommerce.model.Pessoa;
import com.jpcchaves.ecommerce.repository.PessoaRepository;
import com.jpcchaves.ecommerce.service.PessoaService;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl implements PessoaService {

  private final PessoaRepository pessoaRepository;

  public PessoaServiceImpl(PessoaRepository pessoaRepository) {
    this.pessoaRepository = pessoaRepository;
  }

  @Override
  public String create(Pessoa pessoa) {
    pessoaRepository.save(pessoa);

    return "Pessoa criada com sucesso!";
  }
}
