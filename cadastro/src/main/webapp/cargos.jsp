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
<title>CArgos</title>
<link rel="icon" href="imagens/userphoto.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Cargos</h1>
	<a href="frmNovo" class=botao>Cadastrar funcionário</a>
	<a href="report" class=botao1></a>

	<hr>

	<table id="table">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Cargo</th>
				

			</tr>
		</thead>

		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getIdcad()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getCargo()%></td>
				
			<%
			}
			%>
		</tbody>

	</table>

	<script src="scripts/.js"></script>
</body>
</html>