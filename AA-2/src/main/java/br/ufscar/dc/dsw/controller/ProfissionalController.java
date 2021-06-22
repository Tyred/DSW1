package br.ufscar.dc.dsw.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.core.context.SecurityContextHolder;

import br.ufscar.dc.dsw.domain.Candidatura;
import br.ufscar.dc.dsw.domain.Profissional;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.dao.ICandidaturaDAO;
import br.ufscar.dc.dsw.dao.IVagasDAO;
import br.ufscar.dc.dsw.security.UsuarioDetails;
import br.ufscar.dc.dsw.service.spec.IProfissionalService;

@Controller
@RequestMapping("/profissionais")
public class ProfissionalController {
	
	@Autowired
	private IProfissionalService service;

	@Autowired
	private ICandidaturaDAO candidaturaDAO;

	@Autowired
	private IVagasDAO vagaDAO;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	ServletContext context;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Profissional profissional) {
        profissional.setPapel("ROLE_PRO");
        return "profissional/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("profissionais",service.buscarTodos());
		return "profissional/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Profissional profissional, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
            System.out.println(result);
			return "profissional/cadastro";
		}
        String dia = profissional.getDataNascimento().split("-")[2];
        String mes = profissional.getDataNascimento().split("-")[1];
        String ano = profissional.getDataNascimento().split("-")[0];
        
        String nova_data = dia + '/' + mes + '/' + ano;

        profissional.setDataNascimento(nova_data);
    	
		profissional.setSenha(encoder.encode(profissional.getSenha()));
		service.salvar(profissional);
        attr.addFlashAttribute("success", "Profissional inserido com sucesso.");
		return "redirect:/profissionais/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("profissional", service.buscarPorId(id));
		return "profissional/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Profissional profissional, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            System.out.println(result);
			return "profissional/cadastro";
		}
        String dia = profissional.getDataNascimento().split("-")[2];
        String mes = profissional.getDataNascimento().split("-")[1];
        String ano = profissional.getDataNascimento().split("-")[0];
        
        String nova_data = dia + '/' + mes + '/' + ano;

        profissional.setDataNascimento(nova_data);
		
		service.salvar(profissional);
		attr.addFlashAttribute("success", "Profissional editado com sucesso.");
		return "redirect:/profissionais/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("success", "Profissional excluído com sucesso.");
		return listar(model);
	}

    @GetMapping("/minhasCandidaturas")
	public String minhasVagas(ModelMap model) {
		model.addAttribute("candidaturas", candidaturaDAO.findByProfissional(getProfissional()));
		return "profissional/minhasCandidaturas";
	}

	@GetMapping("/aplicarVaga/{id}")
	public String preAplicar(@PathVariable("id") Long id, ModelMap model) {
		Candidatura candidatura = new Candidatura();
		candidatura.setProfissional(getProfissional());
		candidatura.setVaga(vagaDAO.findById(id.longValue()));
		
		model.addAttribute("candidatura", candidatura);
		return "profissional/aplicarVaga";
	}

	@PostMapping("/aplicarVaga")
	public String aplicar(@RequestParam("curriculo") MultipartFile file, @Valid Candidatura candidatura, BindingResult result, RedirectAttributes attr) throws IOException {
		if (result.hasErrors()) {
            System.out.println(result);
			return "profissional/aplicarVaga";
		}

		String fileName = file.getOriginalFilename();
		
		String uploadPath = context.getRealPath("") + File.separator + "upload";
		File uploadDir = new File(uploadPath);
		
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		file.transferTo(new File(uploadDir, fileName));

		candidatura.setStatus("ABERTO");
		candidatura.setCurriculo("fileName");
		candidaturaDAO.save(candidatura);

		attr.addFlashAttribute("success", "Aplicação realizada com sucesso.");
		return "redirect:/minhasCandidaturas";
	}
	
    private Profissional getProfissional(){
        UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Usuario user = usuarioDetails.getUsuario();
        return service.buscarPorId(user.getId());
    }
}
