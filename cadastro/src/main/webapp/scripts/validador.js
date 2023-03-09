function validar()
{
    let nome = frmnovo.nome.value
    let cpf = frmnovo.cpf.value
    let cargo = frmnovo.cargo.value
    if (nome === "" ) {
        alert('Preencha o campo nome')
        frmnovo.nome.focus()
        return false
    } else if (cpf === "" ) {
        alert('Preencha o campo cpf')
        frmnovo.cpf.focus()
        return false
    }else if (cargo === "" ) {
        alert('Preencha o campo cargo')
        frmnovo.cargo.focus()
        return false
    }else {
        document.forms["frmNovo"].submit()
    }
}