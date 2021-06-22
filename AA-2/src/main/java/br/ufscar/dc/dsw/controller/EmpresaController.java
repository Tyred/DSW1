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

import br.ufscar.dc.dsw.security.UsuarioDetails;
import org.springframework.security.core.context.SecurityContextHolder;

import br.ufscar.dc.dsw.domain.Empresa;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.dao.IVagasDAO;
import br.ufscar.dc.dsw.dao.ICandidaturaDAO;
import br.ufscar.dc.dsw.service.spec.IEmpresaService;

@Controller
@RequestMapping("/empresas")
public class EmpresaController {
	
	@Autowired
	private IEmpresaService service;

    @Autowired
	private IVagasDAO vagasDAO;
	

    @Autowired
	private ICandidaturaDAO candidaturaDAO;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Empresa empresa) {
        empresa.setPapel("ROLE_EMPRESA");
		return "empresa/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("empresas",service.buscarTodos());
		return "empresa/lista";
	}

    @GetMapping("/minhasVagas")
	public String minhasVagas(ModelMap model) {
		model.addAttribute("vagas", vagasDAO.findByEmpresa(getEmpresa()));
		return "empresa/minhasVagas";
	}
	
    private Empresa getEmpresa(){
        UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Usuario user = usuarioDetails.getUsuario();
        return service.buscarPorId(user.getId());
    }

	@PostMapping("/salvar")
	public String salvar(@Valid Empresa empresa, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "empresa/cadastro";
		}
		
		empresa.setSenha(encoder.encode(empresa.getSenha()));
		service.salvar(empresa);
		attr.addFlashAttribute("success", "Empresa inserido com sucesso.");
		return "redirect:/empresas/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("empresa", service.buscarPorId(id));
		return "empresa/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Empresa empresa, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "empresa/cadastro";
		}

		System.out.println(empresa.getSenha());
		service.salvar(empresa);
		attr.addFlashAttribute("success", "Empresa editado com sucesso.");
		return "redirect:/empresas/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if(service.empresaTemVagas(id)){
            model.addAttribute("fail", "Empresa não excluída. Possui vaga(s) vinculada(s).");
		} else {
			service.excluir(id);
			model.addAttribute("success", "Empresa excluída com sucesso.");
		}
		return listar(model);
	}

    @GetMapping("/vagaCandidaturas/{id}")
	public String vagaCandidaturas(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("candidaturas", candidaturaDAO.findByVaga(vagasDAO.findById(id.longValue())));
		return "empresa/vagaCandidaturas";
	}
}
