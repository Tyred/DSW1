package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Candidatura;
import br.ufscar.dc.dsw.domain.Profissional;


@SuppressWarnings("unchecked")
public interface ICandidaturaDAO extends CrudRepository<Candidatura, Long>{

	Candidatura findById(long id);

	List<Candidatura> findAll();

    List<Candidatura> findByProfissional(Profissional profissional);
	
	Candidatura save(Candidatura candidatura);

	void deleteById(Long id);
}