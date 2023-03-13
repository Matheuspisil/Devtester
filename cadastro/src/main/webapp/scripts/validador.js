

function validar(){
    let nome = frmNovo.nome.value
    let cpf = frmNovo.cpf.value
    let cargo = frmNovo.cargo.value
    
    if (nome === ""){
        alert('Preencha o campo nome')
        frmNovo.nome.focus()
        return false
    } else if (cpf === ""){
        alert('Preencha o campo cpf')
        frmNovo.cpf.focus()
        return false
    }else if (cargo === ""){
        alert('Preencha o campo cargo')
        frmNovo.cargo.focus()
        return false
    }else {
        document.forms["frmNovo"].submit()
    }
}