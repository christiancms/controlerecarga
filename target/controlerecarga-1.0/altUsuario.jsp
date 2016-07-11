<%-- 
    Document   : altUsuario
    Created on : 20/04/2016, 21:21:32
    Author     : christian
--%>
<%@ include file="titulo.jsp" %>
<%@ include file="menu.jsp" %>

<div class="col-sm-9">
    <form role="form" name="frmCadUsuario" action="UsuarioServlet?acao=salvar" method="POST" >
        <div class = "row">
            <div class = "col-sm-8">
                <h3><center> Alteração de Usuário </center></h3>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <br>
                    <button type="submit" class="btn btn-success"> Gravar </button>
                    <button type="reset" class="btn btn-warning"> Limpar </button>
                    <a href="UsuarioServlet?acao=listar"><button type="button" class="btn btn-danger"> Cancelar </button></a>
                </div>
            </div>
        </div>
        <!-- enctype="multipart/form-data"  permite ao formulários enviar arquivos -->

        <div class="col-sm-2">
            <div class="form-group">
                <label for="id"> Id:</label>
                <input type="text" class="form-control" id="id" name="id" readonly="true" value="${altUsr.idUsuario}"/>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="usuario">Usuário:</label>
                <input type="text" class="form-control" id="usuario" name="usuario" required="" value="${altUsr.nomeusuario}" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="senha">Senha:</label>
                <input type="password" class="form-control" id="senha" name="senha" required="" value="${altUsr.senha}" minlength="6" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="senha2">Senha Confirmação:</label>
                <input type="password" class="form-control" id="senha2" name="senha2" required="" minlength="6" />
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="datacadastro">Data Cadastro:</label>
                <input type="text" class="form-control" id="datacadastro" name="datacadastro" required="" value="<fmt:formatDate value="${altUsr.dataCadastro}" type="date" pattern="dd/MM/yyyy"/>" />
            </div>
        </div>

    </form>
</div>
</div>

<%@ include file="rodape.jsp" %>
