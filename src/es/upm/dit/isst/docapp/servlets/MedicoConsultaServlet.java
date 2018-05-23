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

@WebServlet("/MedicoConsultaServlet")
public class MedicoConsultaServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cita cita = (Cita) req.getSession().getAttribute("citadetalle");
		String msgp = cita.getPaciente().getEmail();
		if(cita.getStatus() <3) {
			cita.setStatus(3);
		} else {
			cita.setStatus(4);
			String desc = req.getParameter("descripcion");
			String detail = cita.getDetail();
			detail = detail+"\nComentario del medico: "+desc;
			cita.setDetail(detail);
			msgp = "Elija Paciente";
		}
		CitaDAOImplementation.getInstance().updateCita(cita);
		req.getSession().setAttribute("msgp", msgp);
		req.getSession().setAttribute("paciente", cita.getPaciente());
		req.getSession().setAttribute("citaconsulta", cita);
		resp.sendRedirect(req.getContextPath() + "/CargaHorarioMedicoServlet");
	}

}
