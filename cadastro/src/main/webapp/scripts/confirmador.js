function confirmar(idcad) {
	let resposta = confirm("Desesja Excluir esse contato ?")
	if (resposta === true) {
		// alert(idcad)
		window.location.href = "delete?idcad=" + idcad;
	}
}