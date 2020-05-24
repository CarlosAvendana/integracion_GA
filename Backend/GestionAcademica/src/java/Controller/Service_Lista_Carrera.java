package Controller;

import backendga.modelo.Carrera;
import backendga.modelo.dao.GestorCarrera;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class Service_Lista_Carrera extends HttpServlet {

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
        response.setContentType("application/json;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            List<Carrera> _Lista_carrera
                    = GestorCarrera.obtenerInstancia().listarCarreras();

            JSONArray _carrera_array_JS = new JSONArray();

            for (Carrera c : _Lista_carrera) {
                JSONArray pj = new JSONArray();

                pj.put(c.getCodigo());
                pj.put(c.getTitulo());
                pj.put(c.getNombre());
                pj.put("<button type='button' class='btn btn-info'data-toggle=\"modal\" data-target=\"#exampleModal\" onclick='abrirModalActualiza(\"" + c.getCodigo() + "," + c.getNombre() + "," + c.getTitulo() + "\");'>Editar</button>");
                pj.put("<button type='button' class='btn btn-danger' onclick='eliminaCarrera(\"" + c.getCodigo() + "\");'>Eliminar</button>");

                _carrera_array_JS.put(pj);
            }

            out.print(_carrera_array_JS);
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
