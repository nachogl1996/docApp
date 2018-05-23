<div class="container section section-padded" id="registros">
	<div class="row  title">
		 <a class="btn btn-blue" data-toggle="collapse" href="#collapseP" role="button" aria-expanded="false" aria-controls="collapseExample">
	   		<h5>Registra a un nuevo Paciente</h5>
	  	</a>	
		<a class="btn btn-blue" data-toggle="collapse" href="#collapseM" role="button" aria-expanded="false" aria-controls="collapseExample">
			<h5>Registra a un nuevo Medico</h5>
		</a>
		<a class="btn btn-blue" data-toggle="collapse" href="#collapseE" role="button" aria-expanded="false" aria-controls="collapseExample">
			<h5>Registra una nueva especialidad</h5>
		</a>
	</div>
	<div id="registroPaciente" class="container">
		<div class="modal-content modal-popup collapse" id="collapseP">
			<form action="FormRegistroPacienteServlet" class="">
				<div class="popup-form">
					<div class="dropdown">
						<input id="nombrePaciente" type="text" class="form-control form-white" name="nameP" placeholder="Nombre"> 
						<input id="emailPaciente" type="text" class="form-control form-white" name="emailP" placeholder="Email">
						<input id="contraseñaPaciente" type="text" class="form-control form-white" name="passwordP" placeholder="Contraseña"> 
						<label for="fotoPaciente" class="btn btn-submit">Subir Imagen para Paciente</label> 
						<input id="fotoPaciente" type="file" style="display: none">
					</div>
					<button onclick="login()" type="submit" class="btn btn-submit">Registrar</button>
				</div>
			</form>
		</div>
	</div>
</div>	
<div id="registroMedico" class="container">
	<div class="modal-content modal-popup collapse" id="collapseM">
		<form action="FormRegistroMedicoServlet" class="">
			<div class="popup-form">
				<div class="dropdown">
					<input id="nombreMedico" type="text" class="form-control form-white" name="nameM" placeholder="Nombre"> 
					<input id="emailMedico" type="text" class="form-control form-white" name="emailM" placeholder="Email"> 
					<input id="contraseñaMedico" type="text" class="form-control form-white" name="passwordM" placeholder="Contraseña"> 
					<input id="consultaMedico" type="text" class="form-control form-white" name="consultaM" placeholder="Consulta"> 
					<div class="form-control form-white">
					    <label for="exampleFormControlSelect1">Seleccione especialidad</label>
					    <select class="form-control form-white" id="exampleFormControlSelect1" name="especialidadM">
					      <c:forEach items="${especialidades}" var="esp">
								<option value=${ esp.name}>${esp.name}</option>
							</c:forEach>
					    </select>
					  </div>
					<label for="fotoMedico" class="btn btn-submit">Subir Imagen para Médico</label> 
					<input id="fotoMedico" type="file" style="display: none"> 
				</div>
				<button onclick="login()" type="submit" class="btn btn-submit">Registrar</button>
			</div>
		</form>
	</div>
</div>
<div id="registroEspecialidad" class="container">
	<div class="modal-content modal-popup collapse" id="collapseE">
		<div class="popup-form">
			<div class="dropdown">
				<form action="FormRegistroEspServlet" class="">	
					<input name="nameE" type="text" class="form-control form-white"  placeholder="Nombre"> 
					<textarea name="descriptionE" type="text" class="form-control form-white" placeholder="Descripcion" rows="4"></textarea> 
					<label for="fotoespecialidad" name="photoesp" class="btn btn-submit">Subir Imagen para Especialidad</label> 
					<input id="fotoMedico" name="photoesp" type="file" style="display: none"> 				
					<button type="submit" class="btn btn-submit">Registrar</button>			
				</form>
			</div>
		</div>
	</div>
</div>
