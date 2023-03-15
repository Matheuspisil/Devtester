<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList "%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("funcionarios");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Funcionários</title>
<link rel="icon" href="imagens/userphoto.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Funcionarios</h1>
	<a href="novofuncionario.html" class=botao>Cadastrar funcionario</a>

	<hr>

	<table id="table">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Cpf</th>
				<th>Cargo</th>
				<th>Nascimento</th>
				<th>Endereço</th>
				<th>E-mail</th>
				<th>Telefone</th>
				<th>opções</th>

			</tr>
		</thead>

		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getIdcad()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getCpf()%></td>
				<td><%=lista.get(i).getCargo()%></td>
				<td><%=lista.get(i).getNascimento()%></td>
				<td><%=lista.get(i).getEndereco()%></td>
				<td><%=lista.get(i).getEmail()%></td>
				<td><%=lista.get(i).getTel()%></td>
				<td><a href="select?idcad=<%=lista.get(i).getIdcad()%>"
					class="botao">Editar</a> <a
					href="javascript: confirmar(<%=lista.get(i).getIdcad()%>)"
					class="botao1">Excluir</a></td>
			</tr>
			<%
			}
			%>
		</tbody>

	</table>

	<script src="scripts/confirmador.js"></script>
</body>
</html>