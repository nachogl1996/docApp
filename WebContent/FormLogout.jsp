<form action="LogoutServlet">
<c:if test="${suplantacion != \"paciente\" and suplantacion !=\"medico\" }">
<button type="submit"  class="btn btn-blue">Cerrar Sesi�n</button>
</c:if>
<c:if test="${suplantacion == \"paciente\" or suplantacion ==\"medico\" }">
<input type=hidden name="terminar" value="si"/>
<button type="submit"  class="btn btn-blue">Terminar gesti�n</button>
</c:if>
</form>