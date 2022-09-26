<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	import="model.Cliente"
    import="model.Viagem"
    import="java.util.List"
%>

<%
@SuppressWarnings("unchecked")
List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
@SuppressWarnings("unchecked")
List<Viagem> viagem = (List<Viagem>) request.getAttribute("viagem");
%>

<!doctype html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reserva</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="../../css/style.css">

</head>

<body>
    <div class="main">
        <!--INÍCIO NAVBAR-->
        <nav class="navbar navbar-expand-lg navbar-light bg-warning">
            <div class="container-fluid">
                <a class="navbar-brand" href="../Index.html"><img width="250vh" src="../Imagens/Logo/LogoMM1.png"
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

        <br>
        <h2 color="black" align="center">Faça sua reserva e curta a experiência com o <b> Meu Mochilão</b>.</h2>
        <h6 color="black" align="center">Escolha seu destino e deixe o resto conosco!</h6>
        <br>

        <header class="tag">
            <h1 class="container">Cadastrar reserva</h1>
        </header>

        <div class="container py-3">
            <form action="./reserva-update">
                <fieldset>
                    <legend>Criar reserva
                    </legend>
                    <div class="form-group mb-3">
                        <label for="ida" class="form-label">
                            Dia da ida
                        </label>
                        <input type="text" id="ida" name="ida" class="form-control" placeholder="ida" value="" />
                    </div>
                    <div class="form-group mb-3">
                        <label for="volta" class="form-label">
                            Dia da volta
                        </label>
                        <input type="text" id="volta" name="volta" class="form-control" placeholder="volta" value="" />
                    </div>
                     <div class="form-group mb-3">
	                    <label for="cliente" class="form-label">
	                        Cliente
	                    </label>
	                    <select id="cliente" name="cliente" class="form-select">
	                        <option value="DEFAULT">Escolha um cliente</option>
	                        <% for (Cliente c: clientes) { %>
	                        <option value="<%=c.getId() %>"><%=c.getNome() %></option>
	                        <% } %>
                        </select>
                	</div>
                	
                	<div class="form-group mb-3">
	                    <label for="viagem" class="form-label">
	                        Viagem
	                    </label>
	                    <select id="viagem" name="viagem" class="form-select">
	                        <option value="DEFAULT">Escolha um viagem</option>
	                        <% for (Viagem v: viagem) { %>
	                        <option value="<%=v.getId() %>"><%=v.getDestino() %></option>
	                        <% } %>
                        </select>
                	</div>

                    <button type="submit" class="btn btn-primary">
                        Enviar
                    </button>
                    <a href="./reserva" class="btn btn-danger" style="margin-left: 10px">
                        Cancelar
                    </a>
                </fieldset>
            </form>
        </div>
</div>

        <!-- Bootstrap JavaScript Libraries -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"></script>
</body>

</html>