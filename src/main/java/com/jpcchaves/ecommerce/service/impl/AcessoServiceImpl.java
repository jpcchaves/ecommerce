package com.jpcchaves.ecommerce.service.impl;

import com.jpcchaves.ecommerce.exception.*;
import com.jpcchaves.ecommerce.model.*;
import com.jpcchaves.ecommerce.repository.*;
import com.jpcchaves.ecommerce.service.*;
import org.springframework.stereotype.*;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
public class AcessoServiceImpl implements AcessoService {

  private final AcessoRepository acessoRepository;

  public AcessoServiceImpl(AcessoRepository acessoRepository) {
    this.acessoRepository = acessoRepository;
  }

  @Override
  public Acesso salvar(Acesso acesso) {

    if (!findByDesc(acesso.getDescricao()).isEmpty()) {

      throw new DuplicateResourceException("Ja existe um acesso com a descricao informada: " + acesso.getDescricao());
    }

    return acessoRepository.save(acesso);
  }

  @Override
  public Acesso findById(Long acessoId) {

    return acessoRepository.findById(acessoId)
                           .orElseThrow(() -> new EntityNotFoundException("Acesso not found with the given id"));
  }

  @Override
  public List<Acesso> findByDesc(String desc) {

    return acessoRepository.findAcessoByDescricao(desc);
  }
}
