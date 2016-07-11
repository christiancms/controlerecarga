<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${empty sessionScope.usrSessao}">
    <c:redirect url="login.jsp"/>
</c:if>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Controle de Recarga</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Local -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/estilo.css" rel="stylesheet">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/myScript.js"></script>
        <script src="js/validator.js"></script>
        <!-- Remote -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row bg-primary">
                <div class="col-sm-3">
                    <h2>Suprimentos<a href="principal.jsp">!</a>!</h2>
                </div>
                <form name="frmBuscar" action="BuscarServlet" method="POST" >
                    <div class="col-sm-7">
                        <div class="input-group h2">
                            <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar">
                            <span class="input-group-btn">
                                <button class="btn btn-primary" type="submit">
                                    <span class="glyphicon glyphicon-search">
                                    </span>
                                </button>
                            </span>
                        </div>
                        <h6>
                            <label class="radio-inline"><input type="radio" name="buscar" value="cliente" >Cliente</label>
                            <label class="radio-inline"><input type="radio" name="buscar" value="menu" >Menu</label>
                            <label class="radio-inline"><input type="radio" name="buscar" value="usuario" >Usuário</label>
                        </h6>
                    </div>
                </form>
                <div class="col-sm-2">
                    <h6> &nbsp;</h6>
                    <h6>
                        Usuário:<strong> <c:out value="${sessionScope.usrSessao}" >
                            </c:out></strong>
                        <a href="login.jsp" class="btn btn-danger btn-xs" role="button"> SAIR </a></h6>
                </div>      
            </div>