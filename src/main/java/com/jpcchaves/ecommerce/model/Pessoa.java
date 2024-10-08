package com.jpcchaves.ecommerce.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa",
    allocationSize = 1)
public abstract class Pessoa implements Serializable {
  private static final long serialVersionUID = 6231994013157388754L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
  private Long id;

  @NotBlank(message = "O nome deve ser informado")
  @Size(min = 4, message = "O nome deve ter no minimo 4 letras")
  @Column(nullable = false)
  private String nome;

  @Email(message = "Informe um email valido")
  @NotBlank(message = "O email deve ser informado")
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

  private String tipoPessoa;

  @ManyToOne(targetEntity = Pessoa.class)
  @JoinColumn(
      name = "empresa_id",
      foreignKey =
      @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "empresa_fk"))
  private Pessoa empresa;

  public Pessoa() {
  }

  public Pessoa(
      Long id,
      String nome,
      String email,
      String telefone,
      List<Endereco> enderecos,
      String tipoPessoa
  ) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.telefone = telefone;
    this.enderecos = enderecos;
    this.tipoPessoa = tipoPessoa;
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

  public String getTipoPessoa() {
    return tipoPessoa;
  }

  public void setTipoPessoa(String tipoPessoa) {
    this.tipoPessoa = tipoPessoa;
  }

  @Override
  public String toString() {
    return "Pessoa{" +
        "id=" + id +
        ", nome='" + nome + '\'' +
        ", email='" + email + '\'' +
        ", telefone='" + telefone + '\'' +
        ", enderecos=" + enderecos +
        ", tipoPessoa='" + tipoPessoa + '\'' +
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

  public Pessoa getEmpresa() {
    return empresa;
  }

  public void setEmpresa(Pessoa empresa) {
    this.empresa = empresa;
  }
}
