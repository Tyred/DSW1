package br.ufscar.dc.dsw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Candidatura;
import br.ufscar.dc.dsw.service.spec.ICandidaturaService;

@Controller
@RequestMapping("/candidaturas")
public class CandidaturaController {
	
	@Autowired
	private ICandidaturaService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Candidatura candidatura) {
		return "candidatura/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("candidaturas",service.buscarTodos());
		return "candidatura/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Candidatura candidatura, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "candidatura/cadastro";
		}
		
		candidatura.setSenha(encoder.encode(candidatura.getSenha()));
		service.salvar(candidatura);
		attr.addFlashAttribute("success", "Candidatura inserido com sucesso.");
		return "redirect:/candidaturas/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("candidatura", service.buscarPorId(id));
		return "candidatura/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Candidatura candidatura, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "candidatura/cadastro";
		}

		System.out.println(candidatura.getSenha());
		
		service.salvar(candidatura);
		attr.addFlashAttribute("success", "Candidatura editado com sucesso.");
		return "redirect:/candidaturas/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("success", "Candidatura excluído com sucesso.");
		return listar(model);
	}
}
