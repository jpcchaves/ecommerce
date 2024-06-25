package com.jpcchaves.ecommerce.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.jpcchaves.ecommerce.model.Acesso;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AcessoControllerTest {

  @Autowired
  private AcessoController acessoController;

  @Test
  public void salvarAcesso() {
    Acesso acesso = new Acesso();

    acesso.setDescricao("ROLE_TEST");

    acesso = acessoController.salvarAcesso(acesso).getBody();

    // assert if the object returned by the database isn't null
    assertNotNull(acesso);

    // assert if the ID was generated successfully and the value are greater than 0
    assertTrue(acesso.getId() > 0);
  }
}