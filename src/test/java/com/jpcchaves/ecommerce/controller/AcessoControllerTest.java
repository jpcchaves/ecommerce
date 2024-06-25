package com.jpcchaves.ecommerce.controller;

import com.jpcchaves.ecommerce.model.*;
import com.jpcchaves.ecommerce.repository.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AcessoControllerTest {

  @Autowired
  AcessoRepository acessoRepository;
  @Autowired
  private AcessoController acessoController;

  @Test
  public void salvarAcesso() {
    Acesso acesso = new Acesso();

    acesso.setDescricao("ROLE_TEST");

    acesso = acessoController.salvarAcesso(acesso)
                             .getBody();

    // assert if the object returned by the database isn't null
    assertNotNull(acesso);

    // assert if the ID was generated successfully and the value are greater
    // than 0
    assertTrue(acesso.getId() > 0);


    // Fetch the created accesso
    Acesso createdAcesso = acessoRepository.findById(acesso.getId())
                                           .get();
    assertNotNull(createdAcesso);

    assertEquals(acesso.getId(), createdAcesso.getId());

    // Delete the created acesso
    acessoRepository.deleteById(createdAcesso.getId());

    // Update DB
    acessoRepository.flush();

    Acesso deletedAcesso = acessoRepository.findById(createdAcesso.getId())
                                           .orElse(null);

    assertNull(deletedAcesso);

    // Query
    acesso = new Acesso();

    acesso.setDescricao("ROLE_ALUNO");

    acesso = acessoController.salvarAcesso(acesso)
                             .getBody();

    List<Acesso> acessosList = acessoRepository.findAcessoByDescricao("ALUNO".trim()
                                                                             .toUpperCase());
    assertNotNull(acesso);
    assertEquals(1, acessosList.size());

    acessoRepository.deleteById(acesso.getId());
  }
}
