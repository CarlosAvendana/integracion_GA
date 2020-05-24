<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="false" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carreras</title>
        <link rel="icon" href="Icon/GA1.ico" type="image/png"/>
        <% response.setHeader("cache-control", "no-cache, no-store, must-revalidate");%>   
        <link rel="stylesheet" type="text/css" href="bootstrap/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="bootstrap_table/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="bootstrap_table/dataTables.bootstrap4.min.css"/>
        <script src="bootstrap/jquery.min.js"></script>
        <script src="bootstrap_table/jquery.dataTables.min.js"></script>
        <script src="bootstrap/bootstrap.min.js"></script>
        <script src="bootstrap/popper.min.js"></script>
        <script src="bootstrap_table/dataTables.bootstrap4.min.js"></script>
    </head>
    <body onload="init();" style="background-color:#1b262c; ">
        <%
            HttpSession sesion = request.getSession();
            String usuario;
            if (sesion.getAttribute("user") == null) {
                sesion.removeAttribute("user");
                sesion.invalidate();
                out.print("<script>location.replace('loginError.jsp') </script>");
            }
        %>
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <div class="card text-center">
                        <div class="card-header bg-dark text-white">
                            Gestion Academica
                        </div>
                        <div class="card-body bg-dark text-white">
                            <table>
                                <tr>
                                    <td>  <a class="btn btn-primary" href="Cursos.jsp" role="button">Cursos</a></td>
                                    <td><span class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" onclick="resetTitulo()"> Agregar Carrera</span> </td>
                                    <td> <form action="Service_Logout" method="POST">
                                            <button  type="submit" class="btn btn-primary">Salir</button >
                                        </form></td>
                                </tr>
                            </table><br><br>
                            <div>
                                <table id="example" class="table table-hover table-dark" style="width:100%;margin: auto; padding-top: 60px;">
                                </table>
                            </div>
                        </div>
                        <div class="card-footer bg-dark text-white">
                            Laboratorio Moviles 01-02 ~ Carlos Obando & Felipe Piedra
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal Para Agregar -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content bg-dark text-white">
                    <div class="modal-header text-white bg-dark">
                        <h5 class="modal-title" id="exampleModalLabel">Agregar nueva carrera</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="container">
                            <form action="Service_Crea_Carrera" method="POST" class="was-validated" id="modalForm">
                                <div class="form-group">
                                    <label>Código:</label>
                                    <input type="text" class="form-control" placeholder="Código de la carrera" name="codigoCF" id="codigoCF" required>
                                    <div class="valid-feedback">Valido!</div>
                                    <div class="invalid-feedback">Por favor llenar el campo!</div>
                                </div>
                                <div class="form-group">
                                    <label>Nombre: </label>
                                    <input type="text" class="form-control" placeholder="Nombre de la carrera" name="nombreCF" id="nombreCF" required>
                                    <div class="valid-feedback">Valid.</div>
                                    <div class="invalid-feedback">Por favor llenar el campo.</div>
                                </div>
                                <div class="form-group">
                                    <label >Título: </label>
                                    <select name="tituloCF" class="custom-select" id="tituloCF" required>
                                        <option value="Diplomado">Diplomado</option>
                                        <option value="Bachillerato">Bachillerato</option>
                                        <option value="Licenciatura">Licenciatura</option>
                                        <option value="Maestria">Maestría</option>
                                        <option value="Doctorado">Doctorado</option>
                                    </select>
                                </div>
                                <button id="botonAgregar" type="submit" class="btn btn-primary">Agregar</button>
                                <button type="reset" class="btn btn-primary">Borrar</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">

            function init() {

                let dataSet;
                fetch('Service_Lista_Carrera')
                        .then((response) => {
                            return response.json();
                        })
                        .then((dataSet) => {
                            console.log(dataSet);
                            $(document).ready(function () {
                                $('#example').DataTable({
                                    data: dataSet,
                                    columns: [
                                        {title: "Código"},
                                        {title: "Título"},
                                        {title: "Nombre"},
                                        {title: "Editar"},
                                        {title: "Eliminar"}
                                    ]
                                });
                            });
                        });
            }

            $('#myModal').on('shown.bs.modal', function () {
                $('#myInput').trigger('focus');
            });

            function eliminaCarrera(codigoCarrera) {
                $.ajax({
                    type: "POST",
                    url: '/GestionAcademica/Service_Borra_Carrera',
                    data: {carreraCodigo: codigoCarrera}
                });
                location.reload();
            }

            function abrirModalActualiza(datosString) {

                resetTitulo(1);
                const[codigo, nombre, titulo] = datosString.split(',');
                $('#codigoCF').val(codigo);
                $('#nombreCF').val(nombre);
                $('#tituloCF').val(titulo);

                $('#modalForm').submit(function () {
                    $(this).attr('action', 'Service_Edita_Carrera');
                    resetTitulo(0);
                });


            }

            function resetTitulo(dato) {
                if (dato === 1) {
                    $('#exampleModalLabel').html("Editar Carrera");
                    $('#botonAgregar').html("Actualizar");
                    $("#codigoCF").prop("disabled", true);
                } else {
                    $('#exampleModalLabel').html("Agregar Carrera");
                    $('#botonAgregar').html("Agregar");
                    $("#codigoCF").prop("disabled", false);
                }
            }

        </script>
    </body>
</html>



