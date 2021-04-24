<%@ page import="br.unisul.aula.projetobanco.config.ConstantesNavegacao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%=ConstantesNavegacao.TITULO_PROJETO_CADASTRO%></title>
</head>
<body>
<h1><%=ConstantesNavegacao.TITULO_PROJETO_CADASTRO%></h1>
<form action="<%=ConstantesNavegacao.PROJETO%>/ProjetoServlet" method="post">
    Nome <input type="text" name="txtNome"><bR>
    Data Início: <input type="date" name="dtInicio" ><br>
    Data Fim: <input type="date" name="dtFim"><br><br>
    <input type="submit" value="Cadastrar">
</form>
</body>
</html>
