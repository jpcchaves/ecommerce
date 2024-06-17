package com.jpcchaves.ecommerce.model;

import java.io.*;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "status_rastreio")
@SequenceGenerator(
    name = "seq_status_rastreio",
    sequenceName = "seq_status_rastreio",
    allocationSize = 1)
public class StatusRastreio implements Serializable {
  private static final long serialVersionUID = -7419843109540147427L;

  @Id
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "seq_status_rastreio")
  private Long id;

  private String centroDistribuicao;
  private String cidade;
  private String estado;
  private String status;

  // Todo: add relation with Vd_Cp_Loja_Virtual

  public StatusRastreio() {}

  public StatusRastreio(
      Long id,
      String centroDistribuicao,
      String cidade,
      String estado,
      String status) {
    this.id = id;
    this.centroDistribuicao = centroDistribuicao;
    this.cidade = cidade;
    this.estado = estado;
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCentroDistribuicao() {
    return centroDistribuicao;
  }

  public void setCentroDistribuicao(String centroDistribuicao) {
    this.centroDistribuicao = centroDistribuicao;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "StatusRastreio{"
        + "id="
        + id
        + ", centroDistribuicao='"
        + centroDistribuicao
        + '\''
        + ", cidade='"
        + cidade
        + '\''
        + ", estado='"
        + estado
        + '\''
        + ", status='"
        + status
        + '\''
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    StatusRastreio that = (StatusRastreio) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
