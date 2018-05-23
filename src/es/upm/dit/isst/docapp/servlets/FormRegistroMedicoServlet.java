package es.upm.dit.isst.docapp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import es.upm.dit.isst.docapp.dao.EspecialidadDAOImplementation;
import es.upm.dit.isst.docapp.dao.MedicoDAOImplementation;
import es.upm.dit.isst.docapp.dao.model.Especialidad;
import es.upm.dit.isst.docapp.dao.model.Medico;

@WebServlet("/FormRegistroMedicoServlet")
public class FormRegistroMedicoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("nameM");
		String email = req.getParameter("emailM");
		String password = req.getParameter("passwordM");
		String consulta = req.getParameter("consultaM");
		String especialidadn = req.getParameter("especialidadM");
		Especialidad especialidad = EspecialidadDAOImplementation.getInstance().readEspecialidad(especialidadn);
		String urlfoto = "img/cardiologo.jpeg";
		Medico medico = new Medico();
		medico.setName(name);
		medico.setEmail(email);
		medico.setPassword(password);		
		medico.setConsulta(consulta);
		medico.setEspecialidad(especialidad);
		medico.setUrlfoto(urlfoto);
		List<Medico> medicose = especialidad.getMedicos();
		medicose.add(medico);
		especialidad.setMedicos(medicose);
		MedicoDAOImplementation.getInstance().createMedico(medico);
		EspecialidadDAOImplementation.getInstance().updateEspecialidad(especialidad);
		resp.sendRedirect(req.getContextPath() + "/LoginAdmin.jsp");
	}

}
