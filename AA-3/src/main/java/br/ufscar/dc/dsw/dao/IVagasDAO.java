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

    @Query("SELECT v FROM Vagas v WHERE v.empresa.id = :id AND FUNCTION('STR_TO_DATE', v.dataLimite, '%d/%m/%Y') >= CURRENT_DATE")
    public List<Vagas> getVagasAbertasByEmpresa(@Param("id") Long id);

    @Query("SELECT v FROM Vagas v WHERE FUNCTION('STR_TO_DATE', v.dataLimite, '%d/%m/%Y') >= CURRENT_DATE")
    public List<Vagas> getVagasAbertas();

    @Query("SELECT v FROM Vagas v WHERE v.empresa.cidade = :cidade AND FUNCTION('STR_TO_DATE', v.dataLimite, '%d/%m/%Y') >= CURRENT_DATE")
    public List<Vagas> getVagasByCidade(@Param("cidade") String cidade);
}