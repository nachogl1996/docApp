<form action="MedicoConsultaServlet" class="popup-form">
		<p>Fecha y hora: ${citadetalle.date }</p>
		<p>Mensaje: ${citadetalle.detail }</p>
	<c:if test="${citadetalle.status < 3 and citadetalle.date < fechahoyfindetalle and citadetalle.date > fechahoydetalle }">
		<button type="submit" class="btn btn-submit">Iniciar consulta</button>	
	</c:if>
	<c:if test="${citadetalle.status == 3 }">
		<textarea class="form-control" name="descripcion" id="exampleFormControlTextarea1" rows="4" placeholder="Anotaciones de la consulta"></textarea>
		<button type="submit" class="btn btn-submit">Finalizar consulta</button>	
	</c:if>
</form>
	<a class="btn" href="MedicoMostrarHistorialServlet">Ver historial</a>
	<c:if test="${citadetalle.status < 3 }">
		<a href="CargaHorarioMedicoServlet?modifica=si" class="btn">Modificar cita</a>
	</c:if>
	<c:if test="${citadetalle.status < 3  }">
		<form action="IncluirUrgenciaServlet" class="popup-form form-control form-white">
			<select name="pacienteurgente" class="form-control form-white">
			<option value="" disabled selected>Elija un paciente</option>
			<c:forEach items="${pacientes}" var="pacientei">
				<option value=${ pacientei.email}>${pacientei.name } - ${pacientei.email }</option>
			</c:forEach>
			</select>
			<button type="submit" class="btn">Incluir urgencia</button>
		</form>
	</c:if>
	<a href="CargaHorarioMedicoServlet" class="btn">Cerrar</a>