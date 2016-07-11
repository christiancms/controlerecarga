<%@ include file="titulo.jsp" %>
<%@ include file="menu.jsp" %>

<div class="col-sm-9">
    <h2> Inclusão de Produtos </h2>
    <!-- enctype="multipart/form-data"  permite ao formulários enviar arquivos -->
    <form role="form" method="post" action="" enctype="multipart/form-data">
        <div class="col-sm-12">
            <div class="form-group">
                <label for="descricao">Descrição:</label>
                <input type="text" class="form-control" id="descricao" name="descricao" required="">
            </div>
        </div>
        <div class="col-sm-6">
            <div class="form-group">
                <label for="marca">Marca:</label>
                <input type="text" class="form-control" id="marca" name="marca" required="">
            </div>
        </div>
        <div class="col-sm-6">
            <div class="form-group">
                <label for="preco">Preço:</label>
                <input type="text" class="form-control" id="preco" name="preco" required="">
            </div>
        </div>
        <div class="col-sm-12">
            <div class="form-group">
                <label for="imagem">Imagem do Produto:</label>
                <input type="file" class="form-control" id="imagem" name="imagem" required>
            </div>
        </div>
        <div class="col-sm-12">
            <div class="form-group">
                <button type="submit" class="btn btn-success"> Enviar </button>
                <button type="reset" class="btn btn-warning"> Limpar </button>
                <a href="cad_produtos.jsp"><button type="" class="btn btn-danger"> Cancelar </button></a>
            </div>
        </div>
    </form>
</div>
</div>

<%@ include file="rodape.jsp" %>
