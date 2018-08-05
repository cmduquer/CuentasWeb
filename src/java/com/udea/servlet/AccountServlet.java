/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.servlet;

import com.udea.ejb.AccountFacadeLocal;
import com.udea.entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cmduquer
 */
@WebServlet(name = "AccountServlet", urlPatterns = {"/AccountServlet"})
public class AccountServlet extends HttpServlet {

    @EJB
    private AccountFacadeLocal accountFacade;

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
        Account a = null;
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            String url = "index.jsp";
            if(action.equalsIgnoreCase("list")){
                List<Account> accounts = accountFacade.findAll();
                request.getSession().setAttribute("accounts", accounts);
                url = "listAccounts.jsp";
            } else if(action.equalsIgnoreCase("login")){
                String u = request.getParameter("username");
                String up = request.getParameter("password");
                boolean checklogin = accountFacade.checkLogin(u, up);
                if(checklogin){
                    request.getSession().setAttribute("login", u);
                    url = "manager.jsp";
                } else{
                    url = "login.jsp?error=1";
                }
            } else if(action.equalsIgnoreCase("insert")){
                a = new Account();
                a.setUsername(request.getParameter("username"));
                a.setPassword(request.getParameter("password"));
                a.setEmail(request.getParameter("email"));
                accountFacade.create(a);
                url = "login.jsp";
            } else if(action.equalsIgnoreCase("delete")){
                String id = request.getParameter("id");
                a = accountFacade.find(Integer.valueOf(id));
                accountFacade.remove(a);
                url = "AccountServlet?action=list";
                
            } else if(action.equalsIgnoreCase("logout")){
                request.getSession().removeAttribute("login");
                url="login.jsp";
                
            }
            response.sendRedirect(url);
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
