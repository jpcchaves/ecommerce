package com.jpcchaves.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cup_desc")
@SequenceGenerator(
        name = "seq_cup_desc",
        sequenceName = "seq_cup_desc",
        allocationSize = 1)
public class CupDesc implements Serializable {
    private static final long serialVersionUID = -5188393956743092634L;

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_cup_desc")
    private Long id;

    @Column(nullable = false)
    private String codDesc;

    private BigDecimal valorRealDesc;
    private BigDecimal valorPorcentDesc;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataValidadeCupom;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(
            name = "empresa_id",
            nullable = false,
            foreignKey =
            @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "empresa_fk"))
    private Pessoa empresa;

    public CupDesc() {
    }

    public CupDesc(
            Long id,
            String codDesc,
            BigDecimal valorRealDesc,
            BigDecimal valorPorcentDesc,
            Date dataValidadeCupom) {
        this.id = id;
        this.codDesc = codDesc;
        this.valorRealDesc = valorRealDesc;
        this.valorPorcentDesc = valorPorcentDesc;
        this.dataValidadeCupom = dataValidadeCupom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodDesc() {
        return codDesc;
    }

    public void setCodDesc(String codDesc) {
        this.codDesc = codDesc;
    }

    public BigDecimal getValorRealDesc() {
        return valorRealDesc;
    }

    public void setValorRealDesc(BigDecimal valorRealDesc) {
        this.valorRealDesc = valorRealDesc;
    }

    public BigDecimal getValorPorcentDesc() {
        return valorPorcentDesc;
    }

    public void setValorPorcentDesc(BigDecimal valorPorcentDesc) {
        this.valorPorcentDesc = valorPorcentDesc;
    }

    public Date getDataValidadeCupom() {
        return dataValidadeCupom;
    }

    public void setDataValidadeCupom(Date dataValidadeCupom) {
        this.dataValidadeCupom = dataValidadeCupom;
    }

    @Override
    public String toString() {
        return "CupDesc{"
                + "id="
                + id
                + ", codDesc='"
                + codDesc
                + '\''
                + ", valorRealDesc="
                + valorRealDesc
                + ", valorPorcentDesc="
                + valorPorcentDesc
                + ", dataValidadeCupom="
                + dataValidadeCupom
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CupDesc cupDesc = (CupDesc) o;
        return Objects.equals(id, cupDesc.id);
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
