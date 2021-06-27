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

import br.ufscar.dc.dsw.dao.IEmpresaDAO;
import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.domain.Empresa;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.service.spec.IEmpresaService;

@CrossOrigin
@RestController
public class EmpresaRESTController {

	@Autowired
	private IEmpresaService service;

	@Autowired
	private IEmpresaDAO empresaDAO;

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

	private void parse(Empresa empresa, JSONObject json) {

		Object id = json.get("id");
		if (id != null) {
			if (id instanceof Integer) {
				empresa.setId(((Integer) id).longValue());
			} else {
				empresa.setId((Long) id);
			}
		}

		empresa.setNome((String) json.get("nome"));
		empresa.setEmail((String) json.get("email"));
		empresa.setSenha((String) json.get("senha"));
		empresa.setCNPJ((String) json.get("cnpj"));
		empresa.setDescricao((String) json.get("descricao"));
		empresa.setCidade((String) json.get("cidade"));
		empresa.setPapel((String) json.get("papel"));
		empresa.setEnabled((boolean) json.get("enabled"));
	}

	@GetMapping(path = "/empresas")
	public ResponseEntity<List<Empresa>> lista() {
		List<Empresa> lista = service.buscarTodos();
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping(path = "/empresas/{id}")
	public ResponseEntity<Empresa> lista(@PathVariable("id") long id) {
		Empresa empresa = service.buscarPorId(id);
		if (empresa == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(empresa);
	}

	@PostMapping(path = "/empresas")
	@ResponseBody
	public ResponseEntity<Empresa> cria(@RequestBody JSONObject json) {
		try {
			if (isJSONValid(json.toString())) {
				Empresa empresa = new Empresa();
				parse(empresa, json);

				Usuario user = usuarioDAO.getUserByEmail(empresa.getEmail());
				if (user != null) {
					System.out.println("\nErro em POST /empresas: email já cadastrado!");
					return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
				}

				Empresa empresa2 = empresaDAO.findByCNPJ(empresa.getCNPJ());
				if (empresa2 != null) {
					System.out.println("\nErro em POST /empresas: CNPJ já cadastrado!");
					return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
				}

				empresa.setSenha(encoder.encode(empresa.getSenha()));
				service.salvar(empresa);
				return ResponseEntity.ok(empresa);
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
	}

	@PutMapping(path = "/empresas/{id}")
	public ResponseEntity<Empresa> atualiza(@PathVariable("id") long id, @RequestBody JSONObject json) {
		try {
			if (isJSONValid(json.toString())) {
				Empresa empresa = service.buscarPorId(id);
				if (empresa == null) {
					return ResponseEntity.notFound().build();
				} else {
					parse(empresa, json);

					Usuario user = usuarioDAO.getUserByEmail(empresa.getEmail());
					if (user != null && user.getId() != empresa.getId()) {
						System.out.println("\nErro em PUT /empresas: email já cadastrado!");
						return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
					}

					Empresa empresa2 = empresaDAO.findByCNPJ(empresa.getCNPJ());
					if (empresa2 != null && empresa2.getId() != empresa.getId()) {
						System.out.println("\nErro em PUT /empresas: CNPJ já cadastrado!");
						return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
					}

					empresa.setSenha(encoder.encode(empresa.getSenha()));
					service.salvar(empresa);
					return ResponseEntity.ok(empresa);
				}
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
	}

	@DeleteMapping(path = "/empresas/{id}")
	public ResponseEntity<Boolean> remove(@PathVariable("id") long id) {

		Empresa empresa = service.buscarPorId(id);
		if (empresa == null) {
			return ResponseEntity.notFound().build();
		} else {
			service.excluir(id);
			return ResponseEntity.noContent().build();
		}
	}
}
