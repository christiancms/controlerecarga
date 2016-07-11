<%@ include file="titulo.jsp" %>
<%@ include file="menu.jsp" %>



<div class="col-sm-9">
    <h3> Encerrar OS </h3>
    <!-- enctype="multipart/form-data"  permite ao formulários enviar arquivos -->
    <form role="form" method="post" action="" enctype="multipart/form-data">
        <div class="col-sm-1">
            <div class="form-group">
                <label for=""> OS:</label>
                <input type="text" class="form-control" id="" name="" required="false" readonly="true"/>
            </div>
        </div>

        <div class="col-sm-8">
            <div class="form-group">
                <label for="nome">Nome:</label>
                <input type="text" class="form-control" id="nome" name="nome" required="true">
            </div>
        </div>

        <div class="col-sm-3">
            <div class="form-group">
                <label for="">Usuário:</label>
                <input type="text" class="form-control" id="contato" name="contato" required="">
            </div>
        </div>

        <div class="col-sm-3">
            <div class="form-group has-feedback">
                <label for="celular">Celular:</label>
                <input type="text" class="form-control" id="celular" name="celular" maxlength="10" />
                <i class="glyphicon glyphicon-plus form-control-feedback" ></i>
            </div>
        </div>


        <div class="col-sm-3">
            <div class="form-group has-feedback">
                <label for="telefone">Telefone:</label>
                <input type="text" class="form-control" id="telefone" name="telefone" maxlength="10" />
                <i class="glyphicon glyphicon-plus form-control-feedback" ></i>
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
                <label for="">Equipamento:</label>
                <input type="text" class="form-control" id="aniversario" name="aniversario" required="">
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <label for="">Marca:</label>
                <input type="text" class="form-control" id="contato" name="contato" required="">
            </div>
        </div>

        <div class="col-sm-6">
            <div class="form-group">
                <label for="">Acessórios:</label>
                <input type="text" class="form-control" id="contato" name="contato" required="">
            </div>
        </div>

        <div class="col-sm-3">
            <div class="form-group">
                <label for="">Data Saída:</label>
                <input type="date" class="form-control" id="contato" name="contato" required="">
            </div>
        </div>
        
        <div class="col-sm-3">
            <div class="form-group">
                <label for="">Valor Serviço:</label>
                <input type="date" class="form-control" id="contato" name="contato" required="">
            </div>
        </div>
        
        
        <div class="col-sm-3">
            <div class="form-group">
                <label for="">Valor Peças:</label>
                <input type="date" class="form-control" id="contato" name="contato" required="">
            </div>
        </div>
        
        <div class="col-sm-3">
            <div class="form-group">
                <label for="">Valor Total:</label>
                <input type="date" class="form-control" id="contato" name="contato" required="">
            </div>
        </div>
        
        
        
        


        <div class="col-sm-12">
            <div class="form-group">
                <label for="observacao">Defeito Relatado:</label>
                <textarea class="form-control" rows="5" id="observacao" name=""></textarea>
            </div>
        </div>
        
        <div class="col-sm-12">
            <div class="form-group">
                <label for="observacao">Observações:</label>
                <textarea class="form-control" rows="5" id="observacao" name=""></textarea>
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




<%@ include file="rodape.jsp" %>
