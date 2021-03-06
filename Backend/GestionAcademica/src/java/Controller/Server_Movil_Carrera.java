package Controller;

import backendga.modelo.Carrera;
import backendga.modelo.Model;
import com.google.gson.Gson;
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

    private Gson gson = new Gson();

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
        Carrera carrera = gson.fromJson(request.getReader(), Carrera.class);

        try (PrintWriter out = response.getWriter()) {
            
            modelo.getGestorCarrera().insertarCarrera(carrera.getCodigo(), carrera.getNombre(), carrera.getTitulo());
        }

    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Model modelo = new Model();
        String codigo = request.getParameter("codigo");
        try (PrintWriter out = response.getWriter()) {
            
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
       

        String opc = request.getParameter("opc");
        String codigo = request.getParameter("codigo");
        Model modelo = new Model();
        if (Integer.parseInt(opc) == 1) {

            try (PrintWriter out = response.getWriter()) {
                
                Carrera carreraBase = modelo.getGestorCarrera().recuperarCarrera(codigo);
                JSONObject carreraJSON = new JSONObject();
                carreraJSON.put("codigo", carreraBase.getCodigo());
                carreraJSON.put("nombre", carreraBase.getNombre());
                carreraJSON.put("titulo", carreraBase.getTitulo());
                out.print(carreraJSON);
            }
        } else {
            try (PrintWriter out = response.getWriter()) {
                           
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
        
        Model modelo = new Model();
        Carrera carrera = gson.fromJson(request.getReader(), Carrera.class);

        try (PrintWriter out = response.getWriter()) {
            
            modelo.getGestorCarrera().actualizarCarrera(carrera.getCodigo(), carrera.getNombre(), carrera.getTitulo());
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
