<%@ include file="titulo.jsp" %>
<%@ include file="menu.jsp" %>

<div class = "col-sm-9">
    <div class = "row">
        <div class = "col-sm-10">
            <h2> Cadastro de Produtos </h2>
        </div>
        <div class = "col-sm-2">
            <h2>
                <a href="cadProdutos.jsp" class="btn btn-info btn-block" role="button"> Novo </a>
            </h2>
        </div>
        <div class="col-sm-12">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th> Código </th>
                        <th> Descrição do Produto </th>
                        <th> Marca </th>
                        <th> Preço </th>
                        <th> Imagem </th>
                        <th> Ações </th>
                    </tr>
                </thead>
                <tbody>
                    <tr><td> [id] </td>
                        <td> [descricao] </td>
                        <td> [marca] </td>
                        <td> [preco] </td>
                        <td><img src="" style="width: 80px; height: 100px;"></td>
                        <td><a href="" class="btn btn-warning" role="button"> Alterar </a>
                            <a href="" onclick="return confirm(\'Confirma Exclusão')" class="btn btn-danger" role="button"> Excluir </a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</div>

<%@ include file="rodape.jsp" %>