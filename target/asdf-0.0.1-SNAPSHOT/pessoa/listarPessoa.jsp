<%@ page import="br.unisul.aula.projetobanco.dao.PessoaDAO" %>
<%@ page import="br.unisul.aula.projetobanco.model.Usuario" %>
<%@ page import="br.unisul.aula.projetobanco.config.ConstantesNavegacao" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%=ConstantesNavegacao.TITULO_PESSOA_LISTA%></title>
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
<table border="1">
    <tr>
        <th>Nome</th>
        <th>Cargo</th>
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
