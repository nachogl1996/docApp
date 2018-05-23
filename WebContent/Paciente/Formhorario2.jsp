<div class="col-md-2">
	<h4>
		<a href="CargaCitasServletMod?inicio=${fechainiciomod }&mover=retrocede" class="btnamplia btn-white-fill"> < </a>
	</h4>
</div>
<div class="col-md-4 col-md-offset-2">
	<h2 class="white">${mesmod }</h2>
</div>
<div class="col-md-2 col-md-offset-2">
	<h4>
		<a href="CargaCitasServletMod?inicio=${fechainiciomod }&mover=avanza" class="btnamplia btn-white-fill"> > </a>
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
	<%! int cuen1 = 0;%>
	<%! int cuen2 = 0; %>
	<c:forEach items="${horariomod }" var="cita">
		<%if (cuen1==0){%>
			<div class="col-md-2">			
		<%}%>
		<%if (cuen2==0 && cuen1==0){%>
			<h4>LUN - ${imprimefechasmod[0] } </h4>
		<%} else if (cuen2==1 && cuen1==0){%>
			<h4>MAR - ${imprimefechasmod[1] } </h4>
		<%} else if (cuen2==2 && cuen1==0){%>
			<h4>MIE - ${imprimefechasmod[2] } </h4>
		<%} else if (cuen2==3 && cuen1==0){%>
			<h4>JUE - ${imprimefechasmod[3] } </h4>
		<%} else if (cuen2==4 && cuen1==0){%>
			<h4>VIE - ${imprimefechasmod[4] } </h4>
		<%}%>
		<c:if test="${cita.status==0 }">
			<a class="btnreducido btn-green-fill" href="PedirCitaServlet2?fechamod=${cita.date }">Reservar </a>
		</c:if>
		<c:if test="${cita.status >0 }">
			<p class="comobotonreducido">Ocupada </p>
		</c:if>
		<%if (cuen1==19){%>
			</div>
		<%}%>
		<% cuen1 = cuen1+1; %>
		<%if(cuen1==20){%>
		<% cuen1 = 0; cuen2 = cuen2 +1; %>
		<%}%>
	</c:forEach>
	<%cuen1 = 0; cuen2=0; %>	
</div>