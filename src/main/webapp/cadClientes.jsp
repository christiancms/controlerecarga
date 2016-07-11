<%@ include file="titulo.jsp" %>
<%@ include file="menu.jsp" %>

<div class="col-sm-9">
    <form role="form" name="frmCadCliente" method="post" action="ClienteServlet?acao=salvar" >
        <div class = "row">
            <div class = "col-sm-8">
                <h3><center> Inclusão de Cliente </center></h3>
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
                <label for="id"> Id:</label>
                <element ng-blur="expression">
                    <input type="text" class="form-control" id="id" name="id" />
                </element>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="nome">Nome:</label>
                <input type="text" class="form-control" id="nome" name="nome" required="true" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="sobrenome">Sobrenome:</label>
                <input type="text" class="form-control" id="sobrenome" name="sobrenome" required="false" />
            </div>
        </div>

        <div class="col-sm-3">
            <div class="form-group">
                <label for="aniver">Aniversário:</label>
                <input type="date" class="form-control" id="aniver" name="aniver" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="telefone">Telefone:</label>
                <input type="text" class="form-control" id="telefone" name="telefone" maxlength="10" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="celular">Celular:</label>
                <input type="text" class="form-control" id="celular" name="celular" maxlength="10" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="pessoa">Pessoa:</label>
                <select class="form-control" id="pessoa" name="pessoa">
                    <option> Física </option>
                    <option> Jurídica </option>
                </select>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="cpf">CPF:</label>
                <input type="text" onfocusout="" class="form-control" id="cpf" name="cpf" required="false" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="docrg"> RG:</label>
                <input type="text" class="form-control" id="docrg" name="docrg" required="false" />
            </div>
        </div>
        <div class="col-sm-6">
            <div class="form-group">
                <label for="observacao">Observação:</label>
                <textarea class="form-control" rows="5" id="observacao" name="observacao"></textarea>
            </div>
        </div>

    </form>

</div>
</div>

<script>
function focusFunction() {
    // Focus = Changes the background color of input to yellow
    document.getElementById("myInput").style.background = "yellow";
}

function blurFunction() {
    // Lost focus = Changes the background color of input to red
    document.getElementById("myInput").style.background = "red";
}
</script>
<%@ include file="rodape.jsp" %>
