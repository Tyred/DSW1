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

import org.springframework.web.bind.annotation.RequestParam;
import br.ufscar.dc.dsw.security.UsuarioDetails;
import org.springframework.security.core.context.SecurityContextHolder;

import br.ufscar.dc.dsw.domain.Empresa;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Candidatura;
import br.ufscar.dc.dsw.dao.IVagasDAO;
import br.ufscar.dc.dsw.dao.ICandidaturaDAO;
import br.ufscar.dc.dsw.dao.IEmpresaDAO;
import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.service.spec.IEmpresaService;
import groovyjarjarpicocli.CommandLine.Model;

@Controller
@RequestMapping("/empresas")
public class EmpresaController {
	
	@Autowired
	private IEmpresaService service;

    @Autowired
	private IVagasDAO vagasDAO;

    @Autowired
	private IEmpresaDAO empresaDAO;

    @Autowired
	private IUsuarioDAO usuarioDAO;
	

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
	public String salvar(@Valid Empresa empresa, BindingResult result, RedirectAttributes attr, ModelMap model) {
		
		if (result.hasErrors()) {
			return "empresa/cadastro";
		}
		Usuario user = usuarioDAO.getUserByEmail(empresa.getEmail());
        if (user != null){
            model.addAttribute("error", "error.duplicado");
            model.addAttribute("message", "email.duplicado");
            return "error";
        }
        Empresa empresa2 = empresaDAO.findByCNPJ(empresa.getCNPJ());
        if (empresa2 != null){
            model.addAttribute("error", "error.duplicado");
            model.addAttribute("message", "cnpj.duplicado");
            return "error";
        }
		empresa.setSenha(encoder.encode(empresa.getSenha()));
		service.salvar(empresa);
		attr.addFlashAttribute("success", "Empresa inserida com sucesso.");
		return "redirect:/empresas/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("empresa", service.buscarPorId(id));
		return "empresa/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Empresa empresa, BindingResult result, RedirectAttributes attr, ModelMap model) {
		
		if (result.hasErrors()) {
			return "empresa/cadastro";
		}
        Usuario user = usuarioDAO.getUserByEmail(empresa.getEmail());
        if (user != null && user.getId() != empresa.getId()){
            model.addAttribute("error", "error.duplicado");
            model.addAttribute("message", "email.duplicado");
            return "error";
        }

		System.out.println(empresa.getSenha());
		service.salvar(empresa);
		attr.addFlashAttribute("success", "Empresa editada com sucesso.");
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
    @PostMapping("/status/{id}")
	public String status(@PathVariable("id") Long id, @RequestParam("status") String status, RedirectAttributes attr){
        Candidatura candidatura = candidaturaDAO.findById(id.longValue());
        if (status.equals("Nao")){
            candidatura.setStatus("NÃO SELECIONADO");
        }
        else{
            candidatura.setStatus("ENTREVISTA");
        }
        String id_candidatura = String.valueOf(candidatura.getVaga().getId());
        candidaturaDAO.save(candidatura);

        attr.addFlashAttribute("success", "Candidatura analisada com sucesso.");
        return "redirect:/empresas/vagaCandidaturas/" + id_candidatura;
    }
}
