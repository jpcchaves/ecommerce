package com.jpcchaves.ecommerce.model;

import java.io.*;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "avaliacao_produto")
@SequenceGenerator(
    name = "seq_avaliacao_produto",
    sequenceName = "seq_avaliacao_produto",
    allocationSize = 1)
public class AvaliacaoProduto implements Serializable {
  private static final long serialVersionUID = 1052990720486506029L;

  @Id
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "seq_avaliacao_produto")
  private Long id;

  private Integer nota;

  private String descricao;

  @ManyToOne(targetEntity = Pessoa.class)
  @JoinColumn(
      name = "pessoa_id",
      nullable = false,
      foreignKey =
          @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
  private Pessoa pessoa;

  @ManyToOne
  @JoinColumn(
      name = "produto_id",
      nullable = false,
      foreignKey =
          @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "produto_fk"))
  private Produto produto;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getNota() {
    return nota;
  }

  public void setNota(Integer nota) {
    this.nota = nota;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Pessoa getPessoa() {
    return pessoa;
  }

  public void setPessoa(Pessoa pessoa) {
    this.pessoa = pessoa;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AvaliacaoProduto that = (AvaliacaoProduto) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
