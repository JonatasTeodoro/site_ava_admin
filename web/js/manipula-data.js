function validarDataNascimento(dataCampo) {
    var strData = dataCampo.value;
    if (strData.length == 10) {
        var partesData = strData.split("/");
        var data = new Date(partesData[2], partesData[1] - 1, partesData[0]);
        if (data > new Date()) {
            alert("Data de nascimento maior que data atual");
            dataCampo.value = "";
        }
    }
}


