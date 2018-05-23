package es.upm.dit.isst.docapp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.docapp.dao.PacienteDAOImplementation;
import es.upm.dit.isst.docapp.dao.CitaDAOImplementation;
import es.upm.dit.isst.docapp.dao.MedicoDAOImplementation;
import es.upm.dit.isst.docapp.dao.model.Paciente;
import es.upm.dit.isst.docapp.handlers.EmailHandler;
import es.upm.dit.isst.docapp.dao.model.Cita;
import es.upm.dit.isst.docapp.dao.model.Especialidad;
import es.upm.dit.isst.docapp.dao.model.Medico;
import es.upm.dit.isst.docapp.handlers.EmailHandler;

@WebServlet("/ModificarCitaServlet")
public class ModificarCitaServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String abrir= req.getParameter("abrir");
		Boolean mostrar = false;
		if(abrir.equals("si")) {
			mostrar = true;
			int idmod = Integer.parseInt(req.getParameter("citamod"));
			Cita citamod = CitaDAOImplementation.getInstance().readCita(idmod);
			Especialidad esp = citamod.getMedico().getEspecialidad();
			List<Medico> medicos = MedicoDAOImplementation.getInstance().readMedicoEspecialidad(esp.getName());
			req.getSession().setAttribute("citamod", citamod);
			req.getSession().setAttribute("msgm2", "Elija doctor/a");
			req.getSession().setAttribute("medicosmod", medicos);
			req.getSession().setAttribute("citamod", citamod);
			
			//Enviar correo electronico
			String subject = "Modificación cita para "+ citamod.getPaciente().getName() + "";
			String body = "Estimado/a " + citamod.getPaciente().getName() + ",\n\n Su cita ha sido guardada correctamente.\n" +
					 "\n   Medico: " + citamod.getMedico().getName() + 
					 "\n   Consulta nº: "+ citamod.getMedico().getConsulta() +
					 "\n   Especialidad: " + citamod.getMedico().getEspecialidad().getName() +
					 "\n   Fecha: " +citamod.getDate();
			String to = citamod.getPaciente().getEmail();
			

			EmailHandler.getInstance();
			EmailHandler.sendEmail("docapp.citas@gmail.com", to, subject, body);
		}
		
		
		req.getSession().setAttribute("mostrar", mostrar);
		
		resp.sendRedirect(req.getContextPath() + "/LoginPaciente.jsp#modifcita");

	}
}
