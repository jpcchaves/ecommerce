package com.jpcchaves.ecommerce.service.impl;

import com.jpcchaves.ecommerce.model.Acesso;
import com.jpcchaves.ecommerce.repository.AcessoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AcessoServiceImplTest {

  @Autowired
  private AcessoServiceImpl acessoService;

  @Autowired
  private AcessoRepository acessoRepository;
  
  @Test
  void testCreateAcesso() {
    Acesso acesso = new Acesso();

    acesso.setDescricao("ROLE_ADIN");

    acessoRepository.save(acesso);
  }
}