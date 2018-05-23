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
import es.upm.dit.isst.docapp.handlers.FechasyCitasHandler;
import es.upm.dit.isst.docapp.dao.model.Cita;
import es.upm.dit.isst.docapp.dao.model.Medico;
import es.upm.dit.isst.docapp.dao.model.Especialidad;

@WebServlet("/CargaHorarioMedicoServlet")
public class CargaHorarioMedicoServlet extends HttpServlet {
	
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
				cita = CitaDAOImplementation.getInstance().readMedicofecha(medico.getEmail(), hora);
				if(hora.compareTo(now) > 0) {					
					if( cita == null) {
						cita = new Cita();
						cita.setStatus(0);
						cita.setformatDate(hora);
						cita.setMedico(medico);
					} else {
						System.out.println("\n\n\n\n\n\nNo cita nula:"+cita.getDate());
					}
				} else {
					if(cita== null) {
						cita = new Cita();
						cita.setStatus(1);
						cita.setformatDate(hora);
					} 
					
				}
				horariocitas.add(cita);
				System.out.println("fechahora:"+hora);
				hora = FechasyCitasHandler.getInstance().sumarFechasDias(hora, 30);
			}
		}
		return horariocitas;
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Medico medico = (Medico) req.getSession().getAttribute("medico");
		Medico medicoh = medico;
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Boolean modifica = false;
		if(req.getParameter("modifica")!=null) {
			modifica = true;
			List<Medico> medicosmisma = MedicoDAOImplementation.getInstance().readMedicoEspecialidad(medico.getEspecialidad().getName());
			req.getSession().setAttribute("medicosmisma", medicosmisma);			
			if(req.getParameter("medicomod1") != null) {
				medicoh = MedicoDAOImplementation.getInstance().readMedico(req.getParameter("medicomod1"));				
			}
			req.getSession().setAttribute("medicomod1", medicoh);
			req.getSession().setAttribute("mensajemod", medicoh.getName());
			if(req.getParameter("aviso")!=null) {
				req.getSession().setAttribute("avisomsg", "Debe asignarle una cita al ultimo paciente,");
			}
		}
		Date fechainicio = new Date();
		List<Cita> horariocitas = new ArrayList<Cita>();
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
		String especialidadps = "";
		String medicops = "";
		String msgp = "Elija Paciente";
		String msge = "Elija tipo de consulta";
		String msgm = "Elija doctor/a";
		String emailmp = "";
		List<Paciente> pacientes = PacienteDAOImplementation.getInstance().readAllPaciente();
		List<Medico> medicos = MedicoDAOImplementation.getInstance().readAllMedico();
		List<Especialidad> esps = EspecialidadDAOImplementation.getInstance().readAllEspecialidad();
		if(req.getSession().getAttribute("citaconsulta") != null) {
			msgp = req.getSession().getAttribute("msgp").toString();
		}
			
		req.getSession().setAttribute("pacientes", pacientes);
		req.getSession().setAttribute("msge", msge);
		req.getSession().setAttribute("msgp", msgp);
		req.getSession().setAttribute("msgm", msgm);
		req.getSession().setAttribute("especialidades", esps);
		req.getSession().setAttribute("medicos", medicos);

		horariocitas = obtenercitas(fechainicio, medicoh);
		req.getSession().setAttribute("mostrarmodalmedicodetalle", false);
		req.getSession().setAttribute("muestramodalconfirmarmod", false);
		req.getSession().setAttribute("mostrarmodal", false);
		req.getSession().setAttribute("mes", FechasyCitasHandler.getInstance().mes(fechainicio));
		req.getSession().setAttribute("imprimefechas", imprimirfechas);
		req.getSession().setAttribute("modificando", modifica);
		req.getSession().setAttribute("fechainicio", formato.format(fechainicio));
		req.getSession().setAttribute("horario", horariocitas);		
		resp.sendRedirect(req.getContextPath() + "/LoginMedico.jsp");
		
	}

}
