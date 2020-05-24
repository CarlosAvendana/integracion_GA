package Controller;

import backendga.modelo.Curso;
import backendga.modelo.dao.GestorCurso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;

public class Service_Lista_Curso extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            List<Curso> _Lista_carrera
                    = GestorCurso.obtenerInstancia().listarCurso();

            JSONArray _curso_array_JS = new JSONArray();

            for (Curso c : _Lista_carrera) {
                JSONArray pj = new JSONArray();

                pj.put(c.getCodigo());
                //pj.put(c.getCarrera_codigo());
                pj.put(c.getAnio());
                pj.put(c.getCiclo());
                pj.put(c.getNombre());
                pj.put(c.getCreditos());
                pj.put(c.getHoras_semanales());
                pj.put("<button type='button' data-toggle=\"modal\" data-target=\"#modalEditar\" class='btn btn-info' onclick='actModal"
                        + "(\"" + c.getCodigo() + "," + c.getCarrera_codigo() + "," + c.getAnio() + "," + c.getCiclo() + "," + c.getNombre() + ","
                        + c.getCreditos() + "," + c.getHoras_semanales() + "\");'>Editar</button>");

                pj.put("<button type='button' class='btn btn-danger' onclick='eliminaCurso(\"" + c.getCodigo() + "\");'>Eliminar</button>");

                _curso_array_JS.put(pj);
            }

            out.print(_curso_array_JS);
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
