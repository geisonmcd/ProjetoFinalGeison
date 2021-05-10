package br.unisul.aula.projetobanco.servlets;

import java.io.IOException;

import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.unisul.aula.projetobanco.config.ConstantesNavegacao;
import br.unisul.aula.projetobanco.dao.PessoaDAO;
import br.unisul.aula.projetobanco.model.Usuario;

@WebServlet(name = "PessoaServlet", value = "/PessoaServlet")
public class PessoaServlet extends HttpServlet {
    private final PessoaDAO dao = new PessoaDAO();
    static Usuario usu;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 response.setContentType("application/json");
         response.setCharacterEncoding("UTF-8");
         response.addHeader("Access-Control-Allow-Origin", "*");
         System.out.println("tá chegando aqui");
         Gson gson = new Gson();
         String json = gson.toJson(dao.listarTodos());
         response.getWriter().println(json);
    }

    private void buscarPessoaPorNome(HttpServletRequest request, String nome) throws NoResultException, IllegalArgumentException {
        Usuario pessoa = dao.bucarObjetoPorNome(nome);
        request.setAttribute("pessoa", pessoa);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("txtNome");
        String cargo = request.getParameter("txtCargo");
        String login = request.getParameter("txtLogin");

        try {
            request.setAttribute("resposta", "Pessoa cadastrada com sucesso");

        } catch (Exception e) {
            request.setAttribute("resposta", "Erro desconhecido ao incluir a pessoa");
            System.out.println(e.getCause());
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(ConstantesNavegacao.PESSOA + "/respostaAcaoPessoa.jsp");
        requestDispatcher.forward(request, response);

    }
}
