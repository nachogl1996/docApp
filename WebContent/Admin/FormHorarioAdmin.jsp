
<div class="col-md-2">
	<h4>
		<a href="CargaCitasAdminServlet?inicio=${fechainicio }&mover=retrocede" class="btnamplia btn-white-fill"> < </a>
	</h4>
</div>
<div class="col-md-4 col-md-offset-2">
	<h2 class="white">${mes }</h2>
</div>
<div class="col-md-2 col-md-offset-2">
	<h4>
		<a href="CargaCitasAdminServlet?&inicio=${fechainicio }&mover=avanza" class="btnamplia btn-white-fill"> > </a>
	</h4>
</div>
<div class="row section-padded">
	<div class="col-md-2">
		<h4>Hora</h4>
		<h5 class="distanciabajo">9:00</h5>
		<h5 class="distanciabajo">9:30</h5>
		<h5 class="distanciabajo">10:00</h5>
		<h5 class="distanciabajo">10:30</h5>
		<h5 class="distanciabajo">11:00</h5>
		<h5 class="distanciabajo">11:30</h5>
		<h5 class="distanciabajo">12:00</h5>
		<h5 class="distanciabajo">12:30</h5>
		<h5 class="distanciabajo">13:00</h5>
		<h5 class="distanciabajo">13:30</h5>
		<h5 class="distanciabajo">14:00</h5>
		<h5 class="distanciabajo">14:30</h5>
		<h5 class="distanciabajo">15:00</h5>
		<h5 class="distanciabajo">15:30</h5>
		<h5 class="distanciabajo">16:00</h5>
		<h5 class="distanciabajo">16:30</h5>
		<h5 class="distanciabajo">17:00</h5>
		<h5 class="distanciabajo">17:30</h5>
		<h5 class="distanciabajo">18:00</h5>
		<h5 class="distanciabajo">18:30</h5>
	</div>
	<%! int cuenta1 = 0;%>
	<%! int cuenta2 = 0; %>
	<c:forEach items="${horario}" var="cita">
		<%if (cuenta1==0){%>
			<div class="col-md-2">			
		<%}%>
		<%if (cuenta2==0 && cuenta1==0){%>
				<h4>LUN - ${imprimefechas[0] } </h4>
		<%} else if (cuenta2==1 && cuenta1==0){%>
			<h4>MAR - ${imprimefechas[1] } </h4>
		<%} else if (cuenta2==2 && cuenta1==0){%>
			<h4>MIE - ${imprimefechas[2] } </h4>
		<%} else if (cuenta2==3 && cuenta1==0){%>
			<h4>JUE - ${imprimefechas[3] } </h4>
		<%} else if (cuenta2==4 && cuenta1==0){%>
			<h4>VIE - ${imprimefechas[4] } </h4>
		<%}%>
		<c:if test="${cita.status==0 }">
			<a class="btnreducido btn-green-fill" href="AdminPedirCitaServlet?cita=${cita.date }">Asignar </a>
		</c:if>
		<c:if test="${cita.status == 1 }">
			<c:if test="${cita.paciente == null }">
				<p class="comobotonreducido">Pasada </p>
			</c:if>
			<c:if test="${cita.paciente != null }">
				<a class="btnreducido btn-yellow-fill" href="AdminVerCitaServlet?cita=${cita.id }&abrir=si">${cita.paciente.name } </a>
			</c:if>
		</c:if>
		<c:if test="${cita.status == 2 }">
			<a class="btnreducido btn-blue-fill" href="AdminVerCitaServlet?cita=${cita.id }&abrir=si">${cita.paciente.name } </a>
		</c:if>
		<c:if test="${cita.status == 3 }">
			<a class="btnreducido btn-orange-fill" href="AdminVerCitaServlet?cita=${cita.id }&abrir=si">${cita.paciente.name } </a>
		</c:if>
		<c:if test="${cita.status == 4 }">
			<a class="btnreducido btn-gray-fill" href="AdminVerCitaServlet?cita=${cita.id }&abrir=si">${cita.paciente.name } </a>
		</c:if>
		<%if (cuenta1==19){%>
			</div>
		<%}%>
		<% cuenta1 = cuenta1+1; %>
		<%if(cuenta1==20){%>
		<% cuenta1 = 0; cuenta2 = cuenta2 +1; %>
		<%}%>
	</c:forEach>
	<%cuenta1 = 0; cuenta2=0; %>	
</div>