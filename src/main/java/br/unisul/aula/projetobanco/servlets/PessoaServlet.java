package br.unisul.aula.projetobanco.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

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
         response.setContentType("application/json");
         response.setCharacterEncoding("UTF-8");
         response.getWriter().println(json);
    }

    private void buscarPessoaPorNome(HttpServletRequest request, String nome) throws NoResultException, IllegalArgumentException {
        Usuario pessoa = dao.bucarObjetoPorNome(nome);
        request.setAttribute("pessoa", pessoa);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String body = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
    	System.out.println("esse é o body");
    	System.out.println(body);
    	Gson gson = new Gson();
    	Usuario usu = gson.fromJson(body, Usuario.class);
    	dao.adicionarUm(usu);
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String json = gson.toJson(usu);
        response.getWriter().println(json);
    }
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("doDelete !!!!!!!!!!!");
    	String idUsuario = request.getParameter("idUsuario");
    	System.out.println(idUsuario);
//    	Gson gson = new Gson();
//    	Usuario usu = gson.fromJson(body, Usuario.class);
//    	dao.adicionarUm(usu);
        response.setStatus(HttpServletResponse.SC_OK);
//        String json = gson.toJson(usu);
//        response.getWriter().println(json);
    }
}
