<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
	<%@ include file="Head.jsp"%>
</head>

<body>
	<div class="preloader">
		<img src="img/loader.gif" alt="Preloader image">
	</div>
	<nav class="navbar"> 
		<%@ include file="/Paciente/navUsuario.jsp"%>
	</nav>
	<header id="intro"> 
		<%@ include file="/Paciente/headerUsuario.jsp"%>
	</header>
	<!--pagina pedir cita  -->
	<div class="container section section-padded" id="pedircita">
		<div class="row text-center title">
			<h2>Pide Cita</h2>
			<h4 class="light muted">Los mejores médicos para ayudarte con
				tus necesidades</h4>
			<p class="light-muted">(haga click en reservar para seleccionar)</p>
		</div>
		<div id="citaEspecialista" class="container">
			<div class="modal-content modal-popup">
				<%@ include file="/Paciente/FormPedirCita.jsp"%>
			</div>
		</div>
	</div>
	<!-- fin pedir cita -->

	<!-- Confirmar cita -->

	
		<%@ include file="/Paciente/FormConfirmarCita.jsp" %>
		<%@ include file="/Paciente/FormModificarCita.jsp" %>

	<!-- Fin confitmar cita -->

	<!--mis citas-->
	<%@ include file="/Paciente/FormMisCitas.jsp"%>
	<!--FIN mis citas-->

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
