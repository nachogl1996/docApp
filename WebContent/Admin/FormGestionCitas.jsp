<div class="container section section-padded" id="gestioncitas">
	<div class="row text-center title">
		<h2>Gestione Citas</h2>
		<h4 class="light muted">Desde aquí puede gestionar incidencias en
			una consulta o especialidad y ayudar a los pacientes a gestionar sus
			citas</h4>
	</div>
	<div class="modal-popup section">
		<div class="row">
			<div class="col-md-5">
				<div class="popup-form">
					<input type="text" class="form-control form-white"
						placeholder="especialidad/paciente/médico">
				</div>
			</div>			
		</div>
		<div class="row">
			<c:forEach items="${pacientes}" var="paciente">
				<div class="col-md-4">
					<div class="team text-center">
						<img src="img/paciente.jpg" alt="Foto de paciente" class="avatar">
						<div class="title">
							<h4>${paciente.name }</h4>
							<h5 class="muted regular">${paciente.email }</h5>
							<a class="btn btn-blue" href="AdmininiciaGestion?usuario=${paciente.email }">Gestionar citas</a>
						</div>
					</div>
				</div>
			</c:forEach>
			<c:forEach items="${medicos}" var="medicoi">
				<div class="col-md-4">
					<div class="team text-center">
						<img src="${medicoi.urlfoto }" alt="Team Image" class="avatar">
						<div class="title">
							<h4>${medicoi.name }</h4>
							<h5 class="muted regular">Especialista en ${medicoi.especialidad.name }</h5>
							<a class="btn btn-blue" href="AdmininiciaGestion?usuario=${medicoi.email }">Gestionar citas</a>
						</div>
					</div>
				</div>	
			</c:forEach>		
		</div>
	</div>
</div>