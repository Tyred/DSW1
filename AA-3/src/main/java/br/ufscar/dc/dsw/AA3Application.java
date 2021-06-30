package br.ufscar.dc.dsw;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.ICandidaturaDAO;
import br.ufscar.dc.dsw.dao.IEmpresaDAO;
import br.ufscar.dc.dsw.dao.IProfissionalDAO;
import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.dao.IVagasDAO;
import br.ufscar.dc.dsw.domain.Profissional;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Empresa;
import br.ufscar.dc.dsw.domain.Vagas;
import br.ufscar.dc.dsw.domain.Candidatura;

@SpringBootApplication
public class AA3Application {

	public static void main(String[] args) {
		SpringApplication.run(AA3Application.class, args);
	}
    
    @Bean
    public CommandLineRunner demo(IUsuarioDAO usuarioDAO, BCryptPasswordEncoder encoder, IProfissionalDAO profissionalDAO,
        IEmpresaDAO empresaDAO, IVagasDAO vagasDAO, ICandidaturaDAO candidaturaDAO) {
		return (args) -> {
			// admin
			Usuario u1 = new Usuario();
			u1.setEmail("admin@gmail.com");
			u1.setSenha(encoder.encode("admin"));
			u1.setNome("Administrador");
			u1.setPapel("ROLE_ADMIN");
			u1.setEnabled(true);
			usuarioDAO.save(u1);

            // Empresas
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

            // Profissionais
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

            Profissional p2 = new Profissional();
            p2.setEmail("profissional2@gmail.com");
			p2.setSenha(encoder.encode("admin"));
			p2.setNome("Profissional 2");
			p2.setPapel("ROLE_PRO");
			p2.setEnabled(true);
            p2.setCPF("222.222.222-22");
            p2.setTelefone("55(16)99222-2222");
            p2.setSexo("Masculino");
            p2.setDataNascimento("15/12/2000");
            profissionalDAO.save(p2);

            // Vagas
            Vagas v1 = new Vagas();
            v1.setDescricao("Programador Web");
            v1.setRemuneracao(BigDecimal.valueOf(3500));
            v1.setDataLimite("20/07/2021");
            v1.setEmpresa(e1);
            vagasDAO.save(v1);
            
            Vagas v2 = new Vagas();
            v2.setDescricao("Estagiário em Web Dev");
            v2.setRemuneracao(BigDecimal.valueOf(1500));
            v2.setDataLimite("15/07/2021");
            v2.setEmpresa(e2);
            vagasDAO.save(v2);

            Vagas v3 = new Vagas();
            v3.setDescricao("Vaga fechada");
            v3.setRemuneracao(BigDecimal.valueOf(1500));
            v3.setDataLimite("15/06/2021");
            v3.setEmpresa(e1);
            vagasDAO.save(v3);

            Vagas v4 = new Vagas();
            v4.setDescricao("Vaga Aberta");
            v4.setRemuneracao(BigDecimal.valueOf(4200));
            v4.setDataLimite("23/07/2021");
            v4.setEmpresa(e1);
            vagasDAO.save(v4);

            // Candidaturas
            Candidatura c1 = new Candidatura();
            c1.setCurriculo("Curriculo.pdf");
        };
    }
}
