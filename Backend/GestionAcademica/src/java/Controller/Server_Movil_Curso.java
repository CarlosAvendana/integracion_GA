package Controller;

import backendga.modelo.Carrera;
import backendga.modelo.Curso;
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

public class Server_Movil_Curso extends HttpServlet {

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

        String _codigo = request.getParameter("codigo");
        String _carrera_codigo = request.getParameter("carreracodigo");
        String _anio = request.getParameter("anio");
        String _ciclo = request.getParameter("ciclo");
        String _nombre = request.getParameter("nombre");
        String _creditosS = request.getParameter("creditos");
        String _hsS = request.getParameter("horas");
        int hs = Integer.parseInt(_hsS);
        int credi = Integer.parseInt(_creditosS);

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //out.println("<h5>Se insertara </h5>");
            //out.println("<h5>Profe: " + p.getId() + p.getNombre() + "</h5>");
            modelo.getGestorCurso().insertarCurso(_codigo, _carrera_codigo, _anio, _ciclo, _nombre, credi, hs);

        }

    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        Model model = new Model();
        String _codigo = request.getParameter("cursoCodigo");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //out.println("<h5> Se eliminara </h5>");
            //out.println("<h5>" + id + "</h5>");
            model.getGestorCurso().eliminarCurso(_codigo);
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

        Model modelo = new Model();
        String opc = request.getParameter("opc");
        String codigo = request.getParameter("codigo");
        if (Integer.parseInt(opc) == 1) {

            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                //out.println("<h1>Se consultará </h1>");
                Curso cur = modelo.getGestorCurso().recuperarCurso(codigo);

                JSONObject cursoJSON = new JSONObject();
                cursoJSON.put("codigo", cur.getCodigo());
                cursoJSON.put("carrera_codigo", cur.getCarrera_codigo());
                cursoJSON.put("anio", cur.getAnio());
                cursoJSON.put("ciclo", cur.getCiclo());
                cursoJSON.put("nombre", cur.getNombre());
                cursoJSON.put("creditos", cur.getCreditos());
                cursoJSON.put("horas", cur.getHoras_semanales());

                out.print(cursoJSON);

            }
        } else {
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                //out.println("<h1>Se listará </h1>");
                List<Curso> _lista_cursos = modelo.getGestorCurso().listarCurso();
                JSONArray _curso_array_JS = new JSONArray();

                for (Curso cur : _lista_cursos) {
                    JSONObject cursoJSON = new JSONObject();
                    cursoJSON.put("codigo", cur.getCodigo());
                    cursoJSON.put("carrera_codigo", cur.getCarrera_codigo());
                    cursoJSON.put("anio", cur.getAnio());
                    cursoJSON.put("ciclo", cur.getCiclo());
                    cursoJSON.put("nombre", cur.getNombre());
                    cursoJSON.put("creditos", cur.getCreditos());
                    cursoJSON.put("horas", cur.getHoras_semanales());
                    _curso_array_JS.put(cursoJSON);
                }

                out.print(_curso_array_JS);

            }//cierre del try

        }
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

        Model model = new Model();

        // este retrieve se puede cambiar por el de recuperar del profe
        // que es casteando lo que llega como JSON y pasarlo a la clase
        // que ya tenemo en el modelo para no mandar todo por los parametros
        String _codigo = request.getParameter("codigo");
        String _carrera_codigo = request.getParameter("carreracodigo");
        String _anio = request.getParameter("anio");
        String _ciclo = request.getParameter("ciclo");
        String _nombre = request.getParameter("nombre");
        String _creditosS = request.getParameter("creditos");
        String _hsS = request.getParameter("horas");
        int hs = Integer.parseInt(_hsS);
        int credi = Integer.parseInt(_creditosS);

        //  Profesor p = gson.fromJson(profe, Profesor.class);           
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //out.println("<h5>Se modificara </h5>");
            //  out.println("<h5>String " + p.getId() + p.getNombre() + "</h5>");
            model.getGestorCurso().actualizarCurso(_codigo, _carrera_codigo, _anio, _ciclo, _nombre, credi, hs);
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
