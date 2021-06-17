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

import br.ufscar.dc.dsw.domain.Vagas;
import br.ufscar.dc.dsw.service.spec.IVagasService;


@Controller
@RequestMapping("/vagas")
public class VagasController {

    
    @Autowired
	private IVagasService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Vagas vagas) {
		return "vagas/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("vagas",service.buscarTodos());
		return "vagas/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Vagas vagas, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "vagas/cadastro";
		}
		
		vagas.setSenha(encoder.encode(vagas.getSenha()));
		service.salvar(vagas);
		attr.addFlashAttribute("success", "Vaga inserida com sucesso.");
		return "redirect:/vagas/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("vagas", service.buscarPorId(id));
		return "vagas/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Vagas vagas, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "vagas/cadastro";
		}

		System.out.println(vagas.getSenha());
		
		service.salvar(vagas);
		attr.addFlashAttribute("success", "Vagas editada com sucesso.");
		return "redirect:/vagas/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("success", "Vagas excluída com sucesso.");
		return listar(model);
	}
    
}
