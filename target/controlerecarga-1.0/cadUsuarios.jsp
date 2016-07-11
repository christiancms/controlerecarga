<%@ include file="titulo.jsp" %>
<%@ include file="menu.jsp" %>
<jsp:useBean id="agora" class="java.util.Date" />

<div class="col-sm-9">
    <h3><center> Inclusão de Usuários </center></h3>
    <!-- enctype="multipart/form-data"  permite ao formulários enviar arquivos -->
    <form data-toggle="validator" role="form" name="frmCadUsuario" action="UsuarioServlet?acao=salvar" method="POST" >
        <div class="col-sm-2">
            <div class="form-group">
                <label for="id"> Id:</label>
                <input type="text" class="form-control" id="id" name="id" readonly="true" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="usuario">Usuário:</label>
                <input type="text" class="form-control" id="usuario" name="usuario" required="true" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="senha">Senha:</label>
                <input type="password" class="form-control" id="senha" name="senha" placeholder="Mínimo de 6 caracteres" required="true" minlength="6" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="senha2">Senha Confirmação:</label>
                <input type="password" class="form-control" id="senha2" data-match="#senha" data-match-error="Senhas diferentes" name="senha2" required="true" minlength="6" />
                <div class="help-block with-errors"></div>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="datacadastro">Data Cadastro:</label>
                <input type="date" class="form-control" id="datacadastro" name="datacadastro" value="<fmt:formatDate value="${agora}" type="both" pattern="dd/MM/yyyy"/>"/>
            </div>
        </div>
        <div class="col-sm-12">
            <div class="form-group">
                <button type="submit" class="btn btn-success"> Gravar </button>
                <button type="reset" class="btn btn-warning"> Limpar </button>
                <a href="UsuarioServlet"><button type=button class="btn btn-danger"> Cancelar </button></a>
            </div>
        </div>
    </form>
</div>
</div>

<%@ include file="rodape.jsp" %>
