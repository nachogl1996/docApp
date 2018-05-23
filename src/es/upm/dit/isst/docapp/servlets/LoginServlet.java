package es.upm.dit.isst.docapp.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.docapp.dao.PacienteDAOImplementation;
import es.upm.dit.isst.docapp.dao.AdminDAOImplementation;
import es.upm.dit.isst.docapp.dao.CitaDAOImplementation;
import es.upm.dit.isst.docapp.dao.EspecialidadDAOImplementation;
import es.upm.dit.isst.docapp.dao.MedicoDAOImplementation;
import es.upm.dit.isst.docapp.dao.model.Paciente;
import es.upm.dit.isst.docapp.dao.model.Admin;
import es.upm.dit.isst.docapp.dao.model.Cita;
import es.upm.dit.isst.docapp.dao.model.Medico;
import es.upm.dit.isst.docapp.dao.model.Especialidad;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private final String USER_SECRETARIA = "root";
	private final String PASS_SECRETARIA = "root";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");		
		Paciente  paciente = PacienteDAOImplementation.getInstance().loginPaciente(email,password);
		Medico medico = MedicoDAOImplementation.getInstance().loginMedico(email,password);
		Admin admin = AdminDAOImplementation.getInstance().loginAdmin(email,password);
		if(email.equals(USER_SECRETARIA) && password.equals(PASS_SECRETARIA)) {
			admin = new Admin();
			admin.setEmail(USER_SECRETARIA);
			admin.setName("root");
			admin.setPassword(PASS_SECRETARIA);
		}	
		if(null != medico) {
			 req.getSession().setAttribute("medico", medico);
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
			
			
		}
		else if(null != admin ) {
			List<Especialidad> esps = EspecialidadDAOImplementation.getInstance().readAllEspecialidad();
			String msge = "Elija tipo de consulta";
			String msgm = "Elija doctor/a";
			List<Paciente> pacientes = PacienteDAOImplementation.getInstance().readAllPaciente();
			List<Medico> medicos = MedicoDAOImplementation.getInstance().readAllMedico();
			req.getSession().setAttribute("medicos", medicos);
			req.getSession().setAttribute("pacientes", pacientes);
			req.getSession().setAttribute("admin", admin);			
			req.getSession().setAttribute("especialidades", esps);
			req.getSession().setAttribute("msge", msge);
			req.getSession().setAttribute("msgm", msgm);
			resp.sendRedirect(req.getContextPath() + "/LoginAdmin.jsp");
		}
		else {
			resp.sendRedirect(req.getContextPath() + "/index");
				
		}
	}

}