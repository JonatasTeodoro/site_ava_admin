<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>AVA Modelismo</title>

        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/barra.png"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <script src="https://kit.fontawesome.com/946a1a1c44.js"></script>
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">

        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/styles.css">

        <style type="text/css">
            i:hover{
                font-size: 45px;
                color: red; 
            }

            i:active{
                color: black;
            }

            .fa{
                font-size: 40px; 
                color: #050366; 
                margin: 10px
            }

            a{
                color: black;
            }

        </style>

    </head>

    <body style="background-image: url(https://www.dnoticias.pt/binrepository/768x433/0c1/768d432/none/11506/HORF/image_content_2211031_20190514083935.jpg); background-size: cover">

        <input type="hidden" id="retorno" value="${retorno}">

        <div class="container">          
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Tipo</th>
                        <th>Ação</th>
                    </tr>
                </thead>
                <tbody id="divLista">

                </tbody>
            </table>
        </div>



        <nav style="background-color: #f5f5f5" class="navbar navbar-light navbar-expand fixed-bottom">
            <div class="collapse navbar-collapse" id="navcol-1" style="height: 80px">
                <ul class="nav navbar-nav mx-auto">
                    <li class="nav-item animated fadeInLeftBig" role="presentation"><a href="#" data-toggle="modal" data-target="#agendarNoTopo"><i class="fa fa-arrow-up"></i></a></li>
                    <li class="nav-item animated fadeInLeftBig" role="presentation"><a href="#" data-toggle="modal" data-target="#escolherTipo"><i class="fa fa-question"></i></a></li>
                    <li class="nav-item animated fadeInLeftBig" role="presentation"><a href="#" data-toggle="modal" data-target="#agendarNaFila"><i class="fa fa-plus"></i></a></li>
                    <li class="nav-item animated fadeInLeftBig" role="presentation"><a href="#" data-toggle="modal" data-target="#sortearCadastrado"><i class="fa fa-gift"></i></a></li>
                </ul>
            </div>
        </nav>






        <!-- MODAL  -->
        <!-- The Modal -->
        <div class="modal" id="agendarNaFila">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Agendar</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <div class="col-sm-12">
                            <div class="col-sm-12"><button onclick="cadastrarNaFila(0)" class="btn btn-block btn-info"><i class="fa fa-plane"></i> Avião</button></div>
                            <div class="col-sm-12" style="margin-top: 5px"><button onclick="cadastrarNaFila(1)" class="btn btn-block btn-warning"><i class="fa fa-helicopter"></i> Helicóptero</button></div>
                        </div>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Sair</button>
                    </div>

                </div>
            </div>
        </div>



        <!-- MODAL  -->
        <!-- The Modal -->
        <div class="modal" id="agendarNoTopo">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Agendar</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <div class="col-sm-12">
                            <div class="col-sm-12"><button onclick="cadastrarTopo(0)" class="btn btn-block btn-info"><i class="fa fa-plane"></i> Avião</button></div>
                            <div class="col-sm-12" style="margin-top: 5px"><button onclick="cadastrarTopo(1)" class="btn btn-block btn-warning"><i class="fa fa-helicopter"></i> Helicóptero</button></div>

                        </div>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Sair</button>
                    </div>

                </div>
            </div>
        </div>


        <!-- MODAL  -->
        <!-- The Modal -->
        <div class="modal" id="escolherTipo">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Tipo atual</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <div class="col-sm-12">
                            <div class="col-sm-12"><button onclick="mudaTipo(1)" class="btn btn-block btn-info"><i class="fa fa-plane"></i> Aviões</button></div>
                            <div class="col-sm-12" style="margin-top: 5px; margin-bottom: 5px"><button onclick="mudaTipo(2)" class="btn btn-block btn-warning"><i class="fa fa-helicopter"></i> Helicópteros</button></div>
                            <div class="col-sm-12"><button onclick="mudaTipo(0)" class="btn btn-block btn-success"><i class="fa fa-list"></i> Todos</button></div>
                        </div>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Sair</button>
                    </div>

                </div>
            </div>
        </div>


        
        
        
        <!-- MODAL  -->
        <!-- The Modal -->
        <div class="modal" id="sortearCadastrado">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Sortear</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <div class="col-sm-12">
                            <div class="col-sm-12"><button onclick="sortear(0)" class="btn btn-block btn-info"><i class="fa fa-users"></i> Sortear</button></div>
                            <div class="col-sm-12" style="margin-top: 5px"><button onclick="sortear(1)" class="btn btn-block btn-info"><i class="fa fa-trash"></i> Limpar</button></div>
                        </div>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Sair</button>
                    </div>

                </div>
            </div>
        </div>
        
        <!-- MODAL  -->
        <!-- The Modal -->
        <div class="modal" id="sorteado">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Sorteado</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <div class="col-sm-12">
                            <label id="mensagemRetornoSorteio"></label>
                        </div>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Sair</button>
                    </div>

                </div>
            </div>
        </div>


        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>

        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/daterangepicker/moment.min.js"></script>
        <script src="vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>
        <script src="js/atualiza_fila.js?version=10"></script>
        <script src="js/cadastros.js?version=10"></script>

        <script type="text/javascript">
                                function verificarRetorno() {
                                    var ret = document.getElementById("retorno").value;
                                    if (ret != "" && ret != null) {
                                        alert(ret);
                                    }
                                }

                                verificarRetorno();


        </script>

        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.min.js"></script>
    </body>

</html>