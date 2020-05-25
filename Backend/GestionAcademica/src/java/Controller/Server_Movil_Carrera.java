package Controller;

import backendga.modelo.Carrera;
import backendga.modelo.Model;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class Server_Movil_Carrera extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        Model modelo = new Model();

        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String titulo = request.getParameter("titulo");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            // out.println("<h5>Se insertara </h5>");
            //   out.println("<h5>Profe: " + p.getId() + p.getNombre() + "</h5>");
            modelo.getGestorCarrera().insertarCarrera(codigo, nombre, titulo);
        }

    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        Model modelo = new Model();
        String codigo = request.getParameter("codigo");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //out.println("<h5> Se eliminara </h5>");
            //out.println("<h5>" + id + "</h5>");
            modelo.getGestorCarrera().eliminarCarrera(codigo);

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
        //processRequest(request, response);

        String opc = request.getParameter("opc");
        String codigo = request.getParameter("codigo");
        Model modelo = new Model();
        if (Integer.parseInt(opc) == 1) {

            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                //out.println("<h1>Se consultará </h1>");
                Carrera carreraBase = modelo.getGestorCarrera().recuperarCarrera(codigo);
                JSONObject carreraJSON = new JSONObject();
                carreraJSON.put("codigo", carreraBase.getCodigo());
                carreraJSON.put("nombre", carreraBase.getNombre());
                carreraJSON.put("titulo", carreraBase.getTitulo());
                out.print(carreraJSON);
            }
        } else {
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                //out.println("<h1>Se listará </h1>");            
                List<Carrera> _lista_carrera = modelo.getGestorCarrera().listarCarreras();
                JSONArray _carrera_array_JS = new JSONArray();
                for (Carrera c : _lista_carrera) {
                    JSONObject objCarrera = new JSONObject();
                    objCarrera.put("codigo", c.getCodigo());
                    objCarrera.put("nombre", c.getNombre());
                    objCarrera.put("titulo", c.getTitulo());

                    _carrera_array_JS.put(objCarrera);
                }

                out.print(_carrera_array_JS);// array que contiene obj en JSON Carreras

            }//cierre del try 

        }//cierre del else    

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

        Model modelo = new Model();
        String _codigo = request.getParameter("codigo");
        String _nombre = request.getParameter("nombre");
        String _titulo = request.getParameter("titulo");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //out.println("<h5>Se modificara </h5>");
            //  out.println("<h5>String " + p.getId() + p.getNombre() + "</h5>");
            modelo.getGestorCarrera().actualizarCarrera(_codigo, _nombre, _titulo);
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
