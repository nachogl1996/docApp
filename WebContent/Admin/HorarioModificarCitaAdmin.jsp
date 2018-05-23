<div class="row text-center title">
	<h3 class="white">Mi consulta, cita para ${citadetalle.paciente.name } </h3>
	<p class="light-white">(haga click en la casilla de la cita que desee para ${citadetalle.paciente.name })</p>
</div>
<div class="col-md-2">
	<h4>
		<a href="CargaHorarioMedicoServlet?inicio=${fechainicio }&mover=retrocede&modifica=si" class="btnamplia btn-white-fill"> < </a>
	</h4>
</div>
<div class="col-md-4 col-md-offset-2">
	<h2 class="white">${mes }</h2>
</div>
<div class="col-md-2 col-md-offset-2">
	<h4>
		<a href="CargaHorarioMedicoServlet?&inicio=${fechainicio }&mover=avanza&modifica=si" class="btnamplia btn-white-fill"> > </a>
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
	<%! int cuenta11 = 0;%>
	<%! int cuenta22 = 0; %>
	<c:forEach items="${horario}" var="cita">
		<%if (cuenta11==0){%>
			<div class="col-md-2">			
		<%}%>
		<%if (cuenta22==0 && cuenta11==0){%>
				<h4>LUN - ${imprimefechas[0] } </h4>
		<%} else if (cuenta22==1 && cuenta11==0){%>
			<h4>MAR - ${imprimefechas[1] } </h4>
		<%} else if (cuenta22==2 && cuenta11==0){%>
			<h4>MIE - ${imprimefechas[2] } </h4>
		<%} else if (cuenta22==3 && cuenta11==0){%>
			<h4>JUE - ${imprimefechas[3] } </h4>
		<%} else if (cuenta22==4 && cuenta11==0){%>
			<h4>VIE - ${imprimefechas[4] } </h4>
		<%}%>
		<c:if test="${cita.status==0 }">
			<a class="btnreducido btn-green-fill" href="MedicoModificarConsultaServlet?cita=${cita.date }&modifica=si">Asignar </a>
		</c:if>
		<c:if test="${cita.status >0 }">			
				<p class="comobotonreducido">No disponible </p>
		</c:if>
		<%if (cuenta11==19){%>
			</div>
		<%}%>
		<% cuenta11 = cuenta11+1; %>
		<%if(cuenta11==20){%>
		<% cuenta11 = 0; cuenta22 = cuenta22 +1; %>
		<%}%>
	</c:forEach>
	<%cuenta11 = 0; cuenta22=0; %>	
</div>
<a href="CargaHorarioMedicoServlet" class = "btn btn-red">Cancelar</a>