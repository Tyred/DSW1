package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.IVagasDAO;
import br.ufscar.dc.dsw.domain.Vagas;
import br.ufscar.dc.dsw.service.spec.IVagasService;

@Service
@Transactional(readOnly = false)
public class VagasService implements IVagasService {

	@Autowired
	IVagasDAO dao;

	public void salvar(Vagas vagas) {
		dao.save(vagas);
	}

	public void excluir(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Vagas buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Vagas> buscarTodos() {
		return dao.findAll();
	}

    @Transactional(readOnly = true)
	public List<Vagas> buscarTodasAbertas() {
		return dao.getVagasAbertas();
	}

}