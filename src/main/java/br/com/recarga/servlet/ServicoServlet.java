package br.com.recarga.servlet;

import br.com.recarga.bean.OrdemServico;
import br.com.recarga.bean.Pessoa;
import br.com.recarga.dao.DAOPessoa;
import br.com.recarga.dao.DAOServico;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServicoServlet", urlPatterns = {"/ServicoServlet"})
public class ServicoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        Pessoa p = new Pessoa();
        DAOPessoa daopes = new DAOPessoa();
        DAOServico daoserv = new DAOServico();
        OrdemServico os = new OrdemServico();
        List<Pessoa> exbPes;
        List<OrdemServico> listaOs;

        if (request.getParameter("acao") != null) {
            String opcao = request.getParameter("acao");
            switch (opcao) {

                case "novo":
                    exbPes = daopes.listar();
                    request.setAttribute("exbPes", exbPes);
                    request.getRequestDispatcher("cadOrdServico.jsp")
                            .forward(request, response);
                    break;

                case "salvar":

                    if (request.getParameter("id") != null && !request.getParameter("id")
                            .equalsIgnoreCase("")) {
                        os.setIdOrdServico(Long.parseLong(request.getParameter("id")));
                    }
                    String codCliente = request.getParameter("cliente").trim();
                    String teste2[] = codCliente.split("-");
                    String aux = teste2[0];
                    Long codpes = Long.parseLong(aux.trim());
                    os.setEquipamento(request.getParameter("equipamento"));
                    os.setMarca(request.getParameter("marca"));
                    os.setAcessorios(request.getParameter("acessorios"));
                    os.setDefeito(request.getParameter("defeito"));
                    os.setPessoa(daopes.consultarPorId(codpes));
                    daoserv.salvar(os);
                    request.getRequestDispatcher("ServicoServlet?acao=listar").forward(request, response);
                    break;

                case "alterar":

                    break;

                case "encerrar":
                    request.getRequestDispatcher("fimOrdServico.jsp").forward(request, response);

                    break;

                case "listar":
                    listaOs = daoserv.listar();
                    request.setAttribute("listaOs", listaOs);
                    request.getRequestDispatcher("exbOs.jsp").forward(request, response);

                    break;

                case "ver":

                    request.getRequestDispatcher("exbOs.jsp").forward(request, response);

                    break;

            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ServicoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ServicoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
