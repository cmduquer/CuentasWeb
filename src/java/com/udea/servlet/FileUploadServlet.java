/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.servlet;

import com.udea.ejb.FileStorageFacadeLocal;
import com.udea.entity.FileStorage;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author cmduquer
 */
@WebServlet(name = "FileUploadServlet", urlPatterns = {"/FileUploadServlet"})
public class FileUploadServlet extends HttpServlet {

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
        
        boolean isMultipart = ServletFileUpload.isMultipartContent( request );
        if ( isMultipart )
        {
            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload();

            try
            {
                // Parse the request
                FileItemIterator iter = upload.getItemIterator( request );

                while ( iter.hasNext() )
                {
                    FileItemStream item = iter.next();
                    String fieldName = item.getFieldName();
                    String name = item.getName();

                    if ( fieldName.equals( "selectedFile" ) )
                    {
                        byte[] bytes = IOUtils.toByteArray( item.openStream() );
                        FileStorage fsEntity = new FileStorage( name, bytes );
                        fileStorageFacadeLocal.create( fsEntity );
                    }
                }

                response.sendRedirect( "ok.jsp" );
            }
            catch ( IOException ex )
            {
                throw ex;
            }
            catch ( Exception ex )
            {
                throw new ServletException( ex );
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
