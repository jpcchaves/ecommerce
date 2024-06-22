package com.jpcchaves.ecommerce.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa", allocationSize = 1)
public abstract class Pessoa implements Serializable {
  private static final long serialVersionUID = 6231994013157388754L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
  private Long id;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String telefone;

  @OneToMany(
      mappedBy = "pessoa",
      orphanRemoval = true,
      cascade = CascadeType.ALL,
      fetch = FetchType.LAZY)
  private List<Endereco> enderecos = new ArrayList<>();

  public Pessoa() {}

  public Pessoa(
      Long id,
      String nome,
      String email,
      String telefone,
      List<Endereco> enderecos) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.telefone = telefone;
    this.enderecos = enderecos;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public List<Endereco> getEnderecos() {
    return enderecos;
  }

  public void setEnderecos(List<Endereco> enderecos) {
    this.enderecos = enderecos;
  }

  @Override
  public String toString() {
    return "Pessoa{"
        + "id="
        + id
        + ", nome='"
        + nome
        + '\''
        + ", email='"
        + email
        + '\''
        + ", telefone='"
        + telefone
        + '\''
        + ", enderecos="
        + enderecos
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pessoa pessoa = (Pessoa) o;
    return Objects.equals(id, pessoa.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
