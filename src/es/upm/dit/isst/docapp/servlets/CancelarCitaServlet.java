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

@WebServlet("/CancelarCitaServlet")
public class CancelarCitaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("cita"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Paciente paciente = PacienteDAOImplementation.getInstance().loginPaciente(email, password);
		Cita cita;
		cita = CitaDAOImplementation.getInstance().readCita(id);
		CitaDAOImplementation.getInstance().deleteCita(cita);
		List<Cita> citaspaciente = CitaDAOImplementation.getInstance().readPacienteCitas(paciente.getEmail());
		//Enviar correo electronico
		String subject = "Cancelación cita para "+paciente.getName();
		String body = "Estimado/a " + paciente.getName() + ",\n\n Su cita ha sido cancelada.\n" +
				 "\n   Medico: " + cita.getMedico().getName() + 
				 "\n   Especialidad: "+cita.getMedico().getEspecialidad().getName() +
				 "\n   Fecha: " +cita.getDate();
		String to = paciente.getEmail();
		EmailHandler.getInstance();
		EmailHandler.sendEmail("docapp.citas@gmail.com", to, subject, body);
		req.getSession().setAttribute("citaspaciente", citaspaciente);
		resp.sendRedirect(req.getContextPath() + "/LoginPaciente.jsp#misCitas");
		


	}
}