package es.upm.dit.isst.docapp.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.docapp.dao.CitaDAOImplementation;
import es.upm.dit.isst.docapp.dao.EspecialidadDAOImplementation;
import es.upm.dit.isst.docapp.dao.MedicoDAOImplementation;
import es.upm.dit.isst.docapp.dao.PacienteDAOImplementation;
import es.upm.dit.isst.docapp.dao.model.Cita;
import es.upm.dit.isst.docapp.dao.model.Especialidad;
import es.upm.dit.isst.docapp.dao.model.Medico;
import es.upm.dit.isst.docapp.dao.model.Paciente;

@WebServlet("/AdmininiciaGestion")
public class AdmininiciaGestion extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String email = req.getParameter("usuario");
		Paciente paciente = PacienteDAOImplementation.getInstance().readPaciente(email);
		Medico medico = MedicoDAOImplementation.getInstance().readMedico(email);
		
		if(null != medico) {
			 req.getSession().setAttribute("medico", medico);
			 req.getSession().setAttribute("suplantacion", "medico");
			 resp.sendRedirect(req.getContextPath() + "/CargaHorarioMedicoServlet");
				
		}
		else if(null != paciente) {
			String especialidadps = "";
			String medicops = "";
			String msge = "Elija tipo de consulta";
			String msgm = "Elija doctor/a";
			String emailmp = "";
			List<Medico> medicos = MedicoDAOImplementation.getInstance().readAllMedico();
			List<Especialidad> esps = EspecialidadDAOImplementation.getInstance().readAllEspecialidad();
			
			//Para confirmar cita, hay que ver que sea ese dia
			SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			Date fecha = new Date();
			Calendar cal = new GregorianCalendar();
	        cal.setTimeInMillis(fecha.getTime());
	        cal.set(Calendar.HOUR_OF_DAY, 22);
	        cal.set(Calendar.MINUTE, 0);
	        fecha = new Date(cal.getTimeInMillis());
			String date = formato.format(fecha);
			
			List<Cita> citaspaciente = CitaDAOImplementation.getInstance().readPacienteCitas(paciente.getEmail());
			req.getSession().setAttribute("suplantacion", "paciente");
			req.getSession().setAttribute("citaspaciente", citaspaciente);
			req.getSession().setAttribute("mostrarmodal", "false");
			req.getSession().setAttribute("mostrarmodal1", "false");
			req.getSession().setAttribute("mostrarmodal2", "false");
			req.getSession().setAttribute("paciente", paciente);
			req.getSession().setAttribute("msge", msge);
			req.getSession().setAttribute("msgm", msgm);
			req.getSession().setAttribute("especialidades", esps);
			req.getSession().setAttribute("medicos", medicos);
			req.getSession().setAttribute("diahoyconfirmar", date);
			resp.sendRedirect(req.getContextPath() + "/LoginPaciente.jsp");
			
			
		} else {
			resp.sendRedirect(req.getContextPath() + "/LoginAdmin.jsp");
		}
		
	}

}
