package br.ufscar.dc.dsw.domain;

import java.sql.Date;

public class Candidatura {
    private Long id;
    private Profissional profissional;
    private Vaga vaga;
    private String curriculo;
    private String status;
    private Date dataEntrevista;
    private String linkEntrevista;

    public Candidatura(Long id) {
        this.id = id;
    }

    public Candidatura(Profissional profissional, Vaga vaga, String curriculo, String status, Date dataEntrevista,
            String linkEntrevista) {
        this.profissional = profissional;
        this.vaga = vaga;
        this.curriculo = curriculo;
        this.status = status;
        this.dataEntrevista = dataEntrevista;
        this.linkEntrevista = linkEntrevista;
    }

    public Candidatura(Long id, Profissional profissional, Vaga vaga, String curriculo, String status,
            Date dataEntrevista, String linkEntrevista) {
        this.id = id;
        this.profissional = profissional;
        this.vaga = vaga;
        this.curriculo = curriculo;
        this.status = status;
        this.dataEntrevista = dataEntrevista;
        this.linkEntrevista = linkEntrevista;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public String getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataEntrevista() {
        return dataEntrevista;
    }

    public void setDataEntrevista(Date dataEntrevista) {
        this.dataEntrevista = dataEntrevista;
    }

    public String getLinkEntrevista() {
        return linkEntrevista;
    }

    public void setLinkEntrevista(String linkEntrevista) {
        this.linkEntrevista = linkEntrevista;
    }

}
