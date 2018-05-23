package es.upm.dit.isst.docapp.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

@WebServlet("/PedirCitaServlet")
public class PedirCitaServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Paciente paciente = (Paciente) req.getSession().getAttribute("paciente");
		String fechaS = req.getParameter("cita");
		String medicoemail = req.getParameter("medico");
		Medico medico = MedicoDAOImplementation.getInstance().readMedico(medicoemail);
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date fecha = null;
		try {
			fecha = format.parse(fechaS);
			String fechacita = format.format(fecha);
			req.getSession().setAttribute("fechaparalacita", fechacita);
			req.getSession().setAttribute("mostrarmodal", true);
		} catch (ParseException e) {
			req.getSession().setAttribute("mostrarmodal", false);
			e.printStackTrace();
		}
		
		
		req.getSession().setAttribute("paciente", paciente);
		req.getSession().setAttribute("medico", medico);
		resp.sendRedirect(req.getContextPath() + "/LoginPaciente.jsp");
		
		
	}

}