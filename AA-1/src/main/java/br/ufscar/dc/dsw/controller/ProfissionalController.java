package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.EmpresaDAO;
import br.ufscar.dc.dsw.dao.ProfissionalDAO;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.dao.ProfissionalDAO;
import br.ufscar.dc.dsw.domain.Empresa;
import br.ufscar.dc.dsw.domain.Profissional;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Profissional;
import br.ufscar.dc.dsw.util.Erro;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/profissionais/*")
public class ProfissionalController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProfissionalDAO profissionalDAO;

    @Override
    public void init() {
        profissionalDAO = new ProfissionalDAO();
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
        Erro erros = new Erro();

        if (usuario == null) {
            response.sendRedirect(request.getContextPath());
            return;
        } else if (!usuario.isAdmin()) {
            erros.add("Acesso não autorizado!");
            erros.add("Apenas usuários administradores têm acesso a essa página!");
            request.setAttribute("mensagens", erros);
            RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
            rd.forward(request, response);
            return;
        }

        String action = request.getPathInfo();
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "/cadastrar":
                    apresentaFormCadastro(request, response);
                    break;
                case "/inserir":
                    inserir(request, response);
                    break;
                case "/remover":
                    remover(request, response);
                    break;
                case "/editar":
                    apresentaFormEdicao(request, response);
                    break;
                case "/atualizar":
                    atualizar(request, response);
                    break;
                default:
                    lista(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProfissionalDAO profissionalDAO = new ProfissionalDAO();
        List<Profissional> listaProfissionais = profissionalDAO.getAll();

        request.setAttribute("listaProfissionais", listaProfissionais);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/profissional/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/profissional/formulario.jsp");
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

        String cpf = request.getParameter("cpf");
        String telefone = request.getParameter("telefone");
        String sexo = request.getParameter("sexo");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNascimento;
        java.util.Date utilDate = null;

        try {
            utilDate = format.parse(request.getParameter("dataNascimento"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        dataNascimento = new Date(utilDate.getTime());

        Profissional profissional = new Profissional(usuario, cpf, telefone, sexo, dataNascimento);

        profissionalDAO.insert(profissional);
        response.sendRedirect("lista");
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Profissional profissional = profissionalDAO.getByID(id);
        request.setAttribute("profissional", profissional);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/profissional/formulario.jsp");
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

        String cpf = request.getParameter("cpf");
        String telefone = request.getParameter("telefone");
        String sexo = request.getParameter("sexo");
        Date dataNascimento = Date.valueOf(request.getParameter("dataNascimento"));

        Profissional profissional = new Profissional(id, usuario, cpf, telefone, sexo, dataNascimento);

        profissionalDAO.update(profissional);
        response.sendRedirect("lista");
    }

    private void remover(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Profissional profissional = new Profissional(id);

        profissionalDAO.delete(profissional);
        response.sendRedirect("lista");
    }

}
