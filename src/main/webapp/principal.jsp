<%@ include file="titulo.jsp" %>
<%@ include file="menu.jsp" %>
<jsp:useBean id="agora" class="java.util.Date" />

<div class="col-sm-9">
    <h5><fmt:formatDate value="${agora}" type="both" pattern="dd/MM/yyyy HH:mm:ss"/><br>
        Selecione uma opção no menu para iniciar.<br>
    </h5>
        <ul>
            <li><a href="UsuarioServlet?acao=novo">Registrar User</a></li>
            <li><a href="ClienteServlet?acao=novo">Registrar Cliente</a></li>
            <li><c:set var="browser" value="${header['User-Agent']}" scope="session"/>
                <c:out value="${browser}"/>
            </li>
        </ul>
</div>
</div>

<%@ include file="rodape.jsp" %>