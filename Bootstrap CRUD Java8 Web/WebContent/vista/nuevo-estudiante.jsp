<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel="stylesheet" href="css/bootstrap.min.css">   		
        <script src="js/bootstrap.min.js"></script>     
    </head>
    <body>
        <div class="container">
            <form action="estudiante" method="post"  role="form" data-toggle="validator" >
                <c:if test ="${empty action}">                        	
                    <c:set var="action" value="guardar"/>
                </c:if>
                <input type="hidden" id="action" name="action" value="${action}">
                <input type="hidden" id="idEstudiante" name="idEstudiante" value="${estudiante.id}">
                <h2>Estudiante</h2>
                <div class="form-group">
                    <label for="nombre" class="control-label col-xs-4">Nombre:</label>
                    <input type="text" name="nombre" id="nombre" class="form-control" value="${estudiante.nombre}" required="true" />                                   

                    <label for="apellido" class="control-label col-xs-4">Apellido:</label>                   
                    <input type="text" name="apellido" id="apellido" class="form-control" value="${estudiante.apellido}" required="true"/> 

                    <label for="fnacimiento" class="control-label col-xs-4">Fecha de Nacimiento</label>                 
                    <input type="text"  pattern="^\d{2}-\d{2}-\d{4}$" name="fnacimiento" id="fnacimiento" class="form-control" value="${estudiante.fechaNacimiento}" maxlength="10" placeholder="dd-MM-yyy" required="true"/>

                    <label for="carrera" class="control-label col-xs-4">Carrera:</label>                    
                    <input type="text" name="carrera" id="carrera" class="form-control" value="${estudiante.carrera}" required="true"/> 

                    <label for="semestre" class="control-label col-xs-4">Semestre:</label>
                    <input type="text" name="semestre" id="semestre" class="form-control" value="${estudiante.semestre}" required="true"/>

                    <label for="email" class="control-label col-xs-4">E-mail:</label>                   
                    <input type="text" name="email" id="email" class="form-control" value="${estudiante.email}" placeholder="Escriba su email" required="true"/>

                    <br></br>
                    <button type="submit" class="btn btn-primary">Guardar</button> 
                </div>                                                      
            </form>
        </div>
    </body>
</html>