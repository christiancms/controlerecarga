<%@ include file="titulo.jsp" %>
<%@ include file="menu.jsp" %>

<div class = "col-sm-9">
    <div class = "row">
        <div class = "col-sm-10">
            <h3><center> Cadastro de Usuários </center></h3>
        </div>
        <div class = "col-sm-2">
            <h2>
                <a href="UsuarioServlet?acao=novo" class="btn btn-info btn-block" role="button"> Novo </a>
            </h2>
        </div>
        <div class="col-sm-12">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th> Código </th>
                        <th> Nome </th>
                        <th> Data Cadastro </th>
                        <th> Senha </th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="exibeUsr" items="${exbUsr}">
                        <tr><td> ${exibeUsr.idUsuario} </td>
                            <td> ${exibeUsr.nomeusuario} </td>
                            <td> <fmt:formatDate value="${exibeUsr.dataCadastro}" pattern="dd/MM/yyyy"/></td>
                            <td> ${exibeUsr.senha} </td>
                            <td><a href="UsuarioServlet?acao=alterar&id=${exibeUsr.idUsuario}" class="btn btn-warning" role="button"> Alterar </a>
                                <a href="UsuarioServlet?acao=excluir&id=${exibeUsr.idUsuario}" onclick="return confirm('Confirma Exclusão de: ${exibeUsr.nomeusuario}')" 
                                   class="btn btn-danger" role="button"> Excluir </a>


                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</div>

<%@ include file="rodape.jsp" %>