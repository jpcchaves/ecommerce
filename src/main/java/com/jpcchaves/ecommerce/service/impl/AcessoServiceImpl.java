package com.jpcchaves.ecommerce.service.impl;

import com.jpcchaves.ecommerce.model.Acesso;
import com.jpcchaves.ecommerce.repository.AcessoRepository;
import com.jpcchaves.ecommerce.service.AcessoService;
import org.springframework.stereotype.Service;

@Service
public class AcessoServiceImpl implements AcessoService {

  private final AcessoRepository acessoRepository;

  public AcessoServiceImpl(AcessoRepository acessoRepository) {
    this.acessoRepository = acessoRepository;
  }

  @Override
  public Acesso salvar(Acesso acesso) {
    return acessoRepository.save(acesso);
  }
}
