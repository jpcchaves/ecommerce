package com.jpcchaves.ecommerce.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "acesso")
@SequenceGenerator(name = "seq_acesso", sequenceName = "seq_acesso", allocationSize = 1)
public class Acesso implements GrantedAuthority,
    Serializable {
  private static final long serialVersionUID = -4945944803742785290L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_acesso")
  private Long id;

  /* Acesso, ex: ROLE_ADMIN, ROLE_USER, etc */
  @Column(nullable = false)
  private String descricao;

  @Override
  public String getAuthority() {
    return this.descricao;
  }

  public Acesso() {
  }

  public Acesso(Long id,
                String descricao) {
    this.id = id;
    this.descricao = descricao;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Acesso acesso = (Acesso) o;
    return Objects.equals(id, acesso.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "Acesso{" +
        "id=" + id +
        ", descricao='" + descricao + '\'' +
        '}';
  }
}
