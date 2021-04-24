
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%! private final String TITULO = "Pessoas e Projetos";%>
    <title><%=TITULO%></title>
</head>
<body>
<h1><%=TITULO%></h1>
<a href="pessoa/listarPessoa.jsp">Lista de Pessoas</a><br>
<a href="projeto/listarProjeto.jsp">Lista de Projetos</a><br>
<br>
<%@include file="rodape.jsp"%>
</body>
</html>
