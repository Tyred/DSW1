package br.ufscar.dc.dsw.controller;

import java.util.List;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.dao.EmpresaDAO;
import br.ufscar.dc.dsw.dao.ProfissionalDAO;
import br.ufscar.dc.dsw.dao.VagaDAO;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Empresa;
import br.ufscar.dc.dsw.domain.Profissional;
import br.ufscar.dc.dsw.domain.Vaga;
import br.ufscar.dc.dsw.util.Erro;
import br.ufscar.dc.dsw.controller.CandidaturaController;

@WebServlet(name = "Index", urlPatterns = { "/index.jsp", "/logout.jsp" })
public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Erro erros = new Erro();
		if (request.getParameter("bOK") != null) {
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			if (login == null || login.isEmpty()) {
				erros.add("Login não informado!");
			}
			if (senha == null || senha.isEmpty()) {
				erros.add("Senha não informada!");
			}
			if (!erros.isExisteErros()) {
				UsuarioDAO dao = new UsuarioDAO();
                EmpresaDAO e_dao = new EmpresaDAO();
                ProfissionalDAO p_dao = new ProfissionalDAO();

				Usuario usuario = dao.getByEmail(login);
                
                if (usuario != null) {
                    Empresa empresa = e_dao.getByID_Usuario(usuario.getId());
                    Profissional profissional = p_dao.getByID_Usuario(usuario.getId());
					if (usuario.getSenha().equals(senha)) {
						request.getSession().setAttribute("usuarioLogado", usuario);
                        if (usuario.isAdmin()){
						    response.sendRedirect("admin/");
                        }
                        else if (empresa != null){ 
                            request.getSession().setAttribute("empresaLogada", empresa);
                            response.sendRedirect("minhasvagas/"); // algo assim
                        }
                        else if (profissional != null){
                            request.getSession().setAttribute("profissionalLogado", profissional);
                            response.sendRedirect("vagas/");
                        }
                        return;
					} else {
						erros.add("Senha inválida!");
					}
				} else {
					erros.add("Usuário não encontrado!");
				}
			}
		}
		
		request.getSession().invalidate();
        request.setAttribute("mensagens", erros);
        
        if(!erros.isExisteErros()) {
            //String URL = "/listaVagas.jsp";
            //RequestDispatcher rd = request.getRequestDispatcher(URL);
            //rd.forward(request, response);
            VagaDAO vagaDAO = new VagaDAO();
            
            List<Vaga> listaVagas = vagaDAO.getAllOpen();
            request.setAttribute("listaVagasAbertas", listaVagas);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/listaVagas.jsp");
            dispatcher.forward(request, response);
        }
        else{
            String URL = "/login.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(URL);
            rd.forward(request, response);
        
        }
	}
}
