<%-- 
    Document   : inserir
    Created on : 03/04/2016, 21:46:13
    Author     : christian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="ServletUsuarioBeanInserir" method="POST">
                <label for="txtLogin">Login:</label>
                <input type="text" id="txtLogin" name="txtLogin" required="true">
                <label for="txtSenha">Senha:</label>
                <input type="password" id="txtSenha" name="txtSenha" required="true">
                <label for="dataCad">Data:</label>
                <input type="date" id="dataCad" name="dataCad" required="">
                
                <input type="submit" value="Registrar" />
        </form>
    </body>
</html>
