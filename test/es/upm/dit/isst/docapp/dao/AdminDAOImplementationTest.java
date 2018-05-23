package es.upm.dit.isst.docapp.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import es.upm.dit.isst.docapp.dao.model.Admin;
import es.upm.dit.isst.docapp.dao.model.Cita;
import es.upm.dit.isst.docapp.dao.model.Especialidad;
import es.upm.dit.isst.docapp.dao.model.Medico;
import es.upm.dit.isst.docapp.dao.model.Paciente;

public class AdminDAOImplementationTest {
	private Especialidad especialidad;
	private Medico medico;
	private Paciente paciente;
	private Cita cita;
	private Admin admin;
	@Before
	public void setUp() throws Exception {
		admin = new Admin();
		admin.setEmail("admin@gmail");
		admin.setName("LuciaAdmin");
		admin.setPassword("pasw");
		AdminDAOImplementation.getInstance().createAdmin(admin);
		
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
		AdminDAOImplementation.getInstance().deleteAdmin(admin);
		admin=null;
		cita=null;
		paciente=null;
		medico=null;
		especialidad=null;
	}

	
	@Test
	public void testCreateAdmin() {
		Admin admin2 = new Admin();
		admin2.setEmail("ana@");
		admin2.setName("ana");
		admin2.setPassword("pas1");
		AdminDAOImplementation.getInstance().createAdmin(admin2);
		Admin a = AdminDAOImplementation.getInstance().readAdmin(admin2.getEmail());
		assertEquals(admin2.getEmail(), a.getEmail());
		assertEquals(admin2.getName(), a.getName());
		assertEquals(admin2.getPassword(), a.getPassword());
		AdminDAOImplementation.getInstance().deleteAdmin(admin2);
	}

	@Test
	public void testReadAdmin() {
		Admin a = AdminDAOImplementation.getInstance().readAdmin(admin.getEmail());
		assertEquals(admin.getEmail(), a.getEmail());
		assertNotEquals(a, null);
		
	}

	@Test
	public void testUpdateAdmin() {
		admin.setEmail("aa");
		admin.setName("mario");
		admin.setPassword("asd");
		AdminDAO dao = AdminDAOImplementation.getInstance();
		dao.updateAdmin(admin);
		
		Admin a = dao.readAdmin(admin.getEmail());
		assertEquals(admin.getEmail(), a.getEmail());
		assertEquals(admin.getName(), a.getName());
		assertEquals(admin.getPassword(), a.getPassword());
		
	}

	

	@Test
	public void testReadAllAdmin() {
		List<Admin>admins = AdminDAOImplementation.getInstance().readAllAdmin();
		assertNotEquals(admins, null);
	}

	
	
}
