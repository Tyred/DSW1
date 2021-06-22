package br.ufscar.dc.dsw.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.UniqueConstraint;

@SuppressWarnings("serial")
@Entity
@Table(name = "Candidatura", uniqueConstraints = {@UniqueConstraint(columnNames = {"profissional_id", "vaga_id"})}
)

public class Candidatura extends AbstractEntity<Long> {

    @NotNull
	@ManyToOne
	@JoinColumn(name = "profissional_id")
	private Profissional profissional;

    @NotNull
    @ManyToOne
	@JoinColumn(name = "vaga_id")
    private Vagas vaga;

	@NotBlank
    @Column(nullable = false, length = 128)
    private String curriculo;

    @Size(max = 128)
	@Column(nullable = false, length = 128)
    private String status;
    
    public Vagas getVaga() {
        return vaga;
    }

    public void setVaga(Vagas vaga) {
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

    public Profissional getProfissional(){
        return profissional;
    }

    public void setProfissional(Profissional profissional){
        this.profissional = profissional;
    }
    /*
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
    }*/

}