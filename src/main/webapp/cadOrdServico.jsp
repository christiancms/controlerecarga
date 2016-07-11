<%@ include file="titulo.jsp" %>
<%@ include file="menu.jsp" %>
<jsp:useBean id="agora" class="java.util.Date" />



<div class="col-sm-9">
    <h3> Abertura de OS </h3>
    <!-- enctype="multipart/form-data"  permite ao formulários enviar arquivos -->
    <form role="formCadOrdemServico" method="post" action="ServicoServlet?acao=salvar" >
        <div class="col-sm-1">
            <div class="form-group">
                <label for="idOrdemServico"> OS:</label>
                <input type="text" class="form-control" id="idOrdemServico" name="idOrdemServico" readonly="true" />
            </div>
        </div>
        <div class="col-sm-8">
            <div class="form-group">
                <label for="cliente">Cliente:</label>
                <!--<input type="text" class="form-control" id="osCliente" name="osCliente" required="">-->
                <select class="form-control" id="cliente" name="cliente">
                    <c:forEach var="exibePes" items="${exbPes}">
                        <option>${exibePes.idPessoa} - ${exibePes.nomeRazsoc}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="usuario">Usuário:</label>
                <input type="text" class="form-control" id="usuario" name="usuario" readonly="true" value="${sessionScope.usrSessao}" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="equipamento">Equipamento:</label>
                <input type="text" class="form-control" id="equipamento" name="equipamento" required="true">
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="marca">Marca:</label>
                <input type="text" class="form-control" id="marca" name="marca" />
            </div>
        </div>
        <div class="col-sm-6">
            <div class="form-group">
                <label for="acessorios">Acessórios:</label>
                <input type="text" class="form-control" id="acessorios" name="acessorios" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="dtentrada">Data Entrada:</label>
                <input type="date" class="form-control" id="dtentrada" name="dtentrada" value="<fmt:formatDate value="${agora}" type="both" pattern="dd/MM/yyyy"/>" />
            </div>
        </div>
        <div class="col-sm-12">
            <div class="form-group">
                <label for="defeito">Defeito:</label>
                <textarea class="form-control" rows="5" id="defeito" name="defeito"></textarea>
            </div>
        </div>
        <div class="col-sm-12">
            <div class="form-group">
                <button type="submit" class="btn btn-success"> Gravar </button>
                <button type="reset" class="btn btn-warning"> Limpar </button>
                <a href="exbCliente.jsp"><button type="" class="btn btn-danger"> Cancelar </button></a>
            </div>
        </div>
    </form>
</div>
</div>




<%@ include file="rodape.jsp" %>
