package br.ufscar.dc.dsw.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import br.ufscar.dc.dsw.dao.CandidaturaDAO;
import br.ufscar.dc.dsw.dao.ProfissionalDAO;
import br.ufscar.dc.dsw.dao.EmpresaDAO;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.dao.VagaDAO;
import br.ufscar.dc.dsw.domain.Empresa;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Vaga;
import br.ufscar.dc.dsw.domain.Candidatura;
import br.ufscar.dc.dsw.domain.Profissional;
import br.ufscar.dc.dsw.util.Erro;

import java.text.ParseException;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/vagas/*")
public class CandidaturaController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private VagaDAO vagaDAO;
    private CandidaturaDAO candidaturaDAO;

    @Override
    public void init() {
        vagaDAO = new VagaDAO();
        candidaturaDAO = new CandidaturaDAO();
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
        Profissional profissional = (Profissional) request.getSession().getAttribute("profissionalLogado");
        Erro erros = new Erro();

        if (usuario == null || profissional == null) {
            response.sendRedirect(request.getContextPath());
            return;
        }

        String action = request.getPathInfo();
        if (action == null) {
            action = "";
        }
        lista(request, response);
        /*
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
        */
    }
    

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VagaDAO vagaDAO = new VagaDAO();

        Empresa empresa = (Empresa) request.getSession().getAttribute("empresaLogada");

        List<Vaga> listaVagas = vagaDAO.getAllOpen();
        request.setAttribute("listaVagasAbertas", listaVagas);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vaga/lista.jsp");
        dispatcher.forward(request, response);
    }
    /*
    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/minhasVagas/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void inserir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Empresa empresa = (Empresa) request.getSession().getAttribute("empresaLogada");

        String descricao = request.getParameter("descricao");
        Double remuneracao = Double.parseDouble(request.getParameter("remuneracao"));
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dataLimite;
        java.util.Date utilDate = null;

        try {
            utilDate = format.parse(request.getParameter("dataLimite"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        dataLimite = new Date(utilDate.getTime());

        Vaga vaga = new Vaga(empresa, descricao, remuneracao, dataLimite);
        
        vagaDAO.insert(vaga);
        response.sendRedirect("lista");
    }
    
    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Vaga vaga = vagaDAO.getByID(id);
        request.setAttribute("vaga", vaga);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/minhasVagas/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void atualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Long id = Long.parseLong(request.getParameter("id"));

        Empresa empresa = (Empresa) request.getSession().getAttribute("empresaLogada");

        String descricao = request.getParameter("nome");
        Double remuneracao = Double.parseDouble(request.getParameter("remuneracao"));
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dataLimite;
        java.util.Date utilDate = null;

        try {
            utilDate = format.parse(request.getParameter("dataLimite"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        dataLimite = new Date(utilDate.getTime());

        Vaga vaga = new Vaga(empresa, descricao, remuneracao, dataLimite);

        vagaDAO.update(vaga);
        response.sendRedirect("lista");
    }

    private void remover(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Vaga vaga = new Vaga(id);

        vagaDAO.delete(vaga);
        response.sendRedirect("lista");
    }
    */    
}
