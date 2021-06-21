package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Vagas;

public interface IVagasService {

	Vagas buscarPorId(Long id);

	List<Vagas> buscarTodos();

	void salvar(Vagas vagas);

	void excluir(Long id);	

    List<Vagas> buscarTodasAbertas();
}
