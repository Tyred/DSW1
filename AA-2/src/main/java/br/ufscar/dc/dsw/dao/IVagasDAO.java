package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Vagas;

@SuppressWarnings("unchecked")
public interface IVagasDAO extends CrudRepository<Vagas, Long>{

	Vagas findById(long id);

	List<Vagas> findAll();
	
	Vagas save(Vagas vagas);

	void deleteById(Long id);
}