package com.jpcchaves.ecommerce.controller;

import com.jpcchaves.ecommerce.model.Acesso;
import com.jpcchaves.ecommerce.service.AcessoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/acessos")
public class AcessoController {

  private final AcessoService acessoService;

  public AcessoController(AcessoService acessoService) {
    this.acessoService = acessoService;
  }

  @PostMapping
  public ResponseEntity<Acesso> salvarAcesso(@RequestBody Acesso acesso) {

    return new ResponseEntity<>(acessoService.salvar(acesso),
        HttpStatus.CREATED);
  }
}
