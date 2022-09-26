<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/style.css">
</head>

<body>

    <!--INÍCIO NAVBAR-->
    <nav class="navbar navbar-expand-lg navbar-light bg-warning">
        <div class="container-fluid">
            <a class="navbar-brand" href="HomeMM.html"><img width="250vh" src="../site/Imagens/Logo/LogoMM1.png"
                    alt="Logomarca Meu Mochilão"></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02"
                aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="./views/DestinoMM.html">Nossos destinos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./views/PromoMM.html">Nossas promoções</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="./Reservas.html">Minhas reservas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./views/ContatoMM.html">Fale conosco</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./views/LoginMM.html">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="./views/AdmMM.html">Adm</a>
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


    <main>

        <!--INÍCIO - CAROUSEL-->
        <br><br>
        <div alingn-itens="center" id="carouselExampleIndicators" size="100vh" class="carousel slide"
            data-bs-ride="carousel">
            <div class="carousel-indicators"> <button type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button> <button
                    type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                    aria-label="Slide 2"></button> <button type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide-to="2" aria-label="Slide 3"></button> </div>
            <div class="carousel-inner">
                <div class="carousel-item active"><a href="./views/PromoMM.html"> <img
                            src="../site/Imagens/Promo/bannerHome.png" class="d-block w-100 image"
                            alt="Pacote De Viagem"></a>
                    <div class="carousel-caption d-none d-md-block">
                    </div>
                </div>
                <div class="carousel-item"> <a href="./views/DestinoMM.html"> <img
                            src="../site/Imagens/Promo/bannerFim.png" class="d-block w-100 image"
                            alt="Banner Viagem por 1mil"></a>
                    <div class="carousel-caption d-none d-md-block">
                    </div>
                </div>
            </div>
            <div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide="prev"> <span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
                        class="visually-hidden">Anterior</span> </button> <button class="carousel-control-next"
                    type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next"> <span
                        class="carousel-control-next-icon" aria-hidden="true"></span> <span
                        class="visually-hidden">Próximo</span> </button>
            </div>
        </div>

        <br>
        <section class="text-center">
            <h2>Viaje pelo Brasil e descubra seus encantos.</h2>
            <h5>Uma seleção de pacotes que se encaixam no seu bolso.
            </h5>
        </section>
        <!--FIM - CAROUSEL-->
        <br><br>

        <!--OUTROS DESTINOS-->
        <div class="row">
            <div class="col-lg-4 col-md-6 col-sm-12">
                <img width="350vh" src="../site/Imagens/Promo/mocTrek.png">
                <a href="Reservas.html"><button class="button">Comprar</button></a>
            </div>
            <div class="col-lg-4 col-md-6 col-sm-12">
                <img width="350vh" src="../site/Imagens/Promo/sul.png">
                <a href="Reservas.html"><button class="button">Comprar</button></a>
            </div>
            <div class="col-lg-4 col-md-6 col-sm-12">
                <img width="350vh" src="../site/Imagens/Promo/viagemBarata.png">
                <a href="Reservas.html"><button class="button">Comprar</button></a>
            </div>
        </div>
        <!--OUTROS DESTINOS-->

        <br><br><br>
        <section class="text-center">
            <h2>Vai viajar sozinho ou acompanhado?</h2>
            <h5>Nós temos os melhores pacotes pra você mochilar pelo mundo. Se liga!
            </h5>
        </section>
        <br>

        <!--INÍCIO - CAROUSEL-->
        <br><br>
        <div alingn-itens="center" id="carouselExampleIndicators" size="100vh" class="carousel slide"
            data-bs-ride="carousel">
            <div class="carousel-indicators"> <button type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button> <button
                    type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                    aria-label="Slide 2"></button> <button type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide-to="2" aria-label="Slide 3"></button> </div>
            <div class="carousel-inner">
                <div class="carousel-item active"><a href="./views/DestinoMM.html"> <img
                            src="../site/Imagens/Promo/memoria.jfif" class="d-block w-100 image" alt=""></a>
                    <div class="carousel-caption d-none d-md-block">
                    </div>
                </div>
                <div class="carousel-item"> <a href="./views/DestinoMM.html"> <img
                            src="../site/Imagens/Promo/mochilar.jfif" class="d-block w-100 image" alt=""></a>
                    <div class="carousel-caption d-none d-md-block">
                    </div>
                </div>
            </div>
            <div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide="prev"> <span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
                        class="visually-hidden">Anterior</span> </button> <button class="carousel-control-next"
                    type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next"> <span
                        class="carousel-control-next-icon" aria-hidden="true"></span> <span
                        class="visually-hidden">Próximo</span> </button>
            </div>
        </div>
        <br><br>

        <section class="text-center">
            <h2>Pacotes perfeitos para quem quer fazer um mochilão e de quebra aprender um novo idioma.</h2>
            <h5>Conheça nossos pacotes de imersão na cultura local.
            </h5>
        </section>
        <!--FIM - CAROUSEL-->
        <br><br>

        <!--Cards notícias-->
        <div class="destinos">
            <div class="row">
                <div class="col-lg-4 col-md-6 col-sm-12">
                    <img width="350vh" src="../site/Imagens/Promo/dublin.png">
                    <p align="justify"> Dublin, capital da Irlanda, fica na costa oriental do país, na foz do Rio
                        Liffey,
                        que divide a
                        cidade em duas partes. Mais pacata e hospitaleira (e, de certa forma, não menos agitada) do que
                        Londres. Sua capital, Dublin, é berço de escritores como Oscar Wilde.
                    </p>
                    <a href="../site/views/Reservas.html"><button class="button">Comprar</button></a>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-12">
                    <img width="350vh" src="../site/Imagens/Promo/catalunha.png">
                    <p align="justify"> A Catalunha é uma comunidade autônoma espanhola, com o status oficial de
                        “nacionalidade”. O
                        território compreende quatro províncias: Barcelona, Girona, Lleida, e arragona.
                        Catalunha cobre uma área de cerca de 32.000 km² e tem uma população oficial de 7.535.251
                        habitantes.
                    </p>
                    <a href="../site/views/Reservas.html"><button class="button">Comprar</button></a>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-12">
                    <img width="350vh" src="../site/Imagens/Promo/eua.png"">
                    <p align=" justify"> Os EUA são um país com 50 estados que cobrem uma vasta faixa da América do
                    Norte,
                    com o Alasca ao
                    noroeste e o Havaí no Oceano Pacífico. As principais cidades da costa
                    atlântica são Nova York, um centro financeiro e cultural global, e a capital, Washington, DC.
                    </p>
                    <a href="../site/views/Reservas.html"><button class="button">Comprar</button></a>
                </div>
            </div>
        </div>
        <!--Cards notícias-->
    </main>
    </div>
    </div>
    <br><br><br><br>

    <!--NEWSLETTER-->
    <hr>
    <div align="center">
        <h3>Fala, mochileiro! Assine nossa newsletter e receba um e-book <br>
            com vários destinos para você escolher sua próxima viagem.</h3>
    </div>
    <div class="row">
        <div class="col" widht="30%">
            <input type="text" class="form-control" placeholder="Digite seu nome" aria-label="Digite seu nome">
        </div>
        <div class="col" widht="30%">
            <input type="email" class="form-control" placeholder="Seu email" aria-label="Digite seu email">
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-primary">Assinar</button>
        </div>
    </div>

    <div>
        <div align="center" font="arial" size="2">
            <p>*Concordo em receber ofertas e compartilhar meus dados com a agência Meu Mochilão</p>
        </div>
    </div>
    <hr>
    <!--NEWSLETTER-->

    <br><br>


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
        <hr>
        <div class="copy">
            <p align="center" color="grey">
                Agência Meu Mochilão S/A - CNPJ: 1056.5000.0001-92 - Rua Chico Mendes, Recife-PE
                <center>&copy; Agência Meu Mochilão - Todos os direitos reservados. </center>
            </p>
        </div>
    </footer>
    <!--FIM - RODAPÉ-->



    <!-- custom js file link  -->
    <script src="./js/script.js"></script>

    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
        integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
        integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
        crossorigin="anonymous"></script>
</body>

</html>