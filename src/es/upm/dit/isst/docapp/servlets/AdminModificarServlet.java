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


import es.upm.dit.isst.docapp.dao.CitaDAOImplementation;
import es.upm.dit.isst.docapp.dao.model.Cita;

@WebServlet("/AdminModificarServlet")
public class AdminModificarServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fecha = req.getParameter("cita");
		Cita cita = (Cita) req.getSession().getAttribute("citadetalle");
		cita.setDate(fecha);
		CitaDAOImplementation.getInstance().updateCita(cita);
		resp.sendRedirect(req.getContextPath() + "/CargaHorarioModificarAdminServlet");
	}
}
