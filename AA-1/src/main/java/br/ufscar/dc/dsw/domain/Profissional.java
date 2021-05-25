package br.ufscar.dc.dsw.domain;

import java.sql.Date;

public class Profissional {
    private Long id;
    private Usuario usuario;
    private String CPF;
    private String telefone;
    private String sexo;
    private Date dataNascimento;

    public Profissional(Long id) {
        this.id = id;
    }

    public Profissional(Usuario usuario, String CPF, String telefone, String sexo, Date dataNascimento) {
        this.usuario = usuario;
        this.CPF = CPF;
        this.telefone = telefone;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
