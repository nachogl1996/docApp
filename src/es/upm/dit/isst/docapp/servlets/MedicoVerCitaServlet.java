package es.upm.dit.isst.docapp.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

@WebServlet("/MedicoVerCitaServlet")
public class MedicoVerCitaServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("cita"));
		String abrir= req.getParameter("abrir");
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date fecha = new Date();
		Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fecha.getTime());
        cal.set(Calendar.HOUR_OF_DAY, 22);
        cal.set(Calendar.MINUTE, 0);
        fecha = new Date(cal.getTimeInMillis());
		String date = formato.format(fecha);
		req.getSession().setAttribute("fechahoyfindetalle", date);
		cal.set(Calendar.HOUR_OF_DAY, 8);
        cal.set(Calendar.MINUTE, 0);
        fecha = new Date(cal.getTimeInMillis());
		date = formato.format(fecha);
		req.getSession().setAttribute("fechahoydetalle", date);
		Boolean mostrar = false;
		if(abrir.equals("si")) {
			mostrar = true;
		}
		Cita cita = CitaDAOImplementation.getInstance().readCita(id);
		req.getSession().setAttribute("citadetalle", cita);
		req.getSession().setAttribute("mostrarmodalmedicodetalle", mostrar);
		resp.sendRedirect(req.getContextPath() + "/LoginMedico.jsp");
	}

}
