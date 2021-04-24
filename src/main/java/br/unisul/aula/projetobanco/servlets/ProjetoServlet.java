package br.unisul.aula.projetobanco.servlets;

import br.unisul.aula.projetobanco.config.ConstantesNavegacao;
import br.unisul.aula.projetobanco.dao.ProjetoDAO;
import br.unisul.aula.projetobanco.model.Projeto;

import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

@WebServlet(name = "ProjetoServlet", value = "/ProjetoServlet")
public class ProjetoServlet extends HttpServlet {
    private final ProjetoDAO dao = new ProjetoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("txtNome");
        try {

            Projeto projeto = dao.bucarObjetoPorNome(nome);
            request.setAttribute("projeto", projeto);
        } catch (IllegalArgumentException e) {
            request.setAttribute("resposta", e.getMessage());
        } catch (NoResultException e){
            request.setAttribute("resposta", ConstantesNavegacao.MENSAGEM_PESSOA_NAO_ENCONTRADA);
        } catch (Exception e){
            request.setAttribute("resposta", "Erro desconhecido");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(ConstantesNavegacao.PROJ+"/listarProjeto.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("txtNome");
        String dataIni = request.getParameter("dtInicio");
        String dataFim = request.getParameter("dtFim");

        System.out.println(dataIni);
        try {
            Projeto projeto = new Projeto(nome, dataIni, dataFim);
            dao.adicionarUm(projeto); ;
            request.setAttribute("resposta", "Projeto cadastrada com sucesso");

        } catch (ParseException e) {
            request.setAttribute("resposta", "Erro na formatação da data");
            System.out.println(e.getMessage());
        }catch (Exception e) {
            request.setAttribute("resposta", "Erro desconhecido ao incluir a projeto");
            System.out.println(e.getCause());

        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(ConstantesNavegacao.PROJ+"/respostaProjeto.jsp");
        requestDispatcher.forward(request, response);
    }
}
