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


import es.upm.dit.isst.docapp.dao.CitaDAOImplementation;
import es.upm.dit.isst.docapp.dao.MedicoDAOImplementation;
import es.upm.dit.isst.docapp.dao.model.Cita;
import es.upm.dit.isst.docapp.dao.model.Medico;
import es.upm.dit.isst.docapp.handlers.EmailHandler;

@WebServlet("/MedicoModificarConsultaServlet")
public class MedicoModificarConsultaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fecha = req.getParameter("cita");
		Cita cita = (Cita) req.getSession().getAttribute("citadetalle");
		cita.setDate(fecha);
		Medico medico = (Medico) req.getSession().getAttribute("medicomod1");
		cita.setMedico(medico);
		CitaDAOImplementation.getInstance().updateCita(cita);
		
		
		//Enviar correo electronico
		String subject = "Modificaci�n cita para "+ cita.getPaciente().getName() + "";
		String body = "Estimado/a " + cita.getPaciente().getName() + ",\n\n Su cita ha sido modificada correctamente.\n" +
				 "\n   Medico: " + cita.getMedico().getName() + 
				 "\n   Consulta n�: "+ cita.getMedico().getConsulta() +
				 "\n   Especialidad: " + cita.getMedico().getEspecialidad().getName() +
				 "\n   Fecha: " +cita.getDate();
		String to = cita.getPaciente().getEmail();
		

		EmailHandler.getInstance();
		EmailHandler.sendEmail("docapp.citas@gmail.com", to, subject, body);
		
		resp.sendRedirect(req.getContextPath() + "/CargaHorarioMedicoServlet");
	}
}
