package es.upm.dit.isst.docapp.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.docapp.dao.CitaDAOImplementation;
import es.upm.dit.isst.docapp.dao.PacienteDAOImplementation;
import es.upm.dit.isst.docapp.dao.model.Cita;
import es.upm.dit.isst.docapp.dao.model.Medico;
import es.upm.dit.isst.docapp.dao.model.Paciente;
import es.upm.dit.isst.docapp.handlers.FechasyCitasHandler;

@WebServlet("/IncluirUrgenciaServlet")
public class IncluirUrgenciaServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//obtencion de la cita que se va a sustituir
		Cita citanti = (Cita) req.getSession().getAttribute("citadetalle");
		if(req.getParameter("pacienteurgente") == null) {
			resp.sendRedirect(req.getContextPath() + "/MedicoVerCitaServlet?cita="+citanti.getId()+"&abrir=si");
			return;
		}
		String emailp = req.getParameter("pacienteurgente");
		Paciente paciente = PacienteDAOImplementation.getInstance().readPaciente(emailp);
		Medico medico = (Medico) req.getSession().getAttribute("medico");
		
		//Creacion de nueva cita urgente
		Cita citaurg = new Cita();
		citaurg.setDate(citanti.getDate());
		citaurg.setStatus(1);
		citaurg.setDetail("paciente de urgencias");
		citaurg.setMedico(medico);
		citaurg.setPaciente(paciente);		
		CitaDAOImplementation.getInstance().createCita(citaurg);
		Date hora = citanti.getformatDate();
		Cita citanueva = null;
		Boolean sobra = false;
		int cuenta = 0;
		while(citanueva == null) {
			cuenta++;
			hora = FechasyCitasHandler.getInstance().sumarFechasDias(hora, 30);					
			if(FechasyCitasHandler.getInstance().ultimacita(citanti.getformatDate())){//Se han desplazado todas las citas y aun queda una mas
				req.getSession().setAttribute("citadetalle", citanti);
				sobra = true;
				System.out.println("\n\n\n\n\n\n\n\n\n AAAAAAAAAAA");
				break;
			} else {
				citanueva = CitaDAOImplementation.getInstance().readMedicofecha(medico.getEmail(), hora);
				citanti.setformatDate(hora);
				CitaDAOImplementation.getInstance().updateCita(citanti);
				if( citanueva != null) {			
					citanti = citanueva;
					citanueva = null;
				} else {
					break;
				}
				if(cuenta == 20) {
					System.out.println("\n\n\n\n\n\n\n\n\n AAABBBBBAAAA");
					break;
				}
			}
			
		}
		if(sobra) {			
			resp.sendRedirect(req.getContextPath() + "/CargaHorarioMedicoServlet?modifica=si&aviso=si");
		} else {
			resp.sendRedirect(req.getContextPath() + "/CargaHorarioMedicoServlet");
		}
	}
}
