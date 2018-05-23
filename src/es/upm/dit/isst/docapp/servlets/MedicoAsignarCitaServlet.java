package es.upm.dit.isst.docapp.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.docapp.dao.PacienteDAOImplementation;
import es.upm.dit.isst.docapp.dao.CitaDAOImplementation;
import es.upm.dit.isst.docapp.dao.EspecialidadDAOImplementation;
import es.upm.dit.isst.docapp.dao.MedicoDAOImplementation;
import es.upm.dit.isst.docapp.dao.model.Paciente;
import es.upm.dit.isst.docapp.dao.model.Cita;
import es.upm.dit.isst.docapp.dao.model.Especialidad;
import es.upm.dit.isst.docapp.dao.model.Medico;
import es.upm.dit.isst.docapp.handlers.EmailHandler;

@WebServlet("/MedicoAsignarCitaServlet")
public class MedicoAsignarCitaServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pacientemail = req.getParameter("paciente");
		Paciente paciente =PacienteDAOImplementation.getInstance().readPaciente(pacientemail);
		Medico medico = (Medico) req.getSession().getAttribute("medico");
		String fechaparalacita = (String) req.getSession().getAttribute("fechacita");
		String descripcion = req.getParameter("descripcion");
		Cita cita = new Cita();		
		cita.setDate(fechaparalacita);
		cita.setDetail(descripcion);
		cita.setMedico(medico);
		cita.setPaciente(paciente);
		cita.setStatus(1);
		CitaDAOImplementation.getInstance().createCita(cita);
		//Enviar correo electronico
		String subject = "Confirmación cita para "+ cita.getPaciente().getName() + "";
		String body = "Estimado/a " + cita.getPaciente().getName() + ",\n\n Su cita ha sido guardada correctamente.\n" +
				 "\n   Medico: " + cita.getMedico().getName() + 
				 "\n   Consulta nº: "+ cita.getMedico().getConsulta() +
				 "\n   Especialidad: " + cita.getMedico().getEspecialidad().getName() +
				 "\n   Fecha: " +cita.getDate();
		String to = cita.getPaciente().getEmail();
		

		EmailHandler.getInstance();
		EmailHandler.sendEmail("docapp.citas@gmail.com", to, subject, body);
	
		
		resp.sendRedirect(req.getContextPath() + "/CargaHorarioMedicoServlet");
	}
}
