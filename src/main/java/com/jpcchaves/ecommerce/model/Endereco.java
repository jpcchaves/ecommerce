package com.jpcchaves.ecommerce.model;

import com.jpcchaves.ecommerce.enums.TipoEndereco;
import java.io.*;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "endereco")
@SequenceGenerator(
    name = "seq_endereco",
    sequenceName = "seq_endereco",
    allocationSize = 1)
public class Endereco implements Serializable {
  private static final long serialVersionUID = -1963101071500820594L;

  @Id
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "seq_endereco")
  private Long id;

  @Column(nullable = false)
  private String ruaLogradouro;

  @Column(nullable = false)
  private String cep;

  @Column(nullable = false)
  private String numero;

  private String complemento;

  @Column(nullable = false)
  private String bairro;

  @Column(nullable = false)
  private String uf;

  @Column(nullable = false)
  private String cidade;

  @ManyToOne(targetEntity = Pessoa.class)
  @JoinColumn(
      name = "pessoa_id",
      nullable = false,
      foreignKey =
          @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
  private Pessoa pessoa;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private TipoEndereco tipoEndereco;

  public Endereco() {}

  public Endereco(
      Long id,
      String ruaLogradouro,
      String cep,
      String numero,
      String complemento,
      String bairro,
      String uf,
      String cidade,
      Pessoa pessoa,
      TipoEndereco tipoEndereco) {
    this.id = id;
    this.ruaLogradouro = ruaLogradouro;
    this.cep = cep;
    this.numero = numero;
    this.complemento = complemento;
    this.bairro = bairro;
    this.uf = uf;
    this.cidade = cidade;
    this.pessoa = pessoa;
    this.tipoEndereco = tipoEndereco;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRuaLogradouro() {
    return ruaLogradouro;
  }

  public void setRuaLogradouro(String ruaLogradouro) {
    this.ruaLogradouro = ruaLogradouro;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public Pessoa getPessoa() {
    return pessoa;
  }

  public void setPessoa(Pessoa pessoa) {
    this.pessoa = pessoa;
  }

  public TipoEndereco getTipoEndereco() {
    return tipoEndereco;
  }

  public void setTipoEndereco(TipoEndereco tipoEndereco) {
    this.tipoEndereco = tipoEndereco;
  }

  @Override
  public String toString() {
    return "Endereco{"
        + "id="
        + id
        + ", ruaLogradouro='"
        + ruaLogradouro
        + '\''
        + ", cep='"
        + cep
        + '\''
        + ", numero='"
        + numero
        + '\''
        + ", complemento='"
        + complemento
        + '\''
        + ", bairro='"
        + bairro
        + '\''
        + ", uf='"
        + uf
        + '\''
        + ", cidade='"
        + cidade
        + '\''
        + ", pessoa="
        + pessoa
        + ", tipoEndereco="
        + tipoEndereco
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Endereco endereco = (Endereco) o;
    return Objects.equals(id, endereco.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
