<div class="col-sm-2">
    <h4 class="bg-primary text-center"> 
        Menu
    </h4>
    <ul class="nav navbar-sidebar">
        <div class="panel-group" id="accordion">
            <div class="panel panel-default">

                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">Cadastro</a>
                    </h4>
                </div>
                <div id="collapse1" class="panel-collapse collapsing">
                    <div class="panel-body">
                        <li><a href="ClienteServlet?acao=listar"> Clientes</a></li>
                        <li><a href="exbGrupo.jsp"> Grupo</a></li>
                        <li><a href="exbProduto.jsp"> Produtos</a></li>
                        <li><a href="UsuarioServlet?acao=listar"> Usuários</a></li>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">Financeiro</a>
                    </h4>
                </div>
                <div id="collapse2" class="panel-collapse collapsing">
                    <div class="panel-body">
                        <li><a href="exbContaPagar.jsp">Contas a Pagar</a></li>
                        <li><a href="exbContaReceber.jsp">Contas a Receber</a></li>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">Relatórios</a>
                    </h4>
                </div>
                <div id="collapse3" class="panel-collapse collapse">
                    <div class="panel-body">
                        <li><a href="relCliente.jsp"> Clientes</a></li>
                        <li><a href="relProduto.jsp"> Produtos</a></li>
                        <li><a href="relUsuario.jsp"> Usuários</a></li>
                        <li><a href="relContaPagar.jsp"> Contas a Pagar</a></li>
                        <li><a href="relContaReceber.jsp"> Contas a Receber</a></li>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse4">Ordem de Serviço</a>
                    </h4>
                </div>
                <div id="collapse4" class="panel-collapse collapse">
                    <div class="panel-body">
                        <li><a href="ServicoServlet?acao=novo"> Nova OS </a></li>
                        <li><a href="ServicoServlet?acao=listar"> Listar OS </a></li>
                        <li><a href="ServicoServlet?acao=encerrar"> Encerrar </a></li>

                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse5">Ajuda</a>
                    </h4>
                </div>
                <div id="collapse5" class="panel-collapse collapse">
                    <div class="panel-body">
                        <li><a href="SuporteServlet?acao=contato"> Suporte Técnico</a></li>
                    </div>
                    </ul>
                </div>


