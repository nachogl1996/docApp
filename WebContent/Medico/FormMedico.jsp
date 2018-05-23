<!--vista con horario del medico  -->
<div id="mihorario">
	<div class="container section-padded section">
		<div class="row text-center title">
			<h2>Gestione su horario</h2>
		</div>
		<div class="modal-popup">
		<c:if test="${modificando != true}">		
			<%@ include file="/Medico/HorarioMedico.jsp"%>
		</c:if>
		<c:if test="${modificando == true}">			
			<%@ include file="/Medico/HorarioModificarCitaMedico.jsp"%>
		</c:if>
		</div>
	</div>
</div>
<!-- fin pedir cita atención primaria -->

<!-- Detalle cita -->
<c:if test="${mostrarmodalmedicodetalle == true}">
		<div class="modal show" id="detalleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
</c:if>
<c:if test="${mostrarmodalmedicodetalle != true}">
		<div class="modal " id="detalleModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
</c:if>
	<div class="modal-dialog" role="document">		
		<div class="modal-content modal-popup" role="document">	
			<a href="CargaHorarioMedicoServlet" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </a>	
			<h4 class="white">Cita con ${citadetalle.paciente.name } </h4>			
			<%@ include file="FormDetalleCita.jsp"%>
		</div>
	</div>
</div>

<!-- Fin detalle cita -->



<!--pagina pedir nuevas citas o interconsultas  -->
<div id="nuevacita">
	<div class="container section section-padded">
		<div class="row text-center title">
			<h2>Gestione una nueva cita con su paciente</h2>
			<h4 class="light muted">Con usted o con otro médico</h4>
		</div>
		<div class="modal-popup">
			<h3 class="white">Nueva cita</h3>
			<p class="light-white">(haga click en Reservar para seleccionar)</p>
			<%@ include file="FormPedirCitaMedico.jsp"%>
		</div>
	</div>

</div>
<!--fin pagina pedir cita especialistas  -->



<!-- Confirmar cita -->

	
		<%@ include file="FormConfirmarCitaMedico.jsp" %>

	<!-- Fin confitmar cita -->



<!-- Fin confitmar cita -->










