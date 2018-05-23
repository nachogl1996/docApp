<div class="col-md-2">
	<h4>
		<a href="CargaCitasMedicoServlet?inicio=${fechainicioesp }&mover=retrocede" class="btnamplia btn-white-fill"> < </a>
	</h4>
</div>
<div class="col-md-4 col-md-offset-2">
	<h2 class="white">${mesesp }</h2>
</div>
<div class="col-md-2 col-md-offset-2">
	<h4>
		<a href="CargaCitasMedicoServlet?&inicio=${fechainicioesp }&mover=avanza" class="btnamplia btn-white-fill"> > </a>
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
	<%! int cuenta3 = 0;%>
	<%! int cuenta4 = 0; %>
	<c:forEach items="${horarioesp}" var="cita">
		<%if (cuenta3==0){%>
			<div class="col-md-2">			
		<%}%>
		<%if (cuenta4==0 && cuenta3==0){%>
				<h4>LUN - ${imprimefechasesp[0] } </h4>
		<%} else if (cuenta4==1 && cuenta3==0){%>
			<h4>MAR - ${imprimefechasesp[1] } </h4>
		<%} else if (cuenta4==2 && cuenta3==0){%>
			<h4>MIE - ${imprimefechasesp[2] } </h4>
		<%} else if (cuenta4==3 && cuenta3==0){%>
			<h4>JUE - ${imprimefechasesp[3] } </h4>
		<%} else if (cuenta4==4 && cuenta3==0){%>
			<h4>VIE - ${imprimefechasesp[4] } </h4>
		<%}%>
		<c:if test="${cita.status==0 }">
			<a class="btnreducido btn-green-fill" href="PedirCitaMedicoServlet?cita=${cita.date }">Reservar </a>
		</c:if>
		<c:if test="${cita.status >0 }">
			<p class="comobotonreducido">Ocupada </p>
		</c:if>
		<%if (cuenta3==19){%>
			</div>
		<%}%>
		<% cuenta3 = cuenta3+1; %>
		<%if(cuenta3==20){%>
		<% cuenta3 = 0; cuenta4 = cuenta4 +1; %>
		<%}%>
	</c:forEach>
	<%cuenta3 = 0; cuenta4=0; %>	
</div>