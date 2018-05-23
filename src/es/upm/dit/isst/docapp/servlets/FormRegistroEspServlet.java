package es.upm.dit.isst.docapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.docapp.dao.PacienteDAOImplementation;
import es.upm.dit.isst.docapp.dao.AdminDAOImplementation;
import es.upm.dit.isst.docapp.dao.EspecialidadDAOImplementation;
import es.upm.dit.isst.docapp.dao.MedicoDAOImplementation;
import es.upm.dit.isst.docapp.dao.model.Paciente;
import es.upm.dit.isst.docapp.dao.model.Admin;
import es.upm.dit.isst.docapp.dao.model.Especialidad;
import es.upm.dit.isst.docapp.dao.model.Medico;

@WebServlet("/FormRegistroEspServlet")
public class FormRegistroEspServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("nameE");
		String description = req.getParameter("descriptionE");
		String urlfoto = "img/icons/iconocardio.jpeg";
		System.out.println(name);
		Especialidad esp = new Especialidad();
		esp.setName(name);
		esp.setDescription(description);
		esp.setUrlfoto(urlfoto);
		EspecialidadDAOImplementation.getInstance().createEspecialidad(esp);		
		resp.sendRedirect(req.getContextPath() + "/LoginAdmin.jsp");
		
	}

}
