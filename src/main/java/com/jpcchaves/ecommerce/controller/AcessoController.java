package com.jpcchaves.ecommerce.controller;

import com.jpcchaves.ecommerce.model.*;
import com.jpcchaves.ecommerce.repository.*;
import com.jpcchaves.ecommerce.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/acessos")
public class AcessoController {

  private final AcessoService acessoService;
  private final AcessoRepository acessoRepository;

  public AcessoController(
      AcessoService acessoService,
      AcessoRepository acessoRepository
  ) {
    this.acessoService = acessoService;
    this.acessoRepository = acessoRepository;
  }

  @PostMapping
  public ResponseEntity<Acesso> salvarAcesso(@RequestBody Acesso acesso) {

    return new ResponseEntity<>(acessoService.salvar(acesso),
                                HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Acesso>> findByDescricao(@RequestParam(name = "desc") String descricao) {
    return ResponseEntity.ok(acessoRepository.findAcessoByDescricao(descricao));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Acesso> getById(@PathVariable(name = "id") Long id) {
    Acesso acesso = acessoRepository.findById(id)
                                    .orElse(null);

    return ResponseEntity.ok(acesso);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteAcesso(@PathVariable(name = "id") Long id) {

    acessoRepository.deleteById(id);

    return new ResponseEntity<>("Acesso deletado com sucesso!", HttpStatus.NO_CONTENT);
  }
}
