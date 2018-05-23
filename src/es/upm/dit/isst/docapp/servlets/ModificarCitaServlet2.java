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
import es.upm.dit.isst.docapp.dao.model.Cita;
import es.upm.dit.isst.docapp.dao.model.Medico;

@WebServlet("/ModificarCitaServlet2")
public class ModificarCitaServlet2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idmod = Integer.parseInt(req.getParameter("citamod"));
		String emailmod = req.getParameter("emailmod");
		String passwordmod = req.getParameter("passwordmod");
		Paciente pacientemod = PacienteDAOImplementation.getInstance().loginPaciente(emailmod, passwordmod);
		Cita citamod;
		String especialidadps = req.getParameter("esp");
		List<Medico> medicos = MedicoDAOImplementation.getInstance().readMedicoEspecialidad(especialidadps);
		String msge = especialidadps;
		
		String abrir= req.getParameter("abrir");
		Boolean mostrar = false;
		if(abrir.equals("si")) {
			mostrar = true;
		}
		
		//citamod = CitaDAOImplementation.getInstance().readCita(idmod);
		//citamod.setStatus(0);
		//CitaDAOImplementation.getInstance().deleteCita(citamod);
		List<Cita> citaspacientemod = CitaDAOImplementation.getInstance().readPacienteCitas(pacientemod.getEmail());
		req.getSession().setAttribute("citaspacientemod", citaspacientemod);
		req.getSession().setAttribute("msge", especialidadps);
		req.getSession().setAttribute("medicos", medicos);
		req.getSession().setAttribute("mostrar", mostrar);
		resp.sendRedirect(req.getContextPath() + "/LoginPaciente.jsp#modifcita");
		
		
		
			
		
		
		

	}
}
