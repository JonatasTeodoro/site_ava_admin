function verificaForca(senha) {
    var forca = 0;

    if ((senha.length >= 4) && (senha.length <= 7))
        forca += 10;
    else if (senha.length > 7)
        forca += 25;

    if (senha.match(/[a-z]+/))
        forca += 10;
    if (senha.match(/[A-Z]+/))
        forca += 20;
    if (senha.match(/\d+/))
        forca += 20;
    if (senha.match(/\W/))
        forca += 25;

    const indicaForca = document.getElementById("forcaSenha");
    if (forca < 30) {
        indicaForca.innerHTML = "FRACA";
        indicaForca.style.width = "25%";
        indicaForca.style.backgroundColor = "#e86e6e";
    } else if (forca >= 30 && forca < 60) {
        indicaForca.innerHTML = "RAZO\u00c1VEL";
        indicaForca.style.width = "50%";
        indicaForca.style.backgroundColor = "#fafd4a";
    } else if (forca >= 60 && forca < 85) {
        indicaForca.innerHTML = "FORTE";
        indicaForca.style.width = "75%";
        indicaForca.style.backgroundColor = "#4aa2fd";
    } else {
        indicaForca.innerHTML = "EXCELENTE";
        indicaForca.style.width = "100%";
        indicaForca.style.backgroundColor = "#45d05c";
    }
}

