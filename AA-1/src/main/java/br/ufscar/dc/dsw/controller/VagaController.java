package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.EmpresaDAO;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.dao.VagaDAO;
import br.ufscar.dc.dsw.domain.Empresa;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Vaga;
import br.ufscar.dc.dsw.util.Erro;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/minhasvagas/*")
public class VagaController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private VagaDAO vagaDAO;

    @Override
    public void init() {
        vagaDAO = new VagaDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
        Empresa empresa = (Empresa) request.getSession().getAttribute("empresaLogada");
        Erro erros = new Erro();

        if (usuario == null || empresa == null) {
            response.sendRedirect(request.getContextPath());
            return;
        }

        String action = request.getPathInfo();
        if (action == null) {
            action = "";
        }
        lista(request, response);
        /*try {
            lista(request, response);
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
        */
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ProfissionalDAO profissionalDAO = new ProfissionalDAO();
        EmpresaDAO empresaDAO = new EmpresaDAO();
        VagaDAO vagaDAO = new VagaDAO();

        Empresa empresa = (Empresa) request.getSession().getAttribute("empresaLogada");

        //List<Usuario> listaUsuarios = usuarioDAO.getAllWithoutRole();
        List<Vaga> listaVagas = vagaDAO.getAllByEmpresa(empresa.getId());

        //request.setAttribute("listaUsuarios", listaUsuarios);
        request.setAttribute("listaVagas", listaVagas);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/minhasVagas/lista.jsp");
        dispatcher.forward(request, response);
    }
}
/*
    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/empresa/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void inserir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        boolean admin = Boolean.parseBoolean(request.getParameter("admin"));

        Usuario usuario = new Usuario(email, nome, senha, admin);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.insert(usuario);
        usuario = usuarioDAO.getByEmail(email);

        String cnpj = request.getParameter("cnpj");
        String descricao = request.getParameter("descricao");
        String cidade = request.getParameter("cidade");

        Empresa empresa = new Empresa(usuario, cnpj, descricao, cidade);

        empresaDAO.insert(empresa);
        response.sendRedirect("lista");
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Empresa empresa = empresaDAO.getByID(id);
        request.setAttribute("empresa", empresa);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/empresa/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void atualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Long id = Long.parseLong(request.getParameter("id"));

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        boolean admin = Boolean.parseBoolean(request.getParameter("admin"));

        Usuario usuario = new Usuario(email, nome, senha, admin);

        String cnpj = request.getParameter("cnpj");
        String descricao = request.getParameter("descricao");
        String cidade = request.getParameter("cidade");

        Empresa empresa = new Empresa(id, usuario, cnpj, descricao, cidade);

        empresaDAO.update(empresa);
        response.sendRedirect("lista");
    }

    private void remover(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Empresa empresa = new Empresa(id);

        empresaDAO.delete(empresa);
        response.sendRedirect("lista");
    }

}
*/