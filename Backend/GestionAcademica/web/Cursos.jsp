<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="false" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cursos</title>
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
    <body onload="init();" style="background-color:#1b262c;">
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
                        <div class="card-body bg-dark text-white border-dark">
                            <table>
                                <tr>
                                    <td>
                                        <a class="btn btn-primary" href="Carreras.jsp" role="button">Carreras</a>
                                    </td>
                                    <td>
                                        <span class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">Agregar Curso</span>
                                    </td>
                                    <td>
                                        <form action="Service_Logout" method="POST">
                                            <button  type="submit" class="btn btn-primary">Salir</button >
                                        </form>
                                    </td>
                                </tr>
                            </table> <br><br>
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
        <!-- Modal Para Agregar Cursos -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content bg-dark text-white">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel" >Agregar nuevo curso</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <div class="modal-body">
                        <div class="container">
                            <form action="Service_Crea_Curso" method="POST"  class="was-validated" id="cursoform">
                                <div class="form-row align-items-center">

                                    <div class="col">
                                        <div class="form-group">
                                            <label>Código:</label>
                                            <input type="text" class="form-control" placeholder="Código del curso:"  name="codigoCF" id="codigoCF" required>
                                            <div class="valid-feedback">Valido!</div>
                                            <div class="invalid-feedback">Por favor llenar el campo!</div>
                                        </div>
                                    </div>

                                    <div class="col">

                                        <div class="form-group">
                                            <label for="uname">Nombre: </label>
                                            <input type="text" class="form-control" id="nombreCF" placeholder="Nombre del curso:" name="nombreCF" id="nombreCF" required>
                                            <div class="valid-feedback">Valido!</div>
                                            <div class="invalid-feedback">Por favor llenar el campo!</div>
                                        </div>


                                    </div>


                                </div>
                                <div class="form-row align-items-center">

                                    <div class="col">
                                        <div class="form-group">
                                            <label>Numero de Creditos:</label>
                                            <input type="number" min="1" class="form-control" placeholder="Numero de creditos" name="numeroCF" id="numeroCF" required>
                                            <div class="valid-feedback">Valido!</div>
                                            <div class="invalid-feedback">Por favor llenar el campo!</div>
                                        </div>
                                    </div>
                                    <div class="col">
                                        <div class="form-group">
                                            <label>Horas semanales:</label>
                                            <input type="number" min="1" class="form-control" placeholder="Horas Semanales" name="horasCF" id="horasCF" required>
                                            <div class="valid-feedback">Valido!</div>
                                            <div class="invalid-feedback">Por favor llenar el campo!</div>
                                        </div>

                                    </div>
                                </div>

                                <div class="form-row align-items-center">
                                    <div class="col">
                                        <div class="form-group">
                                            <label>Ciclo: </label>
                                            <select name="cicloCF" class="custom-select" id="cicloCF" required>
                                                <option value="I">I</option>
                                                <option value="II">II</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="col">

                                        <div class="form-group">
                                            <label >Codigo de carrera: </label>
                                            <select id="dpc" name="dpc" class="custom-select"  required>
                                            </select>
                                        </div>


                                    </div>

                                </div> 

                                <div class="form-group">
                                    <label>Año:</label>
                                    <input type="number" min="1900" max="2099" step="1" value="2020"class="form-control" placeholder="Anio" id="anioCF" name="anioCF" required>
                                    <div class="valid-feedback">Valido!</div>
                                    <div class="invalid-feedback">Por favor llenar el campo!</div>
                                </div>




                                <button type="submit" id="botonAgregar" class="btn btn-primary">Agregar</button>
                                <button type="reset" class="btn btn-primary">Borrar</button>
                            </form>

                        </div>

                    </div>
                </div>
            </div>
        </div>


        <!-- Modal Para Editar Cursos -->
        <div id="modalEditar" class="modal fade"  tabindex="-1" role="dialog" aria-labelledby="modalEditar" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content bg-dark text-white">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel" >Editar curso</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <div class="modal-body">
                        <div class="container">
                            <form action="Service_Edita_Curso" method="POST"  class="was-validated" id="editaCursoForm">
                                <div class="form-row align-items-center">

                                    <div class="col">
                                        <div class="form-group">
                                            <label>Código:</label>
                                            <input type="text" class="form-control" placeholder="Código del curso:"  name="ccf" id="ccf" >
                                            <div class="valid-feedback">Valido!</div>
                                            <div class="invalid-feedback">Por favor llenar el campo!</div>
                                        </div>
                                    </div>

                                    <div class="col">
                                        <div class="form-group">
                                            <label for="uname">Nombre: </label>
                                            <input type="text" class="form-control"  placeholder="Nombre del curso:" name="ncf" id="ncf" required>
                                            <div class="valid-feedback">Valido!</div>
                                            <div class="invalid-feedback">Por favor llenar el campo!</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-row align-items-center">

                                    <div class="col">
                                        <div class="form-group">
                                            <label>Numero de Creditos:</label>
                                            <input type="number" min="1" class="form-control" placeholder="Numero de creditos" name="nucf" id="nucf" required>
                                            <div class="valid-feedback">Valido!</div>
                                            <div class="invalid-feedback">Por favor llenar el campo!</div>
                                        </div>
                                    </div>
                                    <div class="col">
                                        <div class="form-group">
                                            <label>Horas semanales:</label>
                                            <input type="number" min="1" class="form-control" placeholder="Horas Semanales" name="hcf" id="hcf" required>
                                            <div class="valid-feedback">Valido!</div>
                                            <div class="invalid-feedback">Por favor llenar el campo!</div>
                                        </div>

                                    </div>
                                </div>

                                <div class="form-row align-items-center">
                                    <div class="col">
                                        <div class="form-group">
                                            <label>Ciclo: </label>
                                            <select  class="custom-select" id="cicf" name="cicf" required>
                                                <option value="I">I</option>
                                                <option value="II">II</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="col">

                                        <div class="form-group">
                                            <label >Codigo de carrera: </label>
                                            <select class="custom-select" id="codcf" name="codcf"  >

                                            </select>
                                        </div>


                                    </div>

                                </div> 

                                <div class="form-group">
                                    <label>Año:</label>
                                    <input type="number" min="1900" max="2099" step="1" value="2020"class="form-control" placeholder="Anio" id="ancf" name="ancf" required>
                                    <div class="valid-feedback">Valido!</div>
                                    <div class="invalid-feedback">Por favor llenar el campo!</div>
                                </div>




                                <button type="submit" id="botonEditar" class="btn btn-primary">Actualizar</button>
                                <button type="reset" class="btn btn-primary">Reset</button>
                            </form>

                        </div>

                    </div>
                </div>
            </div>
        </div>



        <script type="text/javascript">

            let dropdown = $('#dpc');
            dropdown.empty();
            dropdown.prop('selectedIndex', 0);
            const url = '/GestionAcademica/Service_Lista_CodigoCarreras';
            $.getJSON(url, function (data) {
                $.each(data, function (key, entry) {
                    dropdown.append($('<option></option>').attr('value', entry.codigo).text(entry.codigo));
                });
            });

            $('#myModal').on('shown.bs.modal', function () {
                $('#myInput').trigger('focus');
            });


            function init() {
                fetch('Service_Lista_Curso')
                        .then((response) => {
                            return response.json();
                        })
                        .then((dataSet) => {
                            $(document).ready(function () {
                                $('#example').DataTable({
                                    data: dataSet,
                                    columns: [
                                        {title: "Código"},
                                        {title: "Año"},
                                        {title: "Ciclo"},
                                        {title: "Nombre"},
                                        {title: "Créditos"},
                                        {title: "Horas Semanales"},
                                        {title: "Editar"},
                                        {title: "Eliminar"}
                                    ]
                                });
                            });
                        });
            }



            function eliminaCurso(codigoCurso) {
                $.ajax({
                    type: "POST",
                    url: '/GestionAcademica/Service_Borra_Curso',
                    data: {cursoCodigo: codigoCurso}
                });
                location.reload();
            }



            function actModal(datosString) {

                const[codigo, carrerracodigo, anio, ciclo, nombre, creditos, horas] = datosString.split(',');
                $('#ccf').val(codigo);
                $('#codcf').val(carrerracodigo);

                $('#ncf').val(nombre);
                $('#nucf').val(creditos);
                $('#hcf').val(horas);
                $('#cicf').val(ciclo);
                $("#ccf").hide();
                $("#codcf").hide();

                $('#ancf').val(anio);
                let dropdown = $('#codcf');
                dropdown.append($('<option></option>').attr('value', carrerracodigo).text(carrerracodigo));




            }

        </script>
    </body>
</html>
