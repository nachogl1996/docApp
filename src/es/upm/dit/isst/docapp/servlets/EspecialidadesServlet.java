package es.upm.dit.isst.docapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.docapp.dao.PacienteDAOImplementation;
import es.upm.dit.isst.docapp.dao.AdminDAOImplementation;
import es.upm.dit.isst.docapp.dao.MedicoDAOImplementation;
import es.upm.dit.isst.docapp.dao.model.Paciente;
import es.upm.dit.isst.docapp.dao.model.Admin;
import es.upm.dit.isst.docapp.dao.model.Medico;

/*
 * Este servlet se utiliza para cargar la vista que contiene las especialidades
 * indexEspecialidades.jsp que se encuentra en la pagina index.
 * Hay que hacer una consulta con para conseguir todas las especialidades readAll()
 * y luego organizarlas en tarjetas de tres en tres, si se selecciona alguna de las
 * especialidades se va hacia la vista donde estan los metodos y se seleccionan solo los
 * medicos de esa especialidad, si no solo sirve de consulta
 */

@WebServlet("/EspecialidadesServlet")
public class EspecialidadesServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

}
