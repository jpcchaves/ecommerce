package com.jpcchaves.ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "pessoa_juridica")
@PrimaryKeyJoinColumn(
    name = "pessoa_id",
    referencedColumnName = "id",
    foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
public class PessoaJuridica extends Pessoa implements Serializable {
  private static final long serialVersionUID = -7283560402401510313L;

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
