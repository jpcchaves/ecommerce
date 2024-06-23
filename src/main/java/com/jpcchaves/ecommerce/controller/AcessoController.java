package com.jpcchaves.ecommerce.controller;

import com.jpcchaves.ecommerce.service.AcessoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AcessoController {

  private final AcessoService acessoService;

  public AcessoController(AcessoService acessoService) {
    this.acessoService = acessoService;
  }

  @PostMapping
  public String salvarAcesso() {
    return "Test";
  }
}
