package com.jpcchaves.ecommerce.model;

import com.jpcchaves.ecommerce.enums.StatusContaPagar;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "conta_pagar")
@SequenceGenerator(
        name = "seq_conta_pagar",
        sequenceName = "seq_conta_pagar",
        allocationSize = 1)
public class ContaPagar implements Serializable {
    private static final long serialVersionUID = -4014739241814589240L;

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_conta_pagar")
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusContaPagar status;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dtVencimento;

    @Temporal(TemporalType.DATE)
    private Date dtPagamento;

    @Column(nullable = false)
    private BigDecimal valorTotal;

    private BigDecimal valorDesconto;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(
            name = "pessoa_id",
            nullable = false,
            foreignKey =
            @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
    private Pessoa pessoa;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(
            name = "pessoa_forn_id",
            nullable = false,
            foreignKey =
            @ForeignKey(
                    value = ConstraintMode.CONSTRAINT,
                    name = "pessoa_forn_fk"))
    private Pessoa pessoa_fornecedor;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(
            name = "empresa_id",
            nullable = false,
            foreignKey =
            @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "empresa_fk"))
    private Pessoa empresa;

    public ContaPagar() {
    }

    public ContaPagar(
            Long id,
            String descricao,
            StatusContaPagar status,
            Date dtVencimento,
            Date dtPagamento,
            BigDecimal valorTotal,
            BigDecimal valorDesconto,
            Pessoa pessoa,
            Pessoa pessoaFornecedor) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
        this.dtVencimento = dtVencimento;
        this.dtPagamento = dtPagamento;
        this.valorTotal = valorTotal;
        this.valorDesconto = valorDesconto;
        this.pessoa = pessoa;
        pessoa_fornecedor = pessoaFornecedor;
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

    public StatusContaPagar getStatus() {
        return status;
    }

    public void setStatus(StatusContaPagar status) {
        this.status = status;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public Date getDtPagamento() {
        return dtPagamento;
    }

    public void setDtPagamento(Date dtPagamento) {
        this.dtPagamento = dtPagamento;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pessoa getPessoa_fornecedor() {
        return pessoa_fornecedor;
    }

    public void setPessoa_fornecedor(Pessoa pessoa_fornecedor) {
        this.pessoa_fornecedor = pessoa_fornecedor;
    }

    @Override
    public String toString() {
        return "ContaPagar{"
                + "id="
                + id
                + ", descricao='"
                + descricao
                + '\''
                + ", status="
                + status
                + ", dtVencimento="
                + dtVencimento
                + ", dtPagamento="
                + dtPagamento
                + ", valorTotal="
                + valorTotal
                + ", valorDesconto="
                + valorDesconto
                + ", pessoa="
                + pessoa
                + ", pessoa_fornecedor="
                + pessoa_fornecedor
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaPagar that = (ContaPagar) o;
        return Objects.equals(id, that.id);
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
