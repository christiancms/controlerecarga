<%@ include file="titulo.jsp" %>
<%@ include file="menu.jsp" %>

<div class="col-sm-9">
    <form role="form" name="frmCadEndereco" method="post" action="EnderecoServlet?acao=salvar" >
        <div class = "row">
            <div class = "col-sm-8">
                <h3><center> Inclusão de Endereço do Cliente </center></h3>
            </div>

            <div class="col-sm-4">
                <div class="form-group">
                    <br>
                    <button type="submit" class="btn btn-success"> Gravar </button>
                    <button type="reset" class="btn btn-warning"> Limpar </button>
                    <a href="ClienteServlet?acao=listar"><button type="button" class="btn btn-danger"> Cancelar </button></a>
                </div>
            </div>
        </div>
        <!-- enctype="multipart/form-data"  permite ao formulários enviar arquivos -->

        <div class="col-sm-1">
            <div class="form-group">
                <label for="idcliente"> C.Cli:</label>
                <input type="text" class="form-control" id="idcliente" name="idcliente" value="${codPes}" readonly="true"/>
            </div>
        </div>
        <div class="col-sm-1">
            <div class="form-group">
                <label for="id"> Cod:</label>
                <input type="text" class="form-control" id="id" name="id" readonly="true"/>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="cep">CEP:</label>
                <input type="text" class="form-control" id="cep" name="cep" />
            </div>
        </div>
        <div class="col-sm-6">
            <div class="form-group">
                <label for="logradouro">Logradouro:</label>
                <input type="text" class="form-control" id="logradouro" name="logradouro" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="numero">Número:</label>
                <input type="numero" class="form-control" id="numero" name="numero" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="complemento">Complemento:</label>
                <input type="text" class="form-control" id="complemento" name="complemento" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="bairro">Bairro:</label>
                <input type="text" class="form-control" id="bairro" name="bairro" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="cidade">Cidade:</label>
                <input type="text" class="form-control" id="cidade" name="cidade" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="uf">UF:</label>
                <select class="form-control" id="uf" name="uf">
                    <option>RS</option>
                </select>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="pais">País:</label>
                <input type="text" class="form-control" id="pais" name="pais" />
            </div>
        </div>

    </form>

</div>
</div>

<%@ include file="rodape.jsp" %>
