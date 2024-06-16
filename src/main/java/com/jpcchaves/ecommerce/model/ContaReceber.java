package com.jpcchaves.ecommerce.model;

import com.jpcchaves.ecommerce.enums.StatusContaReceber;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "conta_receber")
@SequenceGenerator(
    name = "seq_conta_receber",
    sequenceName = "seq_conta_receber",
    allocationSize = 1)
public class ContaReceber implements Serializable {
  private static final long serialVersionUID = -4014739241814589240L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_conta_receber")
  private Long id;

  private String descricao;

  @Enumerated(EnumType.STRING)
  private StatusContaReceber status;

  @Temporal(TemporalType.DATE)
  private Date dtVencimento;

  @Temporal(TemporalType.DATE)
  private Date dtPagamento;

  private BigDecimal valorTotal;
  private BigDecimal valorDesconto;

  @ManyToOne(targetEntity = Pessoa.class)
  @JoinColumn(
      name = "pessoa_id",
      nullable = false,
      foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
  private Pessoa pessoa;

  public ContaReceber() {}

  public ContaReceber(
      Long id,
      String descricao,
      StatusContaReceber status,
      Date dtVencimento,
      Date dtPagamento,
      BigDecimal valorTotal,
      BigDecimal valorDesconto,
      Pessoa pessoa) {
    this.id = id;
    this.descricao = descricao;
    this.status = status;
    this.dtVencimento = dtVencimento;
    this.dtPagamento = dtPagamento;
    this.valorTotal = valorTotal;
    this.valorDesconto = valorDesconto;
    this.pessoa = pessoa;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public StatusContaReceber getStatus() {
    return status;
  }

  public void setStatus(StatusContaReceber status) {
    this.status = status;
  }

  public Date getDtVencimento() {
    return dtVencimento;
  }

  public void setDtVencimento(Date dtVencimento) {
    this.dtVencimento = dtVencimento;
  }

  public Date getDtPagamento() {
    return dtPagamento;
  }

  public void setDtPagamento(Date dtPagamento) {
    this.dtPagamento = dtPagamento;
  }

  public BigDecimal getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(BigDecimal valorTotal) {
    this.valorTotal = valorTotal;
  }

  public BigDecimal getValorDesconto() {
    return valorDesconto;
  }

  public void setValorDesconto(BigDecimal valorDesconto) {
    this.valorDesconto = valorDesconto;
  }

  public Pessoa getPessoa() {
    return pessoa;
  }

  public void setPessoa(Pessoa pessoa) {
    this.pessoa = pessoa;
  }

  @Override
  public String toString() {
    return "ContaReceber{"
        + "id="
        + id
        + ", descricao='"
        + descricao
        + '\''
        + ", status="
        + status
        + ", dtVencimento="
        + dtVencimento
        + ", dtPagamento="
        + dtPagamento
        + ", valorTotal="
        + valorTotal
        + ", valorDesconto="
        + valorDesconto
        + ", pessoa="
        + pessoa
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContaReceber that = (ContaReceber) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}