package es.upm.dit.isst.docapp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.docapp.dao.CitaDAOImplementation;
import es.upm.dit.isst.docapp.dao.model.Cita;
import es.upm.dit.isst.docapp.dao.model.Paciente;

@WebServlet("/Confirmarllegada")
public class PacienteConfirmarllegada extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("cita"));
		Cita cita = (Cita) CitaDAOImplementation.getInstance().readCita(id);
		cita.setStatus(2);
		CitaDAOImplementation.getInstance().updateCita(cita);
		Paciente paciente = (Paciente) req.getSession().getAttribute("paciente");
		List<Cita> citaspaciente = CitaDAOImplementation.getInstance().readPacienteCitas(paciente.getEmail());
		req.getSession().setAttribute("citaspaciente", citaspaciente);
		resp.sendRedirect(req.getContextPath() + "/LoginPaciente.jsp");
	}

}
