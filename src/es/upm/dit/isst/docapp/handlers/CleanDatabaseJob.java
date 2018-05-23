package es.upm.dit.isst.docapp.handlers;

import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import es.upm.dit.isst.docapp.dao.CitaDAO;
import es.upm.dit.isst.docapp.dao.CitaDAOImplementation;
import es.upm.dit.isst.docapp.dao.model.Cita;

public class CleanDatabaseJob implements Job {
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		CitaDAO dao = CitaDAOImplementation.getInstance();
		Date date = new Date();
		date = FechasyCitasHandler.getInstance().semanatras(date);
		List<Cita> citas = dao.readCitamenorFecha(date);
		if(citas != null &&  !citas.isEmpty()) {
			for(Cita cita : citas) {
				dao.deleteCita(cita);
			}
		} else {
			System.out.println("NO HAY CITAS PARA BORRAR");
		}
	}


}
