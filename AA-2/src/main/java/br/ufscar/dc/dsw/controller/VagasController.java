package br.ufscar.dc.dsw.controller;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Vagas;
import br.ufscar.dc.dsw.domain.Empresa;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.security.UsuarioDetails;
import br.ufscar.dc.dsw.service.spec.IVagasService;
import br.ufscar.dc.dsw.service.spec.IEmpresaService;


@Controller
@RequestMapping("/vagas")
public class VagasController {
    
    @Autowired
	private IVagasService service;

    @Autowired
	private IEmpresaService empresaService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Vagas vagas) {
        vagas.setEmpresa(this.getEmpresa());
        System.out.println(vagas.getEmpresa().getNome());
		return "vagas/cadastro";
	}

    private Empresa getEmpresa(){
        UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Usuario user = usuarioDetails.getUsuario();
        return empresaService.buscarPorId(user.getId());
    }
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("vagas",service.buscarTodasAbertas());
		return "vagas/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Vagas vagas, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            System.out.println(result);
			return "vagas/cadastro";
		}
		String dia = vagas.getDataLimite().split("-")[2];
        String mes = vagas.getDataLimite().split("-")[1];
        String ano = vagas.getDataLimite().split("-")[0];
        
        String nova_data = dia + '/' + mes + '/' + ano;

        vagas.setDataLimite(nova_data);
	
        service.salvar(vagas);
		attr.addFlashAttribute("success", "Vaga inserida com sucesso.");
		return "redirect:/empresas/minhasVagas";
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
        String dia = vagas.getDataLimite().split("-")[2];
        String mes = vagas.getDataLimite().split("-")[1];
        String ano = vagas.getDataLimite().split("-")[0];
        
        String nova_data = dia + '/' + mes + '/' + ano;

        vagas.setDataLimite(nova_data);
		
		service.salvar(vagas);
		attr.addFlashAttribute("success", "Vaga editada com sucesso.");
		return "redirect:/empresas/minhasVagas";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id,  RedirectAttributes attr) {
		service.excluir(id);
		attr.addFlashAttribute("success", "Vaga excluída com sucesso.");
		return "redirect:/empresas/minhasVagas";
	}
    
}
