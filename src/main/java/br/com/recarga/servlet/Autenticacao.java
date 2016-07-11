/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.recarga.servlet;

import br.com.recarga.dao.DAOUsuario;
import br.com.recarga.util.SenhaMD5;
import static br.com.recarga.util.SenhaMD5.hashmd5;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maicon
 */
@WebServlet(name = "Autenticacao", urlPatterns = {"/Autenticacao"})
public class Autenticacao extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        DAOUsuario daousr = new DAOUsuario();

        String usr = request.getParameter("usrNome");
        String pwd = request.getParameter("usrSenha");
        boolean tag = request.getServerName().equals("localhost");
        pwd = hashmd5(pwd);
        
        boolean resultado = daousr.verificaLogin(usr, pwd, tag);
//        String requestURI = request.getRequestURI();
//        String requestPath = request.getContextPath();
//        String end = "ServerName: "+request.getServerName()+" - "
//                + "URI: "+ requestURI + " - "
//                + "Path: "+requestPath;
//        request.setAttribute("ip", end);
        // pwd = teste123
        if (resultado == true) {
            usr = usr.toUpperCase();
            request.getSession().setAttribute("usrSessao", usr);
            request.setAttribute("usuario", usr);
            //            System.err.println(request.getHeader("User-Agent"));
            //remover atributo
            //sessao.removeAttribute("usrSessao");

            request.getRequestDispatcher("principal.jsp").forward(request, response);
        } else {
            request.setAttribute("erro", "Usuário/Senha incorretos");
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
