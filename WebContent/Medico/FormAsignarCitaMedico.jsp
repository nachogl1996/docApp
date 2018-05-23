<c:if test="${muestramodalconfirmarmod == true}">
		<div class="modal show" id="asignarModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
</c:if>
<c:if test="${muestramodalconfirmarmod != true}">
		<div class="modal" id="asignarModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
</c:if>
   <div class="modal-dialog" role="document">
        <div class="modal-content modal-popup">
            <h3 class="white">Asignación de cita para la fecha: ${fechacita }</h3>
            <form action="MedicoAsignarCitaServlet" class="popup-form">
                <div class="modal-body">
                	<div class="form-control form-white">
					    <label for="exampleFormControlSelect1">Seleccione paciente</label>
					    <select class="form-control form-white" id="exampleFormControlSelect1" name="paciente">
					      <c:forEach items="${pacientes}" var="paciente">
								<option value=${ paciente.email}>${paciente.name}</option>
							</c:forEach>
					    </select>
					  </div>
                    <textarea class="form-control" name="descripcion" id="exampleFormControlTextarea1" rows="4" placeholder="Cuente aquí los motivos"></textarea>
                </div>
                <button type="submit" class="btn btn-submit">Confirmar cita</button>                
            </form>
            <a href="CargaHorarioMedicoServlet" class="btn btn-red">Cancelar</a>
        </div>
    </div>
</div>

	


