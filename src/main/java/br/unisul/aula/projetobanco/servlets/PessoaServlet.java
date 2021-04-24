package br.unisul.aula.projetobanco.servlets;

import br.unisul.aula.projetobanco.config.ConstantesNavegacao;
import br.unisul.aula.projetobanco.dao.PessoaDAO;
import br.unisul.aula.projetobanco.model.Usuario;

import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "PessoaServlet", value = "/PessoaServlet")
public class PessoaServlet extends HttpServlet {
    private final PessoaDAO dao = new PessoaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("txtNome");
        try {
            buscarPessoaPorNome(request, nome);
        } catch (IllegalArgumentException e) {
            request.setAttribute("resposta", e.getMessage());
        }  catch (NoResultException e){
            request.setAttribute("resposta", ConstantesNavegacao.MENSAGEM_PROJETO_NAO_ENCONTRADA);
        }  catch (Exception e) {
            request.setAttribute("resposta", "Erro desconhecido");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(ConstantesNavegacao.PESSOA + "/listarPessoa.jsp");
        dispatcher.forward(request, response);
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
            Usuario pessoa = new Usuario(nome, cargo, login);
            dao.adicionarUm(pessoa);
            request.setAttribute("resposta", "Pessoa cadastrada com sucesso");

        } catch (Exception e) {
            request.setAttribute("resposta", "Erro desconhecido ao incluir a pessoa");
            System.out.println(e.getCause());
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(ConstantesNavegacao.PESSOA + "/respostaAcaoPessoa.jsp");
        requestDispatcher.forward(request, response);

    }
}
