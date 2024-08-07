package com.jpcchaves.ecommerce.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "usuario")
@SequenceGenerator(
        name = "seq_usuario",
        sequenceName = "seq_usuario",
        allocationSize = 1)
public class Usuario implements UserDetails, Serializable {
    private static final long serialVersionUID = 763879519639153490L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    private Long id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataAtualSenha;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "usuarios_acesso",
            uniqueConstraints =
            @UniqueConstraint(
                    columnNames = {"usuario_id", "acesso_id"},
                    name = "unique_acesso_user"),
            joinColumns =
            @JoinColumn(
                    name = "usuario_id",
                    referencedColumnName = "id",
                    table = "usuario",
                    foreignKey =
                    @ForeignKey(
                            name = "usuario_fk",
                            value = ConstraintMode.CONSTRAINT)),
            inverseJoinColumns =
            @JoinColumn(
                    name = "acesso_id",
                    referencedColumnName = "id",
                    table = "acesso",
                    foreignKey =
                    @ForeignKey(
                            name = "acesso_fk",
                            value = ConstraintMode.CONSTRAINT)))
    private List<Acesso> acessos = new ArrayList<>();

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(
            name = "pessoa_id",
            nullable = false,
            foreignKey =
            @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
    private Pessoa pessoa;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(
            name = "empresa_id",
            nullable = false,
            foreignKey =
            @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "empresa_fk"))
    private Pessoa empresa;

    public Usuario() {
    }

    public Usuario(
            Long id,
            String login,
            String senha,
            Date dataAtualSenha,
            List<Acesso> acessos,
            Pessoa pessoa, Pessoa empresa) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.dataAtualSenha = dataAtualSenha;
        this.acessos = acessos;
        this.pessoa = pessoa;
        this.empresa = empresa;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.acessos;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataAtualSenha() {
        return dataAtualSenha;
    }

    public void setDataAtualSenha(Date dataAtualSenha) {
        this.dataAtualSenha = dataAtualSenha;
    }

    public List<Acesso> getAcessos() {
        return acessos;
    }

    public void setAcessos(List<Acesso> acessos) {
        this.acessos = acessos;
    }

    @Override
    public String toString() {
        return "Usuario{"
                + "id="
                + id
                + ", login='"
                + login
                + '\''
                + ", senha='"
                + senha
                + '\''
                + ", dataAtualSenha="
                + dataAtualSenha
                + ", acessos="
                + acessos
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
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
