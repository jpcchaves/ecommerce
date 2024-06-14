package com.jpcchaves.ecommerce.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa", allocationSize = 1)
public abstract class Pessoa implements Serializable {
  private static final long serialVersionUID = 6231994013157388754L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
  private Long id;

  private String nome;
  private String email;
  private String telefone;

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

  @Override
  public String toString() {
    return "Pessoa{" +
        "id=" + id +
        ", nome='" + nome + '\'' +
        ", email='" + email + '\'' +
        ", telefone='" + telefone + '\'' +
        '}';
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
