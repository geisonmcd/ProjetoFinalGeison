<%@ page import="br.unisul.aula.projetobanco.config.ConstantesNavegacao" %>
<%@ page import="br.unisul.aula.projetobanco.model.Projeto" %>
<%@ page import="br.unisul.aula.projetobanco.dao.ProjetoDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%=ConstantesNavegacao.TITULO_PROJETO_LISTA%></title>
</head>
<body>
<h1><%=ConstantesNavegacao.TITULO_PROJETO_LISTA%></h1>
<br>
<a href="<%=ConstantesNavegacao.PROJETO+ConstantesNavegacao.PROJ%>/cadProjeto.jsp">Cadastrar Projeto</a>
<br>
<br>
<form action="<%=ConstantesNavegacao.PROJETO%>/ProjetoServlet" method="get">
    Nome: <input type="text" name="txtNome"><br>
    <input type="submit" value="Consultar">
</form>
<br>
<p>
        <%
    Projeto projetoResposta=null;
        if (request.getAttribute("resposta")!=null){


    %>
<h2><%=request.getAttribute("resposta")%></h2>
<%
} else if (request.getAttribute("projeto")!=null){
    projetoResposta=(Projeto) request.getAttribute("projeto");

%>
Nome:<%=projetoResposta.getNome()%>
<br>
Data Início:<%=projetoResposta.getDataPrevistaInicioFormatado()%><br>
Data Fim:<%=projetoResposta.getDataPrevistaFimFormatado()%><br>
<%
    }
%>

</p>
<p>
        <%
        ProjetoDAO projetoDAO = new ProjetoDAO();
        if (projetoDAO.listarTodos().size()>0){
%>
<table border="1">
    <tr>
        <th>Nome</th>
        <th>Data Início</th>
        <th>Data Fim</th>
    </tr>
    <%
        for (Projeto projeto: projetoDAO.listarTodos()){
            String cor = "white";
            if (projetoResposta!=null){
                if (projetoResposta.equals(projeto)){
                    cor="yellow";
                }
            }
    %>
    <tr bgcolor="<%=cor%>">
        <td><%=projeto.getNome()%></td>
        <td><%=projeto.getDataPrevistaInicioFormatado()%></td>
        <td><%=projeto.getDataPrevistaFimFormatado()%></td>
    </tr>
    <%
        }
    %>
</table>
<%
    }
%>
</p>
<%@include file="../rodape.jsp"%>
</body>
</html>
</body>
</html>
