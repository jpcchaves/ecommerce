package com.jpcchaves.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name = "pessoa_juridica")
@PrimaryKeyJoinColumn(name = "id")
public class PessoaJuridica extends Pessoa implements Serializable {
  private static final long serialVersionUID = -7283560402401510313L;

  private String cnpj;
  private String inscEstadual;
  private String inscMunicipal;
  private String nomeFanstasia;
  private String razaoSocial;
  private String categoria;

  public PessoaJuridica() {
  }

  public PessoaJuridica(String cnpj,
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
    return "PessoaJuridica{" +
        "cnpj='" + cnpj + '\'' +
        ", inscEstadual='" + inscEstadual + '\'' +
        ", inscMunicipal='" + inscMunicipal + '\'' +
        ", nomeFanstasia='" + nomeFanstasia + '\'' +
        ", razaoSocial='" + razaoSocial + '\'' +
        ", categoria='" + categoria + '\'' +
        '}';
  }
}
