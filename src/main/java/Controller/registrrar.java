/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dto.Tienda;
import Negocio.Tiendas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pc-Victor
 */
public class registrrar extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registrrar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registrrar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);

        
        String nombre = request.getParameter("nombre");
        String lema = request.getParameter("lema");
        String descripcion = request.getParameter("descripcion");
        String email = request.getParameter("email");
        String clave = request.getParameter("clave");
        String propietario = request.getParameter("propietario");
        String facebook = request.getParameter("facebook");
        String web = request.getParameter("web");
        String imagen = request.getParameter("imagen");

        
        Tienda t = new Tienda();
       Tiendas ts=new Tiendas();
 
        t.setNombre(nombre);
        t.setLema(lema);
        t.setDescripcion(descripcion);
        t.setEmail(email);
        t.setClave(clave);
        t.setPropietario(propietario);
        t.setFacebook(facebook);
        t.setWeb(web);
        t.setImagen(imagen);
      
        
        if (ts.registrarTienda(t)) {
            request.setAttribute("list",ts.getTiendas());
            request.getRequestDispatcher("servicios.html").forward(request, response);
        } else {
            request.getRequestDispatcher("index.html").forward(request, response);
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
