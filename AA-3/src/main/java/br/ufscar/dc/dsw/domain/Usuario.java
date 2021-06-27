package br.ufscar.dc.dsw.domain;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@JsonIgnoreProperties(value = {"senha"})
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Usuario")
public class Usuario extends AbstractEntity<Long> {
    @NotBlank(message = "{Blank.usuario.email}")
    @Size(min=6, max = 64, message = "{Size.usuario.email}")
    @Column(nullable = false, length = 20, unique = true)
    private String email;
       
    @NotBlank(message = "{Blank.usuario.nome}")
    @Column(nullable = false, length = 60)
    private String nome;

    @NotBlank(message = "{Blank.usuario.senha}")
    @Size(min=5, max = 64, message = "{Size.usuario.senha}")
    @Column(nullable = false, length = 64)
    private String senha;

    @NotBlank
    @Column(nullable = false, length = 20)
    private String papel;
    
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean enabled;

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

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public boolean getEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}