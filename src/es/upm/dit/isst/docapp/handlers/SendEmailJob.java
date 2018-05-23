package es.upm.dit.isst.docapp.handlers;

import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import es.upm.dit.isst.docapp.dao.CitaDAO;
import es.upm.dit.isst.docapp.dao.CitaDAOImplementation;
import es.upm.dit.isst.docapp.dao.model.Cita;
public class SendEmailJob implements Job {
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		CitaDAO dao = CitaDAOImplementation.getInstance();
		Date date = new Date();
		date = FechasyCitasHandler.getInstance().nueve(date);
		Date date2 = FechasyCitasHandler.getInstance().sumarFechasDias(date, 60*24);
		List<Cita> citas = dao.readCitaFechas(date, date2);
		if(citas != null &&  !citas.isEmpty()) {
			for(Cita cita : citas) {
				System.out.println("Mandar email a "+ cita.getPaciente().getEmail());
				//Enviar correo electronico
				String subject = "Recordatorio cita para "+ cita.getPaciente().getName() + "";
				String body = "Aviso de recordatorio automático de cita: \n" +
						 "\n   Medico: " + cita.getMedico().getName() + 
						 "\n   Consulta nº: "+ cita.getMedico().getConsulta() +
						 "\n   Especialidad: " + cita.getMedico().getEspecialidad().getName() +
						 "\n   Fecha: " +cita.getDate();
				String to = cita.getPaciente().getEmail();
				

				EmailHandler.getInstance();
				EmailHandler.sendEmail("docapp.citas@gmail.com", to, subject, body);
				
			}
		} else {
			System.out.println("NO HAY CITAS PARA BORRAR");
		}
	}
}
