package br.ufscar.dc.dsw.domain;

import java.util.List;

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

    @NotBlank(message = "{Blank.profissional.CPF}")
	@Size(min = 14, max = 14, message = "{Size.profissional.CPF}")
	@Column(nullable = false, unique = true, length = 14)
    private String CPF;

    @NotBlank(message = "{Blank.profissional.telefone}")
	@Size(min = 11, max = 16, message = "{Size.profissional.telefone}")
	@Column(nullable = false, length = 15)
    private String telefone;

    @NotBlank(message = "{Blank.profissional.genero}")
	@Size(max = 12, message = "{Size.profissional.genero}")
    @Column(nullable = true, length = 12)
    private String sexo;

    @NotBlank(message = "{Blank.profissional.dataNascimento}")
    @Column(nullable = false, length = 19)
    private String dataNascimento;

    @OneToMany(mappedBy = "profissional")
	private List<Candidatura> candidaturas;

    public List<Candidatura> getCandidaturas(){
		return candidaturas;
	}
	
	public void setCandidaturas(List<Candidatura> candidaturas) {
		this.candidaturas = candidaturas;
	}
    
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
