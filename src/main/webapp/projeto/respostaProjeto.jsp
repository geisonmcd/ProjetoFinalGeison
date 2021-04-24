<%@ page import="br.unisul.aula.projetobanco.config.ConstantesNavegacao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%=ConstantesNavegacao.TITULO_PROJETO_RESSPOSTA%>></title>
</head>
<body>
<h1><%=ConstantesNavegacao.TITULO_PROJETO_RESSPOSTA%></h1>
<h2><%=request.getAttribute("resposta")%></h2>

<br>
<br>
<a href="<%=ConstantesNavegacao.PROJETO+ConstantesNavegacao.PROJ%>/cadProjeto.jsp">Cadastrar Projeto</a><br>
<a href="<%=ConstantesNavegacao.PROJETO+ConstantesNavegacao.PROJ%>/listarProjeto.jsp">Listar Projetos</a>
</body>
</html>
