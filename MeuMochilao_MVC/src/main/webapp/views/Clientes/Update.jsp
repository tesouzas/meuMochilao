<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fale Conosco</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="../../css/style.css">

</head>

<body>
    <div class="main">
        <!--INÍCIO NAVBAR-->
        <nav class="navbar navbar-expand-lg navbar-light bg-warning">
            <div class="container-fluid">
                <a class="navbar-brand" href="../../Index.html"><img width="250vh" src="../../Imagens/Logo/LogoMM1.png"
                        alt="Logomarca Meu Mochilão"></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href="./DestinoMM.html">Nossos destinos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="./PromoMM.html">Nossas promoções</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="./Reservas.html">Minhas reservas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="./ContatoMM.html">Fale conosco</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="./LoginMM.html">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="./AdmMM.html">Adm</a>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="Pesquisa" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Buscar</button>
                    </form>
                </div>
            </div>
        </nav>
        <!--FIM DO NAVBAR-->

        <br><br>
        <h2 color="black" align="center">Cadastre-se e faça parte da comunidade <b> Meu Mochilão</b>.</h2>
        <h6 color="black" align="center">Estamos muito felizes por ter você aqui!</h6>
        <br>

        <!--FORMULÁRIO-->
        <form action="../../clientes-uppdate" class="row g-3">
           	<div class="col-12">
           	<label for="id" class="form-label">
                            Id
          	 </label>
             <input type="text" id="id" name="id" class="form-control" placeholder="id" 
                        value="<%=request.getAttribute("id") %>" readonly />
             </div>
            <div class="col-12">
                <label for="inputNome" class="form-label">Nome completo</label>
                <input type="text" class="form-control" placeholder="Digite seu nome" aria-label="Digite seu nome" value="<%=request.getAttribute("nome") %>"/>
            </div>
            <div class="col-md-6">
                <label for="CPF" class="form-label">CPF</label>
                <input type="number" class="form-control" placeholder="Digite seu CPF" aria-label="Digite seu CPF" value="<%=request.getAttribute("cpf") %>" />
            </div>
            <div class="col-md-6">
                <label for="inputCity" class="form-label">Cidade</label>
                <input type="text" class="form-control" placeholder="Digite sua cidade" value="<%=request.getAttribute("cidade") %>" />
            </div>
                <div class="col-12">
                    <button type="submit" class="btn btn-primary">Cadastrar</button>
                </div>
                <a href="../../clientes" class="btn btn-danger" style="margin-left: 10px">
                        Cancelar
                    </a>
            </form>
            <br><br><br>
            <!--FIM - FORMULÁRIO-->


            <!--INÍCIO - RODAPÉ-->
            <footer>
                <!-- INÍCIO - ENDEREÇO-->
                <table bgcolor="#FFD700" border="0" width="100%" cellpadding="20">
                    <tr>
                        <td align="center" width="33%">
                            <h3>
                                <font face="Arial"> Televendas </font>
                            </h3>
                            <p>
                                <font face="Arial"> (81) 9 9987 9993</font>
                            </p>
                            <p>
                                <font face="Arial"> Segunda à sexta: 09h às 21h</font>
                            </p>
                        </td>

                        <td align="center" width="33%">
                            <h3>
                                <font face="Arial"> Loja </font>
                            </h3>
                            <p>
                                <font face="Arial"> Rua Chico Mendes, 200, lj 2</font>
                            </p>
                            <p>
                                <font face="Arial">Boa Viagem - CEP: 51.030-020</font>
                            </p>
                            <p>
                                <font face="Arial"> Recife - PE - Brasil</font>
                            </p>
                            <p>
                                <font face="Arial"> meumochilao@meumochilao.com.br</font>
                            </p>
                        </td>
                    </tr>
                </table>
                <!-- FIM - ENDEREÇO-->

                <br>
            </footer>
            <div class="copy">
                <p align="center" color="grey">
                    Agência Meu Mochilão S/A - CNPJ: 1056.5000.0001-92 - Rua Chico Mendes, Recife-PE
                    <center>&copy; Agência Meu Mochilão - Todos os direitos reservados. </center>
                </p>
            </div>
            <!--FIM - RODAPÉ-->


            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
                crossorigin="anonymous"></script>
</body>

</html>