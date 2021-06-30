package br.ufscar.dc.dsw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.ufscar.dc.dsw.dao.IVagasDAO;
import br.ufscar.dc.dsw.domain.Vagas;
import br.ufscar.dc.dsw.service.spec.IVagasService;

@CrossOrigin
@RestController
public class VagasRESTController {

	@Autowired
	private IVagasService service;

    @Autowired
	private IVagasDAO vagasDAO;

	@GetMapping(path = "/vagas")
	public ResponseEntity<List<Vagas>> lista() {
		List<Vagas> lista = service.buscarTodos();
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping(path = "/vagas/{id}")
	public ResponseEntity<Vagas> lista(@PathVariable("id") long id) {
		Vagas vaga = service.buscarPorId(id);
		if (vaga == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(vaga);
	}

	@GetMapping(path = "/vagas/empresas/{id}")
	public ResponseEntity<List<Vagas>> listaCidade(@PathVariable("id") Long id) {
        List<Vagas> vagas = vagasDAO.getVagasAbertasByEmpresa(id);
		//System.out.println("Size: " + vagas.size());
		if (vagas == null || vagas.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(vagas);
	}
}