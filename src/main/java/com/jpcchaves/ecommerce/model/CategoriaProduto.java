package com.jpcchaves.ecommerce.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "categoria_produto")
@SequenceGenerator(name = "seq_categoria_produto", sequenceName = "seq_categoria_produto", allocationSize = 1)
public class CategoriaProduto implements Serializable {
  private static final long serialVersionUID = 289435744051868325L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_categoria_produto")
  private Long id;

  @Column(name = "nome_desc", nullable = false)
  private String nomeDesc;

  public CategoriaProduto() {
  }

  public CategoriaProduto(Long id,
                          String nomeDesc) {
    this.id = id;
    this.nomeDesc = nomeDesc;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNomeDesc() {
    return nomeDesc;
  }

  public void setNomeDesc(String nomeDesc) {
    this.nomeDesc = nomeDesc;
  }

  @Override
  public String toString() {
    return "CategoriaProduto{" +
        "id=" + id +
        ", nomeDesc='" + nomeDesc + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CategoriaProduto that = (CategoriaProduto) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
