<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Lista Estudiantes</title>
</head>
<body>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="js/bootstrap.min.js"></script>
</body>

<div class="container">
	<h2>Estudiantes</h2>
	<!-- Formulario buscar Estudiante -->
	<form action="estudiante" method="get" id="buscarEmployeeForm"
		role="form">
		<input type="hidden" id="buscarAction" name="buscarAction"
			value="buscarPorNombre">
		<div class="form-group col-xs-5">
			<input type="text" name="nombreEstudiante" id="nombreEstudiante"
				class="form-control" required="true"
				placeholder="Escriba el nombe o apellido del Estudiante" />
		</div>
		<button type="submit" class="btn btn-info">
			<span class="glyphicon glyphicon-search"></span> Buscar
		</button>
	</form>

	<form action="estudiante" method="get">
		<input type="hidden" id="buscarAction" name="buscarAction"
			value="nuevo"> <br></br>
		<button type="submit" class="btn btn-primary  btn-md">Nuevo
			estudiante</button>
	</form>

	<c:if test="${not empty message}">
		<div class="alert alert-success">${message}</div>
	</c:if>
	<form action="estudiante" method="post" id="estudianteForm" role="form">
		<input type="hidden" id="idEstudiante" name="idEstudiante"> <input
			type="hidden" id="action" name="action">
		<c:choose>
			<c:when test="${not empty listaEstudiantes}">
				<table class="table table-striped">
					<thead>
						<tr>
							<td>Id</td>
							<td>Nombre</td>
							<td>Apellido</td>
							<td>Fecha de Nacimiento</td>
							<td>Carrera</td>
							<td>Semestre</td>
							<td>E-mail</td>
						</tr>
					</thead>
					<c:forEach var="estudiante" items="${listaEstudiantes}">
						<c:set var="classSucess" value="" />
						<c:if test="${idEstudiante == estudiante.id}">
							<c:set var="classSucess" value="info" />
						</c:if>
						<tr class="${classSucess}">
							<td><a
								href="estudiante?idEstudiante=${estudiante.id}&buscarAction=buscarPorId">${estudiante.id}</a></td>
							<td>${estudiante.nombre}</td>
							<td>${estudiante.apellido}</td>
							<td>${estudiante.fechaNacimiento}</td>
							<td>${estudiante.carrera}</td>
							<td>${estudiante.semestre}</td>
							<td>${estudiante.email}</td>
							<td><a href="#" id="eliminar"
								onclick="document.getElementById('idEstudiante').value='${estudiante.id}';
            									document.getElementById('action').value='eliminar';
            									document.getElementById('estudianteForm').submit();">
									<span class="glyphicon glyphicon-trash" />
							</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<br>
				<div class="alert alert-info">No se encontraron registros para
					la búsqueda</div>
			</c:otherwise>
		</c:choose>
	</form>
</div>
</html>