package es.upm.dit.isst.docapp.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.docapp.dao.PacienteDAOImplementation;
import es.upm.dit.isst.docapp.dao.CitaDAOImplementation;
import es.upm.dit.isst.docapp.dao.EspecialidadDAOImplementation;
import es.upm.dit.isst.docapp.dao.MedicoDAOImplementation;
import es.upm.dit.isst.docapp.dao.model.Paciente;
import es.upm.dit.isst.docapp.dao.model.Cita;
import es.upm.dit.isst.docapp.dao.model.Medico;
import es.upm.dit.isst.docapp.dao.model.Especialidad;
import es.upm.dit.isst.docapp.handlers.FechasyCitasHandler;

@WebServlet("/CargaCitasAdminServlet")
public class CargaCitasAdminServlet extends HttpServlet {
	
	private int[] imprimirfechas = new int[5];	
	/*
	 * Funcion que devuelve una lista con las citas de una semana
	 * para cargarlas en la vista con el horario
	 */
	private List<Cita> obtenercitas(Date fechainicio, Medico medico){
		List<Cita> horariocitas = new ArrayList<Cita>();
		Date now = new Date();
		Date fecha = fechainicio;
		Date hora = fechainicio;
		for(int i = 0; i < 5;i++) {
			if(i != 0) {
				fecha = FechasyCitasHandler.getInstance().sumarFechasDias(fecha,60*24);
			}
			imprimirfechas[i] = FechasyCitasHandler.getInstance().diames(fecha);
			hora = fecha;
			for(int j = 0; j < 20; j++) {
				Cita cita = null;
				if(hora.compareTo(now) > 0) {//Si la fecha es menos de la actual esa cita no se podrá reservar
					cita = CitaDAOImplementation.getInstance().readMedicofecha(medico.getEmail(), hora);
					if( cita == null) {
						cita = new Cita();
						cita.setStatus(0);
						cita.setformatDate(hora);
						cita.setMedico(medico);
					} else {
						System.out.println("\n\n\n\n\n\nNo cita nula:"+cita.getDate());
					}
				} else {
					cita = new Cita();
					cita.setStatus(1);
					cita.setformatDate(hora);
				}
				horariocitas.add(cita);
				hora = FechasyCitasHandler.getInstance().sumarFechasDias(hora, 30);
			}
		}
		return horariocitas;
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date fechainicio = new Date();
		List<Cita> horariocitas = new ArrayList<Cita>();		
			
		String medicops = req.getParameter("med");
		if(medicops == null) {
			medicops = (String) req.getSession().getAttribute("medicoemail");
		}
		Medico medico = MedicoDAOImplementation.getInstance().readMedico(medicops);
		if(req.getParameter("inicio") != null) {
			String inicio = req.getParameter("inicio");
			try {
				fechainicio = formato.parse(inicio);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(req.getParameter("mover") != null && !req.getParameter("mover").equals("")) {
				String accion = req.getParameter("mover");
				if(accion.equals("avanza")) {
					System.out.println("\n\nfecha encontradaa:"+formato.format(fechainicio));
					fechainicio = FechasyCitasHandler.getInstance().sumarFechasDias(fechainicio, 60*24*7);
				} else if(accion.equals("retrocede")) {
					fechainicio = FechasyCitasHandler.getInstance().sumarFechasDias(fechainicio, -60*24*7);
				}
			}
		} else {
			fechainicio = FechasyCitasHandler.getInstance().lunesnueve(fechainicio);
		}
		horariocitas = obtenercitas(fechainicio, medico);
		req.getSession().setAttribute("mostrarmodal", false);
		req.getSession().setAttribute("mes", FechasyCitasHandler.getInstance().mes(fechainicio));
		req.getSession().setAttribute("imprimefechas", imprimirfechas);
		req.getSession().setAttribute("fechainicio", formato.format(fechainicio));
		req.getSession().setAttribute("horario", horariocitas);
		req.getSession().setAttribute("msge", medico.getEspecialidad().getName());
		req.getSession().setAttribute("msgm", medico.getName());
		req.getSession().setAttribute("medicoemail", medico.getEmail());
		req.getSession().setAttribute("mostrarmodaldetalle", false);
		req.getSession().setAttribute("muestramodalconfirmar", false);
		resp.sendRedirect(req.getContextPath() + "/LoginAdmin.jsp#gestionespecialidad");
		
		
			
			
		
	}
}