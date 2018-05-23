
<div class="container section section-padded" id="modifcita">
		<div class="row text-center title">
			<h2>Modificar cita</h2>
			<h3><a href="ModificarCitaServlet?abrir=no">Cancelar</a></h3>
		</div>
		<div id="citaEspecialista" class="container">
			<div class="modal-content modal-popup">
				<div class="popup-form">					
					<div class="dropdown">
						<button id="dLabel" class="form-control form-white dropdown"
							type="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">${msgm2 }</button>
						<ul class="dropdown-menu animated fadeIn" role="menu" aria-labelledby="dLabel">
							<c:forEach items="${medicosmod}" var="medico2">
								<p class="animated lightSpeedIn"><a href="CargaCitasServletMod?&med=${medico2.email }"> ${medico2.name } </a></p>				
							</c:forEach>
						</ul>
					</div>					
				</div>
		<c:if test="${msgm2 != \"Elija doctor/a\"}">
			<%@ include file="Formhorario2.jsp"%>
		</c:if> 
				
			</div>
		</div>
	</div>

	