<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- <link rel="icon" href="../../favicon.ico"> -->

        <title> Controle de Recarga - Login </title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/login.css" rel="stylesheet">
    </head>

    <body>

        <div class="container">

            <form class="form-signin" name="frmLogin" action="Autenticacao" method="POST">
                <center><h2 class="form-signin-heading"> Acesso Restrito </h2></center>
                <label for="inputEmail" class="sr-only">Usuário </label>
                <input type="text" name="usrNome" class="form-control" placeholder="Usuário" required autofocus>
                &nbsp;
                <label for="inputPassword" class="sr-only"> Senha </label>
                <input type="password" name="usrSenha" id="inputPassword" class="form-control" placeholder="Senha" required>
                <p class="text-danger">
                    <c:if test="${not empty erro}">${erro}</c:if>
                    </p>
                    <button class="btn btn-lg btn-primary btn-block" type="submit"> Entrar </button>
                </form>
            </div> <!-- /container -->
        <center>
        <c:out value="${ip}" />
    </center>
</body>
</html>
