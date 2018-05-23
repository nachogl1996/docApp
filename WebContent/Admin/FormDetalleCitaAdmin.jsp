<form action="CargaCitasAdminServlet" class="popup-form">
	<div class="modal-body">
		<p>Fecha y hora: ${citadetalle.date }</p>
		Mensaje: ${citadetalle.detail }
	</div>
	<c:if test="${citadetalle.status < 3 and citadetalle.date < fechahoyfindetalle and citadetalle.date > fechahoydetalle }">
		<button type="submit" class="btn btn-submit">Iniciar consulta</button>	
	</c:if>
	<c:if test="${citadetalle.status == 3 }">
		<textarea class="form-control" name="descripcion" id="exampleFormControlTextarea1" rows="4" placeholder="Anotaciones de la consulta"></textarea>
		<button type="submit" class="btn btn-submit">Finalizar consulta</button>	
	</c:if>
</form>
	<a class="btn btn-submit" href="MedicoMostrarHistorialServlet">Ver historial</a>
	<c:if test="${citadetalle.status < 3 }">
		<a href="CargaHorarioModificarAdminServlet?modifica=si&cita=${citadetalle}" class="btn btn-submit">Modificar cita</a>
	</c:if>
	<a href="CargaCitasAdminServlet" class="btn btn-red">Cerrar</a>