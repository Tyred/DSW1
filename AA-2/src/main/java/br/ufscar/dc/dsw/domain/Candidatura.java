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
@Table(name = "Candidatura")
public class Candidatura extends Usuario {

    @NotBlank
	@Size(min = 14, max = 14)
	@Column(nullable = false, unique = true, length = 5)
    private Long id;

    @NotBlank
	@Size(min = 32, max = 2048)
	@Column(nullable = false, length = 2048)
    private String vaga;

    @Size(max = 128)
	@Column(nullable = false, length = 128)
    private String curriculo;

    @Size(max = 128)
	@Column(nullable = false, length = 128)
    private String status;

    @NotBlank
    @Column(nullable = false, length = 19)
    private Date dataEntrevista;

    @Size(max = 128)
	@Column(nullable = false, length = 128)
    private String linkEntrevista;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getVaga() {
        return vaga;
    }

    public void setVaga(String vaga) {
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
}
