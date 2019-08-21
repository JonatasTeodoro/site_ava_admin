function cadastrarTopo(tipo) {
    var nome = prompt("Nome do piloto:", "");
    if (nome == null || nome == "") {

    } else {
        enviaTopo(nome, tipo);
    }

}

function cadastrarNaFila(tipo) {
    var nome = prompt("Nome do piloto:", "");
    if (nome == null || nome == "") {

    } else {
        enviaFila(nome, tipo);
    }

}


function enviaTopo(nome, tipo) {

    var retorno = false;
    var a;
    $.ajax({
        url: 'CadastrarTopo?nome=' + ascii_to_hexa(nome) + "&tipo=" + tipo,
        async: false,
        success: function (data)
        {
            var obj = $.parseJSON(data);

            if (obj.retorno == 0) {
                alert("Cadastrado com sucesso!");
            } else {
                alert("Erro ao cadastrar!");
            }

            $('#agendarNoTopo').hide();
            $('.modal-backdrop').remove();

        }
    }).done(function () {
        a = true;
    });
    console.log(a);
    return retorno;
}

function enviaFila(nome, tipo) {

    var retorno = false;
    var a;
    $.ajax({
        url: 'CadastrarNaFila?nome=' + ascii_to_hexa(nome) + "&tipo=" + tipo,
        async: false,
        success: function (data)
        {
            var obj = $.parseJSON(data);

            if (obj.retorno == 0) {
                alert("Cadastrado com sucesso!");
            } else {
                alert("Erro ao cadastrar!");
            }

            $('#agendarNaFila').hide();
            $('.modal-backdrop').remove();

        }
    }).done(function () {
        a = true;
    });
    console.log(a);
    return retorno;
}


function mudaTipo(tipo) {

    var retorno = false;
    var a;
    $.ajax({
        url: 'MudarTipo?tipo=' + tipo,
        async: false,
        success: function (data)
        {
            var obj = $.parseJSON(data);

            if (obj.retorno == 0) {
                alert("Alterado com sucesso!");
            } else {
                alert("Erro ao alterar!");
            }

            $('#escolherTipo').hide();
            $('.modal-backdrop').remove();

        }
    }).done(function () {
        a = true;
    });
    console.log(a);
    return retorno;
}


function sortear(acao) {

    var retorno = false;
    var a;
    $.ajax({
        url: 'Sortear?acao=' + acao,
        async: false,
        success: function (data)
        {
            var obj = $.parseJSON(data);



            $('#sortearCadastrado').hide();
            $('.modal-backdrop').remove();

            document.getElementById("mensagemRetornoSorteio").innerHTML = obj.retorno;
            $('#sorteado').modal();

        }
    }).done(function () {
        a = true;
    });
    console.log(a);
    return retorno;
}


function ascii_to_hexa(str) {
    var arr1 = [];
    for (var n = 0, l = str.length; n < l; n++)
    {
        var hex = Number(str.charCodeAt(n)).toString(16);
        arr1.push(hex);
    }
    return arr1.join('');
}