window.addEventListener('DOMContentLoaded', function () {
    var avatar = document.getElementById('avatar');
    var image = document.getElementById('image');
    var input = document.getElementById('input');
    var $progress = $('.progress');
    var $alert = $('.alert');
    var $modal = $('#modal');
    var cropper;

    $('[data-toggle="tooltip"]').tooltip();

    input.addEventListener('change', function (e) {
        var files = e.target.files;
        var done = function (url) {
            input.value = '';
            image.src = url;
            $alert.hide();
            $modal.modal('show');
        };
        var reader;
        var file;
        var url;

        if (files && files.length > 0) {
            file = files[0];

            if (URL) {
                done(URL.createObjectURL(file));
            } else if (FileReader) {
                reader = new FileReader();
                reader.onload = function (e) {
                    done(reader.result);
                };
                reader.readAsDataURL(file);
            }

            sizeOfThings();
        }




    });

    $modal.on('shown.bs.modal', function () {
        cropper = new Cropper(image, {
            aspectRatio: 1, //0.8666666, //Muda a proporção
            //viewMode: 3, Imagem muda de tamanho sozinha
        });
    }).on('hidden.bs.modal', function () {
        cropper.destroy();
        cropper = null;
    });

    document.getElementById('crop').addEventListener('click', function () {
        var initialAvatarURL;
        var canvas;

        $modal.modal('hide');

        if (cropper) {
            canvas = cropper.getCroppedCanvas({
                width: 160,
                height: 160,
            });
            initialAvatarURL = avatar.src;
            avatar.src = canvas.toDataURL();
            $progress.show();
            $alert.removeClass('alert-success alert-warning');
            canvas.toBlob(function (blob) {
                var formData = new FormData();

                formData.append('avatar', blob, 'avatar.jpg');
                $.ajax('https://jsonplaceholder.typicode.com/posts', {
                    method: 'POST',
                    data: formData,
                    processData: false,
                    contentType: false,

                    success: function () {
                        //$alert.show().addClass('alert-success').text('Carregado');
                    },

                    complete: function () {
                        $progress.hide();
                    },
                });
            });
        }

        //Mostrar src da img
        var valor = document.getElementById("avatar").src.toString();
        document.getElementById("64imagem").value = valor;


    });
});




function sizeOfThings() {
    var windowWidth = window.innerWidth;
    var windowHeight = window.innerHeight;

    var screenWidth = screen.width;
    var screenHeight = screen.height;

    document.getElementById("image").style.height = windowHeight * 0.63 + "px";


}
;
sizeOfThings();

window.addEventListener('resize', function () {
    sizeOfThings();
});