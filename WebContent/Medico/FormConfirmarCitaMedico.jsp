<c:if test="${mostrarmodal == true}">
		<div class="modal show" id="asignarModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
</c:if>
<c:if test="${mostrarmodal != true}">
		<div class="modal" id="asignarModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
</c:if>
   <div class="modal-dialog" role="document">
        <div class="modal-content modal-popup">
            <h3 class="white">Asignaci�n de cita para ${paciente.name }</h3>
            <form action="ConfirmarCitaMedicoServlet" class="popup-form">
                <div class="modal-body">
                    Si continua reservara una cita para la fecha: ${fechaparalacita } 
                    en la consulta de ${medicoesp.especialidad.name } n�mero  ${medicoesp.consulta }
                     con el medico ${medicoesp.name } para el paciente ${paciente.name }
                    <textarea class="form-control" name="descripcion" id="exampleFormControlTextarea1" rows="4" placeholder="Cuente aqu� que le pasa"></textarea>
                </div>
                <button type="submit" class="btn btn-submit">Confirmar cita</button>                
            </form>
            <a href="CargaCitasMedicoServlet" class="btn btn-red">Cancelar</a>
        </div>
    </div>
</div>

	