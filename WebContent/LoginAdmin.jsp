<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html lang="en">

<head>
<%@ include file="Head.jsp"%>
</head>

<body>
	<div class="preloader">
		<img src="img/loader.gif" alt="Preloader image">
	</div>
	<nav class="navbar">
	<%@ include file="/Admin/navAdmin.jsp"%>
	</nav>
	<header id="intro">
		<%@ include file="/Admin/headerAdmin.jsp"%>
	</header>

	<!--Registro de Usuarios-->
	
		<%@ include file="/Admin/FormRegistro.jsp"%>


	<!--pagina pedir cita atención primaria  -->
			<%@ include file="/Admin/FormGestionCitas.jsp"%>
	<!-- fin pedir gestionar citas -->

	<!-- ver horario de una especialidad para gestionar incidencias  -->
				<%@ include file="/Admin/FormGestionEspecialidad.jsp"%>
	
	<!--fin pagina pedir cita especialistas  -->

	<!-- Asignar cita  -->
	
	<!-- Fin confitmar cita -->

	<!-- Cancelar cita  -->

	<%@ include file="/Comunes/FormCancelarCita.jsp"%>
	
	<!-- Fin confitmar cita -->



	<footer>
		<%@ include file="Footer.jsp"%>
	
	</footer>
	<!-- Holder for mobile navigation -->
	<div class="mobile-nav">
		<ul>
		</ul>
		<a href="#" class="close-link"><i class="arrow_up"></i></a>
	</div>
	<!-- Scripts -->
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/wow.min.js"></script>
	<script src="js/typewriter.js"></script>
	<script src="js/jquery.onepagenav.js"></script>
	<script src="js/main.js"></script>
</body>

</html>
