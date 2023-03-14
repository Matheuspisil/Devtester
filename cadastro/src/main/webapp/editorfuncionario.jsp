<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editor de funcionario cadastrado</title>
<link rel="icon" href="imagens/userphoto.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar funcionario</h1>
	<form name="frmNovo" action="insert">
		<table>
			<tr>
				<td><input type="text" name="idcad" id="place2" readonly value="<%out.print(request.getAttribute("idcad"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="place1" value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="cpf" class="place1" value="<%out.print(request.getAttribute("cpf"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="cargo" class="place1" value="<%out.print(request.getAttribute("cargo"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="narcimento" class="place1" value="<%out.print(request.getAttribute("narcimento"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="endereco" class="place1" value="<%out.print(request.getAttribute("endereco"));%>"></td>
			</tr>

			<tr>
				<td><input type="text" name="email" class="place1" value="<%out.print(request.getAttribute("email"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="tel" class="place1" value="<%out.print(request.getAttribute("tel"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="telefone" placeholder="Telefone"
					class="place1"></td>
			</tr>


		</table>
		<input type="button" value="Salvar" class="botao" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>