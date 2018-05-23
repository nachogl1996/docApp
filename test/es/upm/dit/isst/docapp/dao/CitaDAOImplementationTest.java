package es.upm.dit.isst.docapp.dao;

import static org.junit.Assert.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Date;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.upm.dit.isst.docapp.dao.model.Cita;
import es.upm.dit.isst.docapp.dao.model.Especialidad;
import es.upm.dit.isst.docapp.dao.model.Medico;
import es.upm.dit.isst.docapp.dao.model.Paciente;
//import es.upm.dit.isst.webLab.dao.TFGDAO;
//import es.upm.dit.isst.webLab.dao.TFGDAOImplementation;

public class CitaDAOImplementationTest {
	private Especialidad especialidad;
	private Medico medico;
	private Paciente paciente;
	private Cita cita;
	@Before
	public void setUp() throws Exception { //Hay que crear un medico, una especialidad y un paciente como minimo
		especialidad  = new Especialidad();
		especialidad.setName("especialidad para test");
		especialidad.setDescription("especialidad de prueba");
		EspecialidadDAOImplementation.getInstance().createEspecialidad(especialidad);
		
		medico = new Medico();
		medico.setConsulta("100");
		medico.setEmail("medico@prueba.com");
		medico.setName("medicoprueba");
		medico.setPassword("medico");
		medico.setEspecialidad(especialidad);
		MedicoDAOImplementation.getInstance().createMedico(medico);
		
		paciente = new Paciente();
		paciente.setEmail("paciente@prueba.com");
		paciente.setName("paciente");
		paciente.setPassword("paciente");
		PacienteDAOImplementation.getInstance().createPaciente(paciente);
		
		cita = new Cita();
		cita.setDate("2018-05-30 12:00");
		cita.setDetail("cita prueba");
		cita.setMedico(medico);
		cita.setPaciente(paciente);
		cita.setStatus(1);
		CitaDAOImplementation.getInstance().createCita(cita);
		
	}

	@After
	public void tearDown() throws Exception {
		CitaDAOImplementation.getInstance().deleteCita(cita);
		PacienteDAOImplementation.getInstance().deletePaciente(paciente);
		MedicoDAOImplementation.getInstance().deleteMedico(medico);
		EspecialidadDAOImplementation.getInstance().deleteEspecialidad(especialidad);
		cita=null;
		paciente=null;
		medico=null;
		especialidad=null;
	}

	@Test
	public void testCreateCita() {
		Cita cita2 = new Cita();
		cita2.setDate("2018-12-30 12:00");
		cita2.setDetail("cita2");
		cita2.setMedico(medico);
		cita2.setPaciente(paciente);
		cita2.setStatus(2);
		CitaDAOImplementation.getInstance().createCita(cita2);
		System.out.println("\n\n\n\n\naaaaaaaaa"+cita2.getId());
		
		Cita cita3 = CitaDAOImplementation.getInstance().readCita(cita2.getId());
		CitaDAOImplementation.getInstance().deleteCita(cita2);
		assertEquals(cita2.getDate(), cita3.getDate());
		assertEquals(cita2.getDetail(), cita3.getDetail());
		assertEquals(cita2.getMedico().getEmail(), cita3.getMedico().getEmail());
		assertEquals(cita2.getStatus(), cita3.getStatus());
		assertEquals(cita2.getPaciente().getEmail(), cita3.getPaciente().getEmail());
	}

	

	@Test
	public void testUpdateCita() {
		cita.setDate("2018-11-18 11:00");
		cita.setStatus(0);
		cita.setDetail("Me duele la cabeza");
		CitaDAO dao = CitaDAOImplementation.getInstance();
		dao.updateCita(cita);
		
		Cita citaupd = dao.readCita(cita.getId());
		
		assertEquals(cita.getDate(), citaupd.getDate());
		assertEquals(cita.getDetail(), citaupd.getDetail());
		assertEquals(cita.getMedico().getEmail(), citaupd.getMedico().getEmail());
		assertEquals(cita.getStatus(), citaupd.getStatus());
		assertEquals(cita.getPaciente().getEmail(), citaupd.getPaciente().getEmail());
		
	}

	
	@Test
	public void testReadAllCita() {
		List<Cita>citas = CitaDAOImplementation.getInstance().readAllCita();
		assertNotEquals(citas, null);
	}

	
	@Test
	public void testReadPacienteCitas() {
		List<Cita>citas = CitaDAOImplementation.getInstance().readPacienteCitas(paciente.getEmail());
		assertNotEquals(citas, null);
	}

	
}
