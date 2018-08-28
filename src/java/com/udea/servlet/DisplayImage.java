/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.servlet;

import com.udea.ejb.FileStorageFacadeLocal;
import com.udea.entity.FileStorage;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "DisplayImage", urlPatterns = {"/DisplayImage"})
public class DisplayImage extends HttpServlet {

    @EJB
    private FileStorageFacadeLocal fileStorageFacadeLocal;
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
        FileStorage a = null;
        try {
            String id = request.getParameter("id");
            a = fileStorageFacadeLocal.find(Long.valueOf(id));
            // trump.jpg, putin.png
            String imageFileName = a.getFileName();
            System.out.println("File Name: "+ imageFileName);

            // image/jpg
            // image/png
            String contentType = this.getServletContext().getMimeType(imageFileName);
            System.out.println("Content Type: "+ contentType);

            response.setHeader("Content-Type", contentType);

            response.setHeader("Content-Length", String.valueOf(a.getContent().length));

            response.setHeader("Content-Disposition", "inline; filename=\"" + a.getFileName() + "\"");

            // Write image data to Response.
            response.getOutputStream().write(a.getContent());
        } catch (Exception e) {
            throw new ServletException(e);
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
