package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "Empresa")
public class Empresa extends Usuario {

    @NotBlank
	@Size(min = 14, max = 14)
	@Column(nullable = false, unique = true, length = 14)
    private String CNPJ;

    @NotBlank
	@Size(min = 32, max = 2048)
	@Column(nullable = false, length = 2048)
    private String descricao;

    @Size(max = 128)
	@Column(nullable = false, length = 128)
    private String cidade;

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
