<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
     import="model.Viagem"
    import="java.util.List"
    %>
<%
@SuppressWarnings("unchecked")
List<Viagem> viagem = (List<Viagem>) request.getAttribute("viagem");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pacotes</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="../../css/style.css">

</head>
<body>
    <div class="main">
       <!--IN�CIO NAVBAR-->
    <nav class="navbar navbar-expand-lg navbar-light bg-warning">
        <div class="container-fluid">
          <a class="navbar-brand" href="../Index.html"><img width="250vh"
            src="../Imagens/Logo/LogoMM1.png" alt="Logomarca Meu Mochil�o"></a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link" href="./DestinoMM.html">Nossos destinos</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="./PromoMM.html">Nossas promo��es</a>
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
        <header class="tag">
            <h1 class="container">Viagens</h1>
        </header>
        <div class="container py-3">
            <a href="./Viagem.html" class="btn btn-primary mb-2">
                Criar Pacote
            </a>
            <div class="table-responsive">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Destino</th>
                            <th>Pacote</th>
                            <th>Valor_pacote</th>
                        </tr>
                    </thead>
                    <tbody>
                    
                    
                    <% for (Viagem v: viagem) { %>
                    	<tr>
                    		<tr>
	                        <td><%=v.getId() %></td>
	                        <td><%=v.getDestino() %></td>
	                        <td><%=v.getPacote() %></td>
	                        <td><%=v.getValor_pacote() %></td>
	                        <td class="d-flex">
                        	<a href="./viagem-edit?id=<%=v.getId() %>" class="btn btn-info">
                                    Editar
                                </a>
                                <button href="./viagem-delet?id=<%=v.getId() %>" class="btn btn-danger" style="margin-left: 10px;">
                                    Deletar
                                </button>
                            </td>
                        </tr>
                      <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
     <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"></script>
  </body>
</body>
</html>