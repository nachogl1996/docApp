<div id="gestionespecialidad">
	<div class="container section section-padded">
		<div class="row text-center title">
			<h2>Gestione citas de una especialidad</h2>
		</div>
		<div class="modal-popup">
			<h3 class="white">Citas de [Especialidad]</h3>
			<p class="light-white">(haga click en Reservar para seleccionar)</p>
			<form action="" class="">
				<div class="popup-form">
					<div class="dropdown">
						 <button id="dLabel" class="form-control form-white dropdown"
							type="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">${msge }</button>
							<ul class="dropdown-menu animated fadeIn" role="menu" aria-labelledby="dLabel">
								<c:forEach items="${especialidades}" var="esp">
									<p class="animated lightSpeedIn"><a href="UsuarioEspecialidadServletAdmin?&esp=${esp.name }"> ${esp.name } </a></p>				
								</c:forEach>
							</ul>
					</div>
					<div class="dropdown">
						<button id="dLabel" class="form-control form-white dropdown"
						type="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">${msgm }</button>
						<ul class="dropdown-menu animated fadeIn" role="menu" aria-labelledby="dLabel">
							<c:forEach items="${medicos}" var="medico">
					<p class="animated lightSpeedIn"><a href="CargaCitasAdminServlet?&med=${medico.email }"> ${medico.name } </a></p>				
							</c:forEach>
						</ul>
					</div>
				</div>
			
				<c:if test="${msgm != \"Elija doctor/a\"}">		
					<div id="mihorario">
							<c:if test="${modificando == true}">	
							<div class="modal-popup">		
							<%@ include file="/Admin/HorarioModificarCitaAdmin.jsp"%>
							</div>
							</c:if>	
							<c:if test="${modificando != true}">	
							<div class="modal-popup">		
								<%@ include file="FormHorarioAdmin.jsp"%>
							</div>
							</c:if>		
						
					</div>
				</c:if>
			</form>
		</div>
	</div>
	<c:if test="${mostrarmodaldetalle == true}">
		<div class="modal show" id="detalleModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

			<div class="modal-dialog">
				<div class="modal-content modal-popup">
					<h3 class="white">Cita con ${citadetalle.paciente.name } </h3>
					<%@ include file="FormDetalleCitaAdmin.jsp"%>
				</div>
			</div>
		</div>
</c:if>

<c:if test="${muestramodalconfirmar == true}">
		<div class="modal show" id="asignarModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-dialog" role="document">
        <div class="modal-content modal-popup">
            <h3 class="white">Asignación de cita para la fecha: ${fechacita }</h3>
            <form action="ConfirmarCitaAdminServlet?medico=${msgm }" class="popup-form">
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
            <a href="CargaCitasAdminServlet" class="btn btn-red">Cancelar</a>
        </div>
    </div>
</div>
</c:if>
</div>
