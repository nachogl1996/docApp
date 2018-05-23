package es.upm.dit.isst.docapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.docapp.dao.PacienteDAOImplementation;
import es.upm.dit.isst.docapp.dao.model.Admin;
import es.upm.dit.isst.docapp.dao.model.Paciente;

@WebServlet("/FormRegistroPacienteServlet")
public class FormRegistroPacienteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("nameP");
		String email = req.getParameter("emailP");
		String password = req.getParameter("passwordP");
		String urlphoto = "img/paciente.jpeg";
		Paciente paciente = new Paciente();
		paciente.setEmail(email);
		paciente.setName(name);
		paciente.setPassword(password);
		paciente.setUrlfoto(urlphoto);
		PacienteDAOImplementation.getInstance().createPaciente(paciente);		
		resp.sendRedirect(req.getContextPath() + "/LoginAdmin.jsp");
		
	}
}
