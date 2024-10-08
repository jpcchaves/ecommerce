package com.jpcchaves.ecommerce.repository;

import com.jpcchaves.ecommerce.model.Pessoa;
import com.jpcchaves.ecommerce.model.PessoaFisica;
import com.jpcchaves.ecommerce.model.PessoaJuridica;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

  @Query(value = "select pj from PessoaJuridica pj where pj.cnpj = ?1")
  PessoaJuridica existsByCnpj(String cnpj);

  @Query(value = "select pf from PessoaFisica pf where pf.cpf = ?1")
  PessoaFisica existsByCpf(String cpf);

  @Query(value = "select pj from PessoaJuridica pj where pj.inscEstadual = ?1")
  PessoaJuridica existsByInscEstadual(String inscEstadual);

  @Query(value = "select pf from PessoaFisica pf where upper(trim(pf.nome)) like %?1%")
  List<PessoaFisica> pesquisaPorNome(String nome);

  @Query(value = "select pf from PessoaFisica pf where pf.cpf = ?1")
  List<PessoaFisica> pesquisaPorCPF(String cpf);

  @Query(value = "select pj from PessoaJuridica pj where pj.cnpj = ?1")
  List<PessoaJuridica> pesquisaPorCNPJ(String cnpj);
}
