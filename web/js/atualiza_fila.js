function atualizaFila() {

    var divLista = document.getElementById("divLista");
    var htmlDiv = "";


    var retorno = false;
    var a;
    $.ajax({
        url: 'BuscarFila',
        async: false,
        success: function (data)
        {
            var obj = $.parseJSON(data);

            for (var i = 0; i < obj.lista.length; i++) {
                if (i == 0) {
                    htmlDiv = "<tr style='background-color: red'><td><a href='PilotoAtual?id="+obj.lista[i].id+"'>"+obj.lista[i].nome+"</a></td><td>"+obj.lista[i].tipo+"</td><td><a href='ExcluirElemento?id="+obj.lista[i].id+"'><button class='btn btn-danger'>Excluir</button></a></td></tr>";
                } else {
                    htmlDiv = htmlDiv + "<tr><td><a href='PilotoAtual?id="+obj.lista[i].id+"'>"+obj.lista[i].nome+"</a></td><td>"+obj.lista[i].tipo+"</td><td><a href='ExcluirElemento?id="+obj.lista[i].id+"'><button class='btn btn-danger'>Excluir</button></a></td></tr>";
                }
            }

           
            divLista.innerHTML = htmlDiv;

        }
    }).done(function () {
        a = true;
    });
    console.log(a);
    return retorno;
}

function checkImgOnline() {
    try {
        atualizaFila();
    } catch (error) {
        clearInterval(ponteiro);
    }
}

checkImgOnline();
const ponteiro = setInterval("atualizaFila()", 5000);