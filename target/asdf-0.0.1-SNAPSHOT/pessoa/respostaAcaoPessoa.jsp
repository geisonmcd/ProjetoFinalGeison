<%@ page import="javax.swing.*" %>
<%@ page import="br.unisul.aula.projetobanco.config.ConstantesNavegacao" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%=ConstantesNavegacao.TITULO_PESSOA_RESSPOSTA%>></title>
</head>
<body>
<h1><%=ConstantesNavegacao.TITULO_PESSOA_RESSPOSTA%></h1>
<h2><%=request.getAttribute("resposta")%></h2>

<br>
<br>
<a href="<%=ConstantesNavegacao.PROJETO+ConstantesNavegacao.PESSOA%>/cadPessoa.jsp">Cadastrar Pessoas</a><br>
<a href="<%=ConstantesNavegacao.PROJETO+ConstantesNavegacao.PESSOA%>/listarPessoa.jsp">Listar Pessoas</a>
</body>
</html>
