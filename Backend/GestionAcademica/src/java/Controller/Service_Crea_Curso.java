package Controller;

import backendga.modelo.Model;
import backendga.modelo.dao.GestorCurso;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Service_Crea_Curso extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
        try (PrintWriter out = response.getWriter()) {

            Model model = new Model();

            String _codigo = request.getParameter("codigoCF");
            String _carrera_codigo = request.getParameter("dpc");
            String _anio = request.getParameter("anioCF");
            String _ciclo = request.getParameter("cicloCF");
            String _nombre = request.getParameter("nombreCF");
            String _creditosS = request.getParameter("numeroCF");
            String _hsS = request.getParameter("horasCF");
            int hs = Integer.parseInt(_hsS);
            int credi = Integer.parseInt(_creditosS);
            model.getGestorCurso().insertarCurso(_codigo, _carrera_codigo, _anio,
                    _ciclo, _nombre, credi, hs);

            response.sendRedirect("Cursos.jsp");
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
