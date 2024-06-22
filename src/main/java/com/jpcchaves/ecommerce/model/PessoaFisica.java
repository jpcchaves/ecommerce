package com.jpcchaves.ecommerce.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "pessoa_fisica")
@PrimaryKeyJoinColumn(
    name = "pessoa_id",
    referencedColumnName = "id",
    foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
public class PessoaFisica extends Pessoa implements Serializable {
  private static final long serialVersionUID = 1988296739060279654L;

  @Column(nullable = false)
  private String cpf;

  @Temporal(TemporalType.DATE)
  private Date dataNascimento;

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Date getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(Date dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  @Override
  public String toString() {
    return "PessoaFisica{" +
        "cpf='" + cpf + '\'' +
        ", dataNascimento=" + dataNascimento +
        '}';
  }
}
