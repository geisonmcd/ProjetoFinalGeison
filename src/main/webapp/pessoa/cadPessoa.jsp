<%@ page import="br.unisul.aula.projetobanco.config.ConstantesNavegacao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title><%=ConstantesNavegacao.TITULO_PESSOA_CADASTRO%></title>
</head>
<body>
<h1><%=ConstantesNavegacao.TITULO_PESSOA_CADASTRO%></h1>
<p>
<form action="<%=ConstantesNavegacao.PROJETO%>/PessoaServlet" method="post">
    Nome: <input type="text" name="txtNome"><br>
    Cargo: <input type="text" name="txtCargo"><br><br>
    Login: <input type="text" name="txtLogin"><br><br>
    <input type="submit" value="Cadastrar">
</form>
</p>
</body>
</html>
