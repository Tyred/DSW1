package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
@Table(name = "usuario")
public class Usuario extends AbstractEntity<Long> {

    @NotBlank
    @Column(nullable = false, length = 20, unique = true)
    private String email;
       
    @NotBlank
    @Column(nullable = false, length = 60)
    private String nome;

    @NotBlank
    @Column(nullable = false, length = 64)
    private String senha;

    @NotBlank
    @Column(nullable = false)
    private Boolean isAdmin;
    
    @Column(nullable = false)
    private Boolean enabled;

    public Usuario() {
    }

    public Usuario(String email, String nome, String senha, Boolean isAdmin) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.isAdmin = isAdmin;
    }

    public Usuario(Long id, String email, String nome, String senha, Boolean isAdmin) {
        this.setId(id);
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.isAdmin = isAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}