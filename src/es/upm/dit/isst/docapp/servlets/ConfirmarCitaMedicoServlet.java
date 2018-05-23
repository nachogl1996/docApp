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
import es.upm.dit.isst.docapp.dao.EspecialidadDAOImplementation;
import es.upm.dit.isst.docapp.dao.MedicoDAOImplementation;
import es.upm.dit.isst.docapp.dao.PacienteDAOImplementation;
import es.upm.dit.isst.docapp.dao.model.Cita;
import es.upm.dit.isst.docapp.dao.model.Especialidad;
import es.upm.dit.isst.docapp.dao.model.Medico;
import es.upm.dit.isst.docapp.dao.model.Paciente;
import es.upm.dit.isst.docapp.handlers.EmailHandler;

@WebServlet("/ConfirmarCitaMedicoServlet")
public class ConfirmarCitaMedicoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Paciente paciente = (Paciente) req.getSession().getAttribute("paciente");
		Medico medico = (Medico) req.getSession().getAttribute("medicoesp");
		String fechaparalacita = (String) req.getSession().getAttribute("fechaparalacita");
		String descripcion = req.getParameter("descripcion");
		Cita cita = new Cita();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date fecha = new Date();
		try {
			fecha  = formato.parse(fechaparalacita);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ha habido un error al cambiar de string a date");
		}
		cita.setformatDate(fecha);
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