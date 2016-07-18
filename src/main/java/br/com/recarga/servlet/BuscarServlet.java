/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.recarga.servlet;

import br.com.recarga.bean.Pessoa;
import br.com.recarga.bean.Usuario;
import br.com.recarga.dao.DAOPessoa;
import br.com.recarga.dao.DAOUsuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author christian
 */
@WebServlet(name = "BuscarServlet", urlPatterns = {"/BuscarServlet"})
public class BuscarServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        DAOUsuario daousr = new DAOUsuario();
        DAOPessoa daopes = new DAOPessoa();
        String busca;

        String botaoRadio = request.getParameter("buscar");

        switch (botaoRadio) {
            case "cliente":
                System.out.println("CLIENTE");
                busca = request.getParameter("data[search]");
                List<Pessoa> exbCli = daopes.buscaCompleta(busca);
                
                request.setAttribute("exbPes", exbCli);
                request.getRequestDispatcher("exbCliente.jsp").forward(request, response);

                break;
            case "menu":
                System.out.println("MENU");
                request.getRequestDispatcher("principal.jsp").forward(request, response);

                break;
            case "usuario":
                System.out.println("USUÁRIO");
                busca = request.getParameter("data[search]");
                List<Usuario> exbUsr = daousr.buscaCompleta(busca);

                request.setAttribute("exbUsr", exbUsr);
                request.getRequestDispatcher("exbUsuario.jsp").forward(request, response);

                break;
            default:
                throw new AssertionError();
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
        processRequest(request, response);
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
        processRequest(request, response);
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
