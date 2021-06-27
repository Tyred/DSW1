package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.ufscar.dc.dsw.dao.IProfissionalDAO;
import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.domain.Profissional;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.service.spec.IProfissionalService;

@CrossOrigin
@RestController
public class ProfissionalRESTController {

	@Autowired
	private IProfissionalService service;

	@Autowired
	private IProfissionalDAO profissionalDAO;

	@Autowired
	private IUsuarioDAO usuarioDAO;

	@Autowired
	private BCryptPasswordEncoder encoder;

	private boolean isJSONValid(String jsonInString) {
		try {
			return new ObjectMapper().readTree(jsonInString) != null;
		} catch (IOException e) {
			return false;
		}
	}

	private void parse(Profissional profissional, JSONObject json) {

		Object id = json.get("id");
		if (id != null) {
			if (id instanceof Integer) {
				profissional.setId(((Integer) id).longValue());
			} else {
				profissional.setId((Long) id);
			}
		}

		profissional.setNome((String) json.get("nome"));
		profissional.setEmail((String) json.get("email"));
		profissional.setSenha((String) json.get("senha"));
		profissional.setCPF((String) json.get("cpf"));
		profissional.setDataNascimento((String) json.get("dataNascimento"));
		profissional.setTelefone((String) json.get("telefone"));
		profissional.setSexo((String) json.get("sexo"));
		profissional.setPapel((String) json.get("papel"));
		profissional.setEnabled((boolean) json.get("enabled"));
	}

	@GetMapping(path = "/profissionais")
	public ResponseEntity<List<Profissional>> lista() {
		List<Profissional> lista = service.buscarTodos();
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping(path = "/profissionais/{id}")
	public ResponseEntity<Profissional> lista(@PathVariable("id") long id) {
		Profissional profissional = service.buscarPorId(id);
		if (profissional == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(profissional);
	}

	@PostMapping(path = "/profissionais")
	@ResponseBody
	public ResponseEntity<Profissional> cria(@RequestBody JSONObject json) {
		try {
			if (isJSONValid(json.toString())) {
				Profissional profissional = new Profissional();
				parse(profissional, json);

				Usuario user = usuarioDAO.getUserByEmail(profissional.getEmail());
				if (user != null) {
					System.out.println("\nErro em POST /profissionais: email já cadastrado!");
					return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
				}

				Profissional profissional2 = profissionalDAO.findByCPF(profissional.getCPF());
				if (profissional2 != null) {
					System.out.println("\nErro em POST /profissionais: CPF já cadastrado!!");
					return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
				}

				profissional.setSenha(encoder.encode(profissional.getSenha()));
				service.salvar(profissional);
				return ResponseEntity.ok(profissional);
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
	}

	@PutMapping(path = "/profissionais/{id}")
	public ResponseEntity<Profissional> atualiza(@PathVariable("id") long id, @RequestBody JSONObject json) {
		try {
			if (isJSONValid(json.toString())) {
				Profissional profissional = service.buscarPorId(id);
				if (profissional == null) {
					return ResponseEntity.notFound().build();
				} else {
					parse(profissional, json);

					Usuario user = usuarioDAO.getUserByEmail(profissional.getEmail());
					if (user != null && user.getId() != profissional.getId()) {
						System.out.println("\nErro em PUT /profissionais: email já cadastrado!");
						return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
					}

					Profissional profissional2 = profissionalDAO.findByCPF(profissional.getCPF());
					if (profissional2 != null && profissional2.getId() != profissional.getId()) {
						System.out.println("\nErro em PUT /profissionais: CPF já cadastrado!!");
						return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
					}

					profissional.setSenha(encoder.encode(profissional.getSenha()));
					service.salvar(profissional);
					return ResponseEntity.ok(profissional);
				}
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
	}

	@DeleteMapping(path = "/profissionais/{id}")
	public ResponseEntity<Boolean> remove(@PathVariable("id") long id) {

		Profissional profissional = service.buscarPorId(id);
		if (profissional == null) {
			return ResponseEntity.notFound().build();
		} else {
			service.excluir(id);
			return ResponseEntity.noContent().build();
		}
	}
}
