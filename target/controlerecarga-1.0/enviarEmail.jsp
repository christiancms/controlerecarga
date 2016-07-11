<%@ include file="titulo.jsp" %>
<%@ include file="menu.jsp" %>

<div class="col-sm-9">
    <h3><center> Relatar Problema </center></h3>
    <!-- enctype="multipart/form-data"  permite ao formulários enviar arquivos -->
    <form action="MailApp" method="post">
        <div class="col-sm-12">
            <div class="form-group">
                <label for="to">  Para:</label>
                <input type="text" name="to" class="form-control" id="to" name="to" />
            </div>
        </div>
        <div class="col-sm-12">
            <div class="form-group">
                <label for="subject"> Assunto:</label>
                <input type="text" name="subject"  class="form-control" id="subject" name="subject" />
            </div>
        </div>
        <div class="col-sm-12">
            <div class="form-group">
                <label for="message">Mensagem:</label>
                <textarea class="form-control" rows="5" id="message" name="message"></textarea>
            </div>
        </div>
        <div class="col-sm-12">
            <div class="form-group">
                <label for="pass">Senha:</label>
                <input type="password" name="pass" class="form-control" id="pass"  />
            </div>
        </div>
        <!--Mensagem:<input type="text" name="message"  /><br/>
        Your Email id:<input type="text" name="user" ><br/>
        Password:<input type="password" name="pass"   /><br/>-->
        <div class="col-sm-12">
            <div class="form-group">
                <input type="submit" value="Enviar" />
            </div>
        </div>
    </form>
</div>
</div>

<%@ include file="rodape.jsp" %>
