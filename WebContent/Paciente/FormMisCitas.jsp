<!--mis citas-->
<section id="misCitas" class="section">
<div class="container">
	<div class="row text-center title">
		<h2>Mis Citas</h2>
		<h4 class="light muted">Revisa tus citas próximas</h4>
	</div>
	<div class="row section">
	<c:forEach items="${citaspaciente}" var="micita">
		<div class="col-md-4">
			<div class="modal-dialog">
				<div class="modal-content modal-popup">
					<h4 class="white">Medico: ${micita.medico.name }</h4>
					<h5 class="white">Especialidad: ${micita.medico.especialidad.name }</h5>
					<h5 class="white">Fecha: ${micita.date }</h5>
					<h5 class="white">Número de consulta: ${micita.medico.consulta }</h5>
					<a class="btn btn-submit" href="DetalleCitaServlet?cita=${micita.id }&abrir=si">Detalles</a>
					<c:if test="${micita.status == 1 and micita.date < diahoyconfirmar }">						
						<a class="btn btn-green-fill" href="Confirmarllegada?cita=${micita.id }">Confirmar llegada</a>
					</c:if>
					<c:if test="${micita.status >= 2 }">						
						<a class="btn btn-green-fill" href="PacienteObtenerJustificanteServlet?cita=${micita.id }">Obtener justificante</a>
					</c:if>
					<c:if test="${micita.status == 1 and micita.date > diahoyconfirmar }">
						<a href="ModificarCitaServlet?citamod=${micita.id}&abrir=si" class="btn btn-yellow-fill">Modificar cita</a> 
					</c:if>
					
					<a href="CancelarCitaServlet?cita=${micita.id}&email=${paciente.email }&password=${paciente.password }"  class="btn btn-red-fill">Cancelar</a>					
				</div>
			</div>
		</div>
	</c:forEach>	
	</div>
</div>

	<c:if test="${mostrar == true}">
		<%@ include file="FormModif2.jsp"%>
	</c:if>
	

</section>
<!--fin mis citas-->


<!-- Detalle cita -->
<c:if test="${mostrarmodal2 == true}">
		<div class="modal show" id="detalleModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
</c:if>
<c:if test="${mostrarmodal2 != true}">
		<div class="modal " id="detalleModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
</c:if>
	<div class="modal-dialog">
		<div class="modal-content modal-popup">
			<h3 class="white">Cita con ${citadetalle.medico.name } </h3>
			<form action="DetalleCitaServlet" class="popup-form">
				<input type="hidden" name="abrir" value="no"/>
				<h4>Paciente: ${citadetalle.paciente.name }</h2>
				<h6>Fecha de la cita: ${citadetalle.date }</h2>
				<h5>Especialidad: ${citadetalle.medico.especialidad.name }</h5>
				<h6>Numero de consulta: ${citadetalle.medico.consulta }</h6>				
				<div class="modal-body">Descripcion: ${citadetalle.detail }</div>
				<button type="submit" class="btn btn-red-fill">Cerrar</button>
			</form>
		</div>
	</div>
</div>



<!-- Fin detalle cita -->
