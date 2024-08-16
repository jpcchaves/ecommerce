package com.jpcchaves.ecommerce.controller;

import com.jpcchaves.ecommerce.model.PessoaFisica;
import com.jpcchaves.ecommerce.model.PessoaJuridica;
import com.jpcchaves.ecommerce.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pessoas")
public class PessoaController {

  private final PessoaService pessoaService;

  public PessoaController(PessoaService pessoaService) {
    this.pessoaService = pessoaService;
  }

  @PostMapping("/pj")
  public ResponseEntity<PessoaJuridica> salvarPJ(@RequestBody PessoaJuridica pessoaJuridica) {

    return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.salvarPJ(pessoaJuridica));
  }

  @PostMapping("/pf")
  public ResponseEntity<PessoaFisica> salvarPF(@RequestBody PessoaFisica pessoaFisica) {

    return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.salvarPF(pessoaFisica));
  }
}
