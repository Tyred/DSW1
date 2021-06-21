package br.ufscar.dc.dsw;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.IEmpresaDAO;
import br.ufscar.dc.dsw.dao.IProfissionalDAO;
import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.dao.IVagasDAO;
import br.ufscar.dc.dsw.domain.Profissional;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Empresa;
import br.ufscar.dc.dsw.domain.Vagas;

@SpringBootApplication
public class AA2Application {

	public static void main(String[] args) {
		SpringApplication.run(AA2Application.class, args);
	}
    
    @Bean
    public CommandLineRunner demo(IUsuarioDAO usuarioDAO, BCryptPasswordEncoder encoder, IProfissionalDAO profissionalDAO,
        IEmpresaDAO empresaDAO, IVagasDAO vagasDAO) {
		return (args) -> {
			
			Usuario u1 = new Usuario();
			u1.setEmail("admin@gmail.com");
			u1.setSenha(encoder.encode("admin"));
			u1.setNome("Administrador");
			u1.setPapel("ROLE_ADMIN");
			u1.setEnabled(true);
			usuarioDAO.save(u1);

            Empresa e1 = new Empresa();
			e1.setEmail("empresa@gmail.com");
			e1.setSenha(encoder.encode("admin"));
			e1.setNome("Empresa");
			e1.setPapel("ROLE_EMPRESA");
			e1.setEnabled(true);
            e1.setCNPJ("11.111.111/1111-11");
            e1.setDescricao("Empresa teste");
            e1.setCidade("São Carlos");
			empresaDAO.save(e1);

            Empresa e2 = new Empresa();
			e2.setEmail("empresa2@gmail.com");
			e2.setSenha(encoder.encode("admin"));
			e2.setNome("Empresa 2");
			e2.setPapel("ROLE_EMPRESA");
			e2.setEnabled(true);
            e2.setCNPJ("22.222.222/2222-22");
            e2.setDescricao("Segunda Empresa");
            e2.setCidade("São Paulo");
			empresaDAO.save(e2);

            Profissional p1 = new Profissional();
            p1.setEmail("profissional@gmail.com");
			p1.setSenha(encoder.encode("admin"));
			p1.setNome("Profissional");
			p1.setPapel("ROLE_PRO");
			p1.setEnabled(true);
            p1.setCPF("111.111.111-11");
            p1.setTelefone("55(16)99111-1111");
            p1.setSexo("Feminino");
            p1.setDataNascimento("01/02/2000");
            profissionalDAO.save(p1);

            Vagas v1 = new Vagas();
            v1.setDescricao("Programador Web");
            v1.setRemuneracao(BigDecimal.valueOf(3500));
            v1.setDataLimite("29/06/2021");
            v1.setEmpresa(e1);
            vagasDAO.save(v1);
            
            Vagas v2 = new Vagas();
            v2.setDescricao("Estagiário em Web Dev");
            v2.setRemuneracao(BigDecimal.valueOf(1500));
            v2.setDataLimite("15/07/2021");
            v2.setEmpresa(e2);
            vagasDAO.save(v2);
        };
    }
}

	/*@Bean
	public CommandLineRunner demo(IUsuarioDAO usuarioDAO, BCryptPasswordEncoder encoder, IEditoraDAO editoraDAO, IProfissionalDAO profissionalDAO) {
		return (args) -> {
			
			Usuario u1 = new Usuario();
			u1.setUsername("admin");
			u1.setPassword(encoder.encode("admin"));
			u1.setCPF("012.345.678-90");
			u1.setName("Administrador");
			u1.setRole("ROLE_ADMIN");
			u1.setEnabled(true);
			usuarioDAO.save(u1);
			
			Usuario u2 = new Usuario();
			u2.setUsername("beltrano");
			u2.setPassword(encoder.encode("123"));
			u2.setCPF("985.849.614-10");
			u2.setName("Beltrano Andrade");
			u2.setRole("ROLE_USER");
			u2.setEnabled(true);
			usuarioDAO.save(u2);
			
			Usuario u3 = new Usuario();
			u3.setUsername("fulano");
			u3.setPassword(encoder.encode("123"));
			u3.setCPF("367.318.380-04");
			u3.setName("Fulano Silva");
			u3.setRole("ROLE_USER");
			u3.setEnabled(true);
			usuarioDAO.save(u3);
			
			Editora e1 = new Editora();
			e1.setCNPJ("55.789.390/0008-99");
			e1.setNome("Companhia das Letras");
			editoraDAO.save(e1);
			
			Editora e2 = new Editora();
			e2.setCNPJ("71.150.470/0001-40");
			e2.setNome("Record");
			editoraDAO.save(e2);
			
			Editora e3 = new Editora();
			e3.setCNPJ("32.106.536/0001-82");
			e3.setNome("Objetiva");
			editoraDAO.save(e3);
			
			Profissional l1 = new Profissional();
			l1.setTitulo("Ensaio sobre a Cegueira");
			l1.setAutor("José Saramago");
			l1.setAno(1995);
			l1.setPreco(BigDecimal.valueOf(54.9));
			l1.setEditora(e1);
			profissionalDAO.save(l1);
			
			Profissional l2 = new Profissional();
			l2.setTitulo("Cem anos de Solidão");
			l2.setAutor("Gabriel Garcia Márquez");
			l2.setAno(1977);
			l2.setPreco(BigDecimal.valueOf(59.9));
			l2.setEditora(e2);
			profissionalDAO.save(l2);
			
			Profissional l3 = new Profissional();
			l3.setTitulo("Diálogos Impossíveis");
			l3.setAutor("Luis Fernando Verissimo");
			l3.setAno(2012);
			l3.setPreco(BigDecimal.valueOf(22.9));
			l3.setEditora(e3);
			profissionalDAO.save(l3);
		};
	} */
