package com.jpcchaves.ecommerce.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "imagem_produto")
@SequenceGenerator(
    name = "seq_imagem_produto",
    sequenceName = "seq_imagem_produto",
    allocationSize = 1)
public class ImagemProduto implements Serializable {
  private static final long serialVersionUID = -8511007436080387935L;

  @Id
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "seq_imagem_produto")
  private Long id;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String imagemOriginal;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String imagemMiniatura;

  @ManyToOne
  @JoinColumn(
      name = "produto_id",
      nullable = false,
      foreignKey =
          @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "produto_fk"))
  private Produto produto;

  public ImagemProduto() {}

  public ImagemProduto(
      Long id, String imagemOriginal, String imagemMiniatura, Produto produto) {
    this.id = id;
    this.imagemOriginal = imagemOriginal;
    this.imagemMiniatura = imagemMiniatura;
    this.produto = produto;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getImagemOriginal() {
    return imagemOriginal;
  }

  public void setImagemOriginal(String imagemOriginal) {
    this.imagemOriginal = imagemOriginal;
  }

  public String getImagemMiniatura() {
    return imagemMiniatura;
  }

  public void setImagemMiniatura(String imagemMiniatura) {
    this.imagemMiniatura = imagemMiniatura;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  @Override
  public String toString() {
    return "ImagemProduto{"
        + "id="
        + id
        + ", imagemOriginal='"
        + imagemOriginal
        + '\''
        + ", imagemMiniatura='"
        + imagemMiniatura
        + '\''
        + ", produto="
        + produto
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ImagemProduto that = (ImagemProduto) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
