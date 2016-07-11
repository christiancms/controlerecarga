package br.com.recarga.servlet;

import br.com.recarga.bean.Endereco;
import br.com.recarga.bean.Pessoa;
import br.com.recarga.dao.DAOEndereco;
import br.com.recarga.dao.DAOPessoa;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author christian
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        Pessoa p = new Pessoa();
        DAOPessoa daopes = new DAOPessoa();
        DAOEndereco daoend = new DAOEndereco();
        Long idPes;
        String id, idpes;
        Pessoa altPes;
        List<Endereco> exbEnd;
        List<Pessoa> exbPes;

        if (request.getParameter("acao") != null) {
            String opcao = request.getParameter("acao");
            switch (opcao) {
                case "novo":

                    request.getRequestDispatcher("cadClientes.jsp").forward(request, response);
                    break;
                case "salvar":

                    if (request.getParameter("id") != null && !request.getParameter("id")
                            .equalsIgnoreCase("")) {
                        p.setIdPessoa(Long.parseLong(request.getParameter("id")));
                    }
                    p.setTipoPessoa(request.getParameter("nome").equals("Física") ? "f" : "j"); // Física ou Jurídica
                    p.setNomeRazsoc(request.getParameter("nome"));
                    p.setSobrenomeFantasia(request.getParameter("sobrenome"));
                    p.setTelefone(request.getParameter("telefone"));
                    p.setCelular(request.getParameter("celular"));
                    p.setEmail(request.getParameter("email"));
                    p.setFisicaJuridica(request.getParameter("cpf"));
                    p.setDocrgInsest(request.getParameter("docrg"));
                    p.setObservacao(request.getParameter("observacao"));
                    p.setCategoria("c"); // Cliente, Fornecedor, Transportadora, Outros
                    if (request.getParameter("aniver") != null) {
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            Date dataAniver = sdf.parse(request.getParameter("aniver"));
                            p.setAniverAbertura(dataAniver);

                        } catch (ParseException e) {
                            e.getMessage();
                        }
                    }
                    Pessoa pessoa = new Pessoa();
                    pessoa = daopes.salvar(p);
                    idpes = pessoa.getIdPessoa().toString();

                    request.setAttribute("pessoa", idpes);
                    request.getRequestDispatcher("ClienteServlet?acao=ver&id=" + idpes)
                            .forward(request, response);

                    break;
                case "alterar":
                    id = request.getParameter("id");
                    idPes = Long.parseLong(id);
                    altPes = daopes.consultarPorId(idPes);
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String ddmmaa = sdf.format(altPes.getAniverAbertura());

                    request.setAttribute("ddmmaa", ddmmaa);
                    request.setAttribute("altPes", altPes);
                    request.getRequestDispatcher("altClientes.jsp").forward(request, response);
                    break;
                case "excluir":
                    idPes = Long.parseLong(request.getParameter("id"));
                    daopes.remover(idPes);
                    request.getRequestDispatcher("ClienteServlet?acao=listar").forward(request, response);
                    break;

                case "listar":
                    exbPes = daopes.listar();
                    request.setAttribute("exbPes", exbPes);
//                    exbEnd = daoend.listar();
//                    request.setAttribute("exbEnd", exbEnd);
                    request.getRequestDispatcher("exbCliente.jsp").forward(request, response);

                    break;
                case "ver":
                    id = request.getParameter("id");
                    idPes = Long.parseLong(id);
                    altPes = daopes.consultarPorId(idPes);
                    request.setAttribute("altPes", altPes);
                    request.setAttribute("exbPes", altPes);
                    exbEnd = daoend.consultarPorPessoaId(idPes);
                    request.setAttribute("exbEnd", exbEnd);
                    request.getRequestDispatcher("exbClienteEndereco.jsp").forward(request, response);

                    break;
                default:
                    throw new AssertionError();
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
