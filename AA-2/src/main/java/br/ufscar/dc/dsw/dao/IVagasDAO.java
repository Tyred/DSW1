package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.ufscar.dc.dsw.domain.Vagas;
import br.ufscar.dc.dsw.domain.Empresa;

@SuppressWarnings("unchecked")
public interface IVagasDAO extends CrudRepository<Vagas, Long>{

	Vagas findById(long id);

	List<Vagas> findAll();

    List<Vagas> findByEmpresa(Empresa empresa);
	
	Vagas save(Vagas vagas);

	void deleteById(Long id);

    @Query("SELECT v FROM Vagas v WHERE v.dataLimite < CURRENT_DATE")
    public List<Vagas> getVagasAbertas();
}