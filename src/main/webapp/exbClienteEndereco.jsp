<%@ include file="titulo.jsp" %>
<%@ include file="menu.jsp" %>

<div class = "col-sm-9">
    <div class = "row">
        <div class = "col-sm-8">
            <h3><center> Exibe Cliente </center></h3>
        </div>
        <div class = "col-sm-4">
            <div class="form-group">
                <br>
                <button type="submit" class="btn btn-success"> Gravar </button>
                <button type="reset" class="btn btn-warning"> Limpar </button>
                <a href="ClienteServlet?acao=listar"><button type="button" class="btn btn-danger"> Cancelar </button></a>
            </div>
        </div>
    </div>
    <!-- enctype="multipart/form-data"  permite ao formulários enviar arquivos -->
    <form role="form" name="frmCadCliente" method="post" action="ClienteServlet?acao=salvar" >
        <div class="col-sm-1">
            <div class="form-group">
                <label for="id"> Id:</label>
                <input type="text" class="form-control" id="id" name="id" value="${altPes.idPessoa}" readonly="true"/>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="nome">Nome:</label>
                <input type="text" class="form-control" id="nome" name="nome" value="${altPes.nomeRazsoc}" readonly="true" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="sobrenome">Sobrenome:</label>
                <input type="text" class="form-control" id="sobrenome" name="sobrenome" value="${altPes.sobrenomeFantasia}" readonly="true" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="aniver">Aniversário:</label>
                <fmt:formatDate var="aniversario" value="${altPes.aniverAbertura}" pattern="yyyy/MM/dd"/>
                <input type="text" class="form-control" id="aniver" name="aniver" value="${aniversario}" readonly="true"/>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="telefone">Telefone:</label>
                <input type="text" class="form-control" id="telefone" name="telefone" maxlength="10" value="${altPes.telefone}" readonly="true"/>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="celular">Celular:</label>
                <input type="text" class="form-control" id="celular" name="celular" maxlength="10" value="${altPes.celular}" readonly="true"/>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" value="${altPes.email}" readonly="true"/>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="pessoa">Pessoa:</label>
                <c:set var="tppes" value="${altPes.tipoPessoa}" />
                <c:choose>
                    <c:when test="${tppes == 'f'}">
                        <input type="text" class="form-control" id="pessoa" name="pessoa" value="Física" readonly="true"/>
                    </c:when>
                    <c:otherwise>
                        <input type="text" class="form-control" id="pessoa" name="pessoa" value="Jurídica" readonly="true"/>
                    </c:otherwise>
                </c:choose> 
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="cpf">CPF:</label>
                <input type="text" onfocusout="" class="form-control" id="cpf" name="cpf" required="false" value="${altPes.fisicaJuridica}" readonly="true"/>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="docrg"> RG:</label>
                <input type="text" class="form-control" id="docrg" name="docrg" required="false" value="${altPes.docrgInsest}" readonly="true"/>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="form-group">
                <label for="observacao">Observação:</label>
                <textarea class="form-control" rows="5" id="observacao" name="observacao" readonly="true">${altPes.observacao}</textarea>
            </div>
        </div>
    </form>
    <hr>
    <div class="col-sm-12">
        <table class="table-condensed">
            <thead>
                <tr>
                    <th>Cod</th>
                    <th>Cep</th>
                    <th>Logradouro</th>
                    <th>Bairro</th>
                    <th>Cidade</th>
                    <th>UF</th>
                    <th>País</th>
                    <th><a href="EnderecoServlet?acao=novo&id=${altPes.idPessoa}" class="btn btn-info" role="button"> Novo </a></th>
                </tr>
            </thead>
            <c:forEach var="exibePes" items="${exbPes.enderecos}">
                <tbody>
                    <tr>
                        <td>
                            <a href="" class="btn btn-default btn-block" role="button">${exibePes.idEndereco}</a>
                        </td>
                        <td>
                            <a href="" class="btn btn-default btn-block" role="button">${exibePes.cep}</a>
                        </td>
                        <td>
                            <a href="" class="btn btn-default btn-block" role="button">${exibePes.logradouro}, ${exibePes.numero} - ${exibePes.complemento}</a>
                        </td>
                        <td>
                            <a href="" class="btn btn-default btn-block" role="button">${exibePes.bairro}</a>
                        </td>
                        <td>
                            <a href="" class="btn btn-default btn-block" role="button">${exibePes.municipio}</a>
                        </td>
                        <td>
                            <a href="" class="btn btn-default btn-block" role="button">${exibePes.unidFed} </a>
                        </td>
                        <td>
                            <a href="" class="btn btn-default btn-block" role="button">${exibePes.pais}</a>
                        </td>

                        <td><a href="EnderecoServlet?acao=alterar&id=${exibePes.idEndereco}" class="btn btn-warning" role="button"> Alterar </a>
                            <a href="EnderecoServlet?acao=excluir&id=${exibePes.idEndereco}" onclick="return confirm(\'Confirma Exclusão de: ${exibePes}')" 
                               class="btn btn-danger" role="button"> Excluir </a>
                        </td>
                    </tr>
                </tbody>
            </c:forEach>
        </table>
    </div> 



</div>
</div>

<%@ include file="rodape.jsp" %>