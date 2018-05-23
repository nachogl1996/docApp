package es.upm.dit.isst.docapp.servlets;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.docapp.dao.PacienteDAOImplementation;
import es.upm.dit.isst.docapp.dao.MedicoDAOImplementation;
import es.upm.dit.isst.docapp.dao.model.Paciente;
import es.upm.dit.isst.docapp.dao.model.Cita;
import es.upm.dit.isst.docapp.dao.model.Medico;

@WebServlet("/MedicoPedirCitaServlet")
public class MedicoPedirCitaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fecha = req.getParameter("cita");		
		List<Paciente> pacientes = PacienteDAOImplementation.getInstance().readAllPaciente();
		req.getSession().setAttribute("pacientes", pacientes);
		req.getSession().setAttribute("fechacita", fecha);
		req.getSession().setAttribute("muestramodalconfirmarmod", true);
		resp.sendRedirect(req.getContextPath() + "/LoginMedico.jsp");
	}
}
