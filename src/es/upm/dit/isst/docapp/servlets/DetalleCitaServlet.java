package es.upm.dit.isst.docapp.servlets;

import java.io.IOException;

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

@WebServlet("/DetalleCitaServlet")
public class DetalleCitaServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String abrir= req.getParameter("abrir");
		Boolean mostrar = false;
		if(abrir.equals("si")) {
			int id = Integer.parseInt(req.getParameter("cita"));
			Cita cita = CitaDAOImplementation.getInstance().readCita(id);
			req.getSession().setAttribute("citadetalle", cita);
			mostrar = true;
		}
		
		req.getSession().setAttribute("mostrarmodal2", mostrar);
		resp.sendRedirect(req.getContextPath() + "/LoginPaciente.jsp");
	}
}