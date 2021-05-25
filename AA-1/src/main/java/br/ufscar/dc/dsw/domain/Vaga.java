package br.ufscar.dc.dsw.domain;

import java.sql.Date;

public class Vaga {
    private Long id;
    private Empresa empresa;
    private String descricao;
    private Double remuneracao;
    private Date dataLimite;

    public Vaga(Long id) {
        this.id = id;
    }

    public Vaga(Empresa empresa, String descricao, Double remuneracao, Date dataLimite) {
        this.empresa = empresa;
        this.descricao = descricao;
        this.remuneracao = remuneracao;
        this.dataLimite = dataLimite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getRemuneracao() {
        return remuneracao;
    }

    public void setRemuneracao(Double remuneracao) {
        this.remuneracao = remuneracao;
    }

    public Date getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(Date dataLimite) {
        this.dataLimite = dataLimite;
    }

}
