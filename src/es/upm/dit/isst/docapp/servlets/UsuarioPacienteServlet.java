package es.upm.dit.isst.docapp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.docapp.dao.MedicoDAOImplementation;
import es.upm.dit.isst.docapp.dao.PacienteDAOImplementation;
import es.upm.dit.isst.docapp.dao.model.Medico;
import es.upm.dit.isst.docapp.dao.model.Paciente;

@WebServlet("/UsuarioPacienteServlet")
public class UsuarioPacienteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pacienteps = req.getParameter("paciente");
		String msgp = pacienteps;
		Paciente paciente = PacienteDAOImplementation.getInstance().readPaciente(pacienteps);
		req.getSession().setAttribute("msgp", msgp);
		req.getSession().setAttribute("paciente", paciente);
		resp.sendRedirect(req.getContextPath() + "/LoginMedico.jsp#nuevacita");
	}

}
