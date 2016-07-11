/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.recarga.servlet;

import br.com.recarga.bean.Usuario;
import br.com.recarga.dao.DAOUsuario;
import br.com.recarga.util.SenhaMD5;
import static br.com.recarga.util.SenhaMD5.hashmd5;
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
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    SenhaMD5 hashmd5;

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

        Usuario u = new Usuario();
        DAOUsuario daousr = new DAOUsuario();

        if (request.getParameter("acao") != null) {
            String opcao = request.getParameter("acao");
            switch (opcao) {
                case "novo":

                    request.getRequestDispatcher("cadUsuarios.jsp")
                            .forward(request, response);

                    break;
                case "salvar":

                    if (request.getParameter("id") != null && !request.getParameter("id")
                            .equalsIgnoreCase("")) {
                        u.setIdUsuario(Long.parseLong(request.getParameter("id")));
                    }
                    u.setNomeusuario(request.getParameter("usuario"));
                    u.setSenha(hashmd5(request.getParameter("senha")));
                    if (!request.getParameter("datacadastro").equalsIgnoreCase("")) {
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            Date datacad = sdf.parse(request.getParameter("datacadastro"));
                            u.setDataCadastro(datacad);
                        } catch (ParseException e) {
                            e.getMessage();
                        }
                    }

                    daousr.salvar(u);

                    response.sendRedirect("UsuarioServlet?acao=listar");

                    break;
                case "alterar":

                    String id = request.getParameter("id");
                    Long idUsr = Long.parseLong(id);
                    Usuario altUsr = daousr.consultarPorId(idUsr);
                    request.setAttribute("altUsr", altUsr);
                    request.getRequestDispatcher("altUsuario.jsp")
                            .forward(request, response);

                    break;
                case "excluir":

                    Long idDelete = Long.parseLong(request.getParameter("id"));
                    daousr.remover(idDelete);
                    request.getRequestDispatcher("UsuarioServlet?acao=listar")
                            .forward(request, response);

                    break;

                case "listar":

                    List<Usuario> exbUsr = daousr.listar();
                    request.setAttribute("exbUsr", exbUsr);
                    request.getRequestDispatcher("exbUsuario.jsp")
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
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
