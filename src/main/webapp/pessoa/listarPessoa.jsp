<%@ page import="br.unisul.aula.projetobanco.dao.PessoaDAO" %>
<%@ page import="br.unisul.aula.projetobanco.model.Usuario" %>
<%@ page import="br.unisul.aula.projetobanco.config.ConstantesNavegacao" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%=ConstantesNavegacao.TITULO_PESSOA_LISTA%></title>
   	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous"/> 
   	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</head>
<body>
<h1><%=ConstantesNavegacao.TITULO_PESSOA_LISTA%></h1>
<br>
<a href="<%=ConstantesNavegacao.PROJETO+ConstantesNavegacao.PESSOA%>/cadPessoa.jsp">Cadastrar Pessoa</a>
<br>
<br>
<h4>Buscar Pessoa</h4>
<p>
    <form method="get" action="<%=ConstantesNavegacao.PROJETO%>/PessoaServlet">
    Nome: <input type="text" name="txtNome"><br>
    <input type="submit" value="Consultar">
</form>
</p>
<p>
    <%
    Usuario pessoaResposta=null;
            if (request.getAttribute("resposta")!=null){
    %>
    <h2><%=request.getAttribute("resposta")%></h2>
    <%
    } else if (request.getAttribute("pessoa")!=null){
                pessoaResposta=(Usuario) request.getAttribute("pessoa");
    %>
Nome:<%=pessoaResposta.getNome()%>
<br>
Cargo:<%=pessoaResposta.getCargo()%>
<%
}
%>

</p>
<p>
<%
PessoaDAO pessoaDAO = new PessoaDAO();
        if (pessoaDAO.listarTodos().size()>0){
%>
<table class="table" border="1">
    <tr>
        <th>Nome</th>
        <th>Cargo</th>
        <th>Login</th>
    </tr>
    <%
    for (Usuario pessoa: pessoaDAO.listarTodos()){
                String cor = "white";
                if (pessoaResposta!=null){
                    if (pessoaResposta.equals(pessoa)){
                        cor="yellow";
                    }
                }
    %>
    <tr bgcolor="<%=cor%>">
        <td><%=pessoa.getNome()%></td>
        <td><%=pessoa.getCargo()%></td>
        <td><%=pessoa.getLogin()%></td>
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
