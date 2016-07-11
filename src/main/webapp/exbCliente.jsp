<%@ include file="titulo.jsp" %>
<%@ include file="menu.jsp" %>

<div class = "col-sm-9">
    <div class = "row">
        <div class = "col-sm-9">
            <h3><center> Cadastro de Clientes </center></h3>
        </div>
        <div class = "col-sm-3">
            &nbsp;<br>
            <a href="ClienteServlet?acao=novo" class="btn btn-info" role="button"> Novo </a>&nbsp;<a href="prtClientes.jsp" class="btn btn-default " role="button"> Imprimir </a>
        </div>

        <div class="col-sm-12">
            <table class="table-condensed">
                <thead>
                    <tr>
                        <th>Cod</th>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Telefone</th>
                        <th>Celular</th>

                    </tr>
                </thead>
                <c:forEach var="exibePes" items="${exbPes}">
                    <tbody>
                        <tr>
                            <td>
                                <a href="ClienteServlet?acao=ver&id=${exibePes.idPessoa}" class="btn btn-default btn-block" role="button">
                                    ${exibePes.idPessoa} 
                                </a>
                            <td>
                                <a href="ClienteServlet?acao=ver&id=${exibePes.idPessoa}" class="btn btn-default btn-block" role="button">
                                    ${exibePes.nomeRazsoc} ${exibePes.sobrenomeFantasia} 
                                </a>
                            </td>
                            <td>
                                <a href="ClienteServlet?acao=ver&id=${exibePes.idPessoa}" class="btn btn-default btn-block" role="button">
                                    ${exibePes.email} 
                                </a>
                            </td>
                            <td>
                                <a href="ClienteServlet?acao=ver&id=${exibePes.idPessoa}" class="btn btn-default btn-block" role="button">
                                    ${exibePes.telefone} 
                                </a>
                            </td>
                            <td>
                                <a href="ClienteServlet?acao=ver&id=${exibePes.idPessoa}" class="btn btn-default btn-block" role="button">
                                    ${exibePes.celular} 
                                </a>
                            </td>

                            <td><a href="ClienteServlet?acao=alterar&id=${exibePes.idPessoa}" class="btn btn-warning" role="button"> Alterar </a>
                                <a href="ClienteServlet?acao=excluir&id=${exibePes.idPessoa}" onclick="return confirm(\'Confirma Exclusão de: ${exibePes.nomeRazsoc}')" 
                                   class="btn btn-danger" role="button"> Excluir </a>
                            </td>
                        </tr>
                    </tbody>
                </c:forEach>
            </table>&emsp;
        </div> 
    </div>
</div>

</div>
</div>

<%@ include file="rodape.jsp" %>