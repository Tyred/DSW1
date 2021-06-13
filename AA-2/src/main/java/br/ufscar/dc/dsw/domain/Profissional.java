package br.ufscar.dc.dsw.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "Profissional")
public class Profissional extends Usuario {

    @NotBlank
	@Size(min = 14, max = 14)
	@Column(nullable = false, unique = true, length = 14)
    private String CPF;

    @NotBlank
	@Size(min = 11, max = 15)
	@Column(nullable = false, unique = true, length = 15)
    private String telefone;

    @Size(min = 1, max = 15)
	@Column(nullable = false, unique = true, length = 15)
    private String sexo;

    @NotBlank
    @Column(nullable = false, length = 19)
    private Date dataNascimento;

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
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
    /*
    public Profissional() {
    }

    public Profissional(Usuario usuario, String CPF, String telefone, String sexo, Date dataNascimento) {
        this.usuario = usuario;
        this.CPF = CPF;
        this.telefone = telefone;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }

    public Profissional(Long id, Usuario usuario, String CPF, String telefone, String sexo, Date dataNascimento) {
        this.setId(id);
        this.usuario = usuario;
        this.CPF = CPF;
        this.telefone = telefone;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }*/
}
