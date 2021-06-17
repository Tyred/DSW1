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
@Table(name = "Vagas")
public class Vagas extends Empresa {
    @NotBlank
	@Size(min = 32, max = 2048)
	@Column(nullable = false, length = 2048)
    private String descricao;

    @NotBlank
	@Size(min = 14, max = 14)
	@Column(nullable = false, unique = true, length = 14)
    private Double remuneracao;
  
    @NotBlank
    @Column(nullable = false, length = 19)
    private Date dataLimite;

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
