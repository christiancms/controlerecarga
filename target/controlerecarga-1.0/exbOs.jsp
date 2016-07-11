<%@ include file="titulo.jsp" %>
<%@ include file="menu.jsp" %>

<div class = "col-sm-9">
    <div class = "row">
        <div class = "col-sm-9">
            <h3><center> Lista de Ordem de Serviço </center></h3>
        </div>
        

        <div class="col-sm-12">
            <table class="table-condensed">
                <thead>
                    <tr>
                        <th>Cod</th>
                        <th>Nome</th>
                        <th>Equipamento</th>
                        <th>Marca</th>
                        <th>Defeito</th>

                    </tr>
                </thead>
                <c:forEach var="listagem" items="${listaOs}">
                    <tbody>
                        <tr>
                            <td>
                                <a href="ServicoServlet?acao=ver&id=${listagem.idOrdServico}" class="btn btn-default btn-block" role="button">
                                ${listagem.idOrdServico}
                                </a>
                            <td>
                                <a href="ServicoServlet?acao=ver&id=${listagem.idOrdServico}" class="btn btn-default btn-block" role="button">
                                    ${listagem.pessoa.nomeRazsoc} 
                                </a>
                            </td>
                            <td>
                                <a href="ServicoServlet?acao=ver&id=${listagem.idOrdServico}" class="btn btn-default btn-block" role="button">
                                    ${listagem.equipamento} 
                                </a>
                            </td>
                            <td>
                                <a href="ServicoServlet?acao=ver&id=${listagem.idOrdServico}" class="btn btn-default btn-block" role="button">
                                    ${listagem.marca} 
                                </a>
                            </td>
                            <td>
                                <a href="ServicoServlet?acao=ver&id=${listagem.idOrdServico}" class="btn btn-default btn-block" role="button">
                                    ${listagem.defeito} 
                                </a>
                            </td>

                            <td><a href="ClienteServlet?acao=alterar&id=${listagem.idOrdServico}" class="btn btn-warning" role="button"> Alterar </a>
                                <a href="ClienteServlet?acao=excluir&id=${listagem.idOrdServico}" onclick="return confirm(\'Confirma Exclusão de: ${listagem.idOrdServico}')" 
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