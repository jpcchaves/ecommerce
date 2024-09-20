package com.jpcchaves.ecommerce.model;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa_juridica")
@PrimaryKeyJoinColumn(
    name = "pessoa_id",
    referencedColumnName = "id",
    foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
public class PessoaJuridica extends Pessoa implements Serializable {
  private static final long serialVersionUID = -7283560402401510313L;

  @CNPJ(message = "CNPJ invalido")
  @Column(nullable = false)
  private String cnpj;

  private String inscEstadual;
  private String inscMunicipal;

  @Column(nullable = false)
  private String nomeFanstasia;

  @Column(nullable = false)
  private String razaoSocial;

  private String categoria;

  public PessoaJuridica() {}

  public PessoaJuridica(
      String cnpj,
      String inscEstadual,
      String inscMunicipal,
      String nomeFanstasia,
      String razaoSocial,
      String categoria) {
    this.cnpj = cnpj;
    this.inscEstadual = inscEstadual;
    this.inscMunicipal = inscMunicipal;
    this.nomeFanstasia = nomeFanstasia;
    this.razaoSocial = razaoSocial;
    this.categoria = categoria;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getInscEstadual() {
    return inscEstadual;
  }

  public void setInscEstadual(String inscEstadual) {
    this.inscEstadual = inscEstadual;
  }

  public String getInscMunicipal() {
    return inscMunicipal;
  }

  public void setInscMunicipal(String inscMunicipal) {
    this.inscMunicipal = inscMunicipal;
  }

  public String getNomeFanstasia() {
    return nomeFanstasia;
  }

  public void setNomeFanstasia(String nomeFanstasia) {
    this.nomeFanstasia = nomeFanstasia;
  }

  public String getRazaoSocial() {
    return razaoSocial;
  }

  public void setRazaoSocial(String razaoSocial) {
    this.razaoSocial = razaoSocial;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  @Override
  public String toString() {
    return "PessoaJuridica{"
        + "cnpj='"
        + cnpj
        + '\''
        + ", inscEstadual='"
        + inscEstadual
        + '\''
        + ", inscMunicipal='"
        + inscMunicipal
        + '\''
        + ", nomeFanstasia='"
        + nomeFanstasia
        + '\''
        + ", razaoSocial='"
        + razaoSocial
        + '\''
        + ", categoria='"
        + categoria
        + '\''
        + '}';
  }
}
