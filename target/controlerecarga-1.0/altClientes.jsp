<%@ include file="titulo.jsp" %>
<%@ include file="menu.jsp" %>

<div class="col-sm-9">
    <div class = "row">
        <div class = "col-sm-8">
            <h3><center> Alteração de Cliente </center></h3>
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
                <input type="text" class="form-control" id="nome" name="nome" value="${altPes.nomeRazsoc}" required="true" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="sobrenome">Sobrenome:</label>
                <input type="text" class="form-control" id="sobrenome" name="sobrenome" value="${altPes.sobrenomeFantasia}" required="true" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="aniver">Aniversário:</label>
                <input type="text" class="form-control" id="aniver" name="aniver" value="${ddmmaa}"/>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="telefone">Telefone:</label>
                <input type="text" class="form-control" id="telefone" name="telefone" maxlength="10" value="${altPes.telefone}" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="celular">Celular:</label>
                <input type="text" class="form-control" id="celular" name="celular" maxlength="10" value="${altPes.celular}" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" value="${altPes.email}" />
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
                <input type="text" onfocusout="" class="form-control" id="cpf" name="cpf" required="false" value="${altPes.fisicaJuridica}" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="docrg"> RG:</label>
                <input type="text" class="form-control" id="docrg" name="docrg" required="false" value="${altPes.docrgInsest}"/>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="form-group">
                <label for="observacao">Observação:</label>
                <textarea class="form-control" rows="5" id="observacao" name="observacao">${altPes.observacao}</textarea>
            </div>
        </div>
    </form>
</div>
</div>

<%@ include file="rodape.jsp" %>
