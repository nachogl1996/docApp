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
import es.upm.dit.isst.docapp.dao.CitaDAOImplementation;
import es.upm.dit.isst.docapp.dao.EspecialidadDAOImplementation;
import es.upm.dit.isst.docapp.dao.MedicoDAOImplementation;
import es.upm.dit.isst.docapp.dao.model.Paciente;
import es.upm.dit.isst.docapp.dao.model.Cita;
import es.upm.dit.isst.docapp.dao.model.Especialidad;
import es.upm.dit.isst.docapp.dao.model.Medico;
import es.upm.dit.isst.docapp.handlers.EmailHandler;

@WebServlet("/ConfirmarCitaModServlet")
public class ConfirmarCitaModServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Medico medico = (Medico) req.getSession().getAttribute("medicomod");
		String fechaparalacita = (String) req.getSession().getAttribute("fechaparalacita");
		Paciente paciente = (Paciente) req.getSession().getAttribute("paciente");
		Cita citamod = (Cita) req.getSession().getAttribute("citamod");
		String descripcion = req.getParameter("descripcion");		
		String detail = citamod.getDetail()+"\n "+descripcion;
		if(detail == null) {
			detail = descripcion;
		}
		citamod.setDate(fechaparalacita);
		citamod.setMedico(medico);
		citamod.setStatus(1);
		citamod.setDetail(detail);
		CitaDAOImplementation.getInstance().updateCita(citamod);;
		//Enviar correo electrónico
		/*String asunto = "Confirmacion cita para "+paciente.getName();
		String body = "Le informamos que su cita ha sido guardada correctamente\n"
				+ " la cita tendra lugar en la consulta del doctor "+medico.getName()+" que"
						+ "es la numero "+medico.getConsulta()+" en el pasillo de "+medico.getEspecialidad().getName()+"\n"
								+ "La cita sera en la siguiente fecha "+cita.getDate();
		EmailHandler.getInstance().sendEmail("docapp.citas@gmail.com", "nachoguelor1996@gmail.com", "aa", "bhh");
		*/
		//Redireccion a LoginPaciente.jsp
		Boolean mostrar = false;
		Boolean mostrarmodal1=false;
		String especialidadps = "";
		String medicops = "";
		String msge = "Elija tipo de consulta";
		String msgm = "Elija doctor/a";
		String emailmp = "";
		List<Medico> medicos = MedicoDAOImplementation.getInstance().readAllMedico();
		List<Especialidad> esps = EspecialidadDAOImplementation.getInstance().readAllEspecialidad();
		
		List<Cita> citaspaciente = CitaDAOImplementation.getInstance().readPacienteCitas(paciente.getEmail());
		req.getSession().setAttribute("citaspaciente", citaspaciente);
		req.getSession().setAttribute("mostrarmodal1", mostrarmodal1);
		req.getSession().setAttribute("msge", msge);
		req.getSession().setAttribute("msgm", msgm);
		req.getSession().setAttribute("especialidades", esps);
		req.getSession().setAttribute("medicos", medicos);
		req.getSession().setAttribute("mostrar", mostrar);
		resp.sendRedirect(req.getContextPath() + "/LoginPaciente.jsp");
	}
	

}