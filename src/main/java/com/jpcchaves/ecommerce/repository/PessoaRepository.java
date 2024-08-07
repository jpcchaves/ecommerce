package com.jpcchaves.ecommerce.repository;

import com.jpcchaves.ecommerce.model.Pessoa;
import com.jpcchaves.ecommerce.model.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

  @Query(value = "select pj from PessoaJuridica pj where pj.cnpj = ?1")
  PessoaJuridica existsByCnpj(String cnpj);
}
