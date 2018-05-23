
	<div class="popup-form">
		<div class="dropdown">		
			<button id="dLabel" class="form-control form-white dropdown"
				type="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">${msge }</button>
			<ul class="dropdown-menu animated fadeIn" role="menu" aria-labelledby="dLabel">
				<c:forEach items="${especialidades}" var="esp">
					<p class="animated lightSpeedIn"><a href="UsuarioEspecialidadServlet?&esp=${esp.name }"> ${esp.name } </a></p>				
				</c:forEach>
			</ul>
		</div>
		<div class="dropdown">
			<button id="dLabel" class="form-control form-white dropdown"
				type="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">${msgm }</button>
			<ul class="dropdown-menu animated fadeIn" role="menu" aria-labelledby="dLabel">
				<c:forEach items="${medicos}" var="medico">
					<p class="animated lightSpeedIn"><a href="CargaCitasServlet?&med=${medico.email }"> ${medico.name } </a></p>				
				</c:forEach>
			</ul>
		</div>
	</div>
	<c:if test="${msgm != \"Elija doctor/a\"}">		
		<%@ include file="Formhorario.jsp" %>
	</c:if>