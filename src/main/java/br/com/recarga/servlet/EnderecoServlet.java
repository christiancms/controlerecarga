/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.recarga.servlet;

import br.com.recarga.bean.Endereco;
import br.com.recarga.bean.Pessoa;
import br.com.recarga.dao.DAOEndereco;
import br.com.recarga.dao.DAOPessoa;
import java.io.IOException;
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
@WebServlet(name = "EnderecoServlet", urlPatterns = {"/EnderecoServlet"})
public class EnderecoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        Endereco e = new Endereco();
        Pessoa p = new Pessoa();
        DAOEndereco daoend = new DAOEndereco();
        DAOPessoa daopes = new DAOPessoa();
        String id, idPes;
        Long idEnd;

        if (request.getParameter("acao") != null) {
            String opcao = request.getParameter("acao");
            switch (opcao) {
                case "novo":
                    id = request.getParameter("id");
                    request.setAttribute("codPes", id);
                    request.getRequestDispatcher("cadEnderecos.jsp").forward(request, response);
                    break;
                case "salvar":
                    if (request.getParameter("id") != null && !request.getParameter("id")
                            .equalsIgnoreCase("")) {
                        e.setIdEndereco(Long.parseLong(request.getParameter("id")));
                    }
                    idPes = request.getParameter("idcliente");
                    Long codpes = Long.parseLong(request.getParameter("idcliente"));
                    e.setCep(request.getParameter("cep"));
                    e.setLogradouro(request.getParameter("logradouro"));
                    e.setNumero(Integer.parseInt(request.getParameter("numero")));
                    e.setComplemento(request.getParameter("complemento"));
                    e.setBairro(request.getParameter("bairro"));
                    e.setMunicipio(request.getParameter("cidade"));
                    e.setUnidFed(request.getParameter("uf"));
                    e.setPais(request.getParameter("pais"));
                    e.setPessoa(daopes.consultarPorId(codpes));
                    daoend.salvar(e);
                    request.getRequestDispatcher("ClienteServlet?acao=ver&id="+idPes).forward(request, response);
                    break;
                case "alterar":
                    id = request.getParameter("id");
                    idEnd = Long.parseLong(id);
                    request.getRequestDispatcher("cadEnderecos.jsp").forward(request, response);
                    break;
                case "excluir":

                    break;

                case "listar":

                    List<Endereco> exbUsr = daoend.listar();
                    request.setAttribute("exbUsr", exbUsr);
                    request.getRequestDispatcher("exbEndereco.jsp")
                            .forward(request, response);

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
            Logger.getLogger(EnderecoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EnderecoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
