function confirmar(idcad) {
	let resposta = confirm("Desesja Excluir esse contato ?")
	if (resposta === true) {

		window.location.href = "delete?idcad=" + idcad;
	}
}