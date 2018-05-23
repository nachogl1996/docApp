<c:if test="${mostrarmodal1 == true}">
		<div class="modal show" id="asignarModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
</c:if>
<c:if test="${mostrarmodal1 != true}">
		<div class="modal" id="asignarModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
</c:if>
   <div class="modal-dialog" role="document">
        <div class="modal-content modal-popup">
            <h3 class="white">Modificación de cita para ${paciente.name }</h3>
            <form action="ConfirmarCitaModServlet" class="popup-form">
                <div class="modal-body">
                    Si continua cambiará la cita que tenía en la fecha ${citamod.date } con el médcio ${citamod.medico.name } por  una cita para la fecha: ${fechaparalacita } 
                    en la consulta de ${medicomod.especialidad.name } número  ${medicomod.consulta }
                     con el medico ${medicomod.name }                     
                </div>
                <textarea class="form-control" name="descripcion" id="exampleFormControlTextarea1" rows="4" placeholder="Cuente aquí que le pasa"></textarea>
	           <button type="submit" class="btn btn-submit">Confirmar cita</button>            
            </form>
            <a href="CargaCitasServletMod" class="btn btn-red">Cancelar</a>
        </div>
    </div>
</div>

	


