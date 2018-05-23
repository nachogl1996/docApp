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
import es.upm.dit.isst.docapp.dao.PacienteDAOImplementation;
import es.upm.dit.isst.docapp.dao.model.Medico;
import es.upm.dit.isst.docapp.dao.model.Paciente;
import es.upm.dit.isst.docapp.dao.model.Especialidad;

/*
 * Este servlet se utiliza para cargar la vista principal
 * index.jsp.
 * Hay que hacer una consulta con para conseguir todas las especialidades readAll()
 * y luego organizarlas en tarjetas de tres en tres, si se selecciona alguna de las
 * especialidades se va hacia la vista donde estan los metodos y se seleccionan solo los
 * medicos de esa especialidad, si no solo sirve de consulta.
 * Tambien hay que cargar los medicos de una lista, que pueden ser o todos, o solo los
 * de la especialidad seleccionada
 */

@WebServlet("/index")
public class indexServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Medico> medicos = MedicoDAOImplementation.getInstance().readAllMedico();
		if(req.getParameter("esp") != null) {
			medicos = MedicoDAOImplementation.getInstance().readMedicoEspecialidad(req.getParameter("esp"));
		}
		List<Especialidad>  especialidades = EspecialidadDAOImplementation.getInstance().readAllEspecialidad();		
		req.getSession().setAttribute("especialidades", especialidades);
		req.getSession().setAttribute("medicos", medicos);
		resp.sendRedirect(req.getContextPath() + "/inicio.jsp#team");
	}

}
