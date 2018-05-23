package es.upm.dit.isst.docapp.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.upm.dit.isst.docapp.dao.model.Cita;
import es.upm.dit.isst.docapp.dao.model.Especialidad;
import es.upm.dit.isst.docapp.dao.model.Medico;
import es.upm.dit.isst.docapp.dao.model.Paciente;

public class PacienteDAOImplementationTest {

	private Paciente paciente;
	
	@Before
	public void setUp() throws Exception {
		
		paciente = new Paciente();
		paciente.setEmail("paciente@prueba.com");
		paciente.setName("paciente");
		paciente.setPassword("paciente");
		PacienteDAOImplementation.getInstance().createPaciente(paciente);
		
	}

	@After
	public void tearDown() throws Exception {
	
		PacienteDAOImplementation.getInstance().deletePaciente(paciente);
		paciente=null;

	}

	

	@Test
	public void testCreatePaciente() {
		Paciente pac =new Paciente();
		pac.setEmail("paciente@gmail");
		pac.setName("Ana");
		pac.setPassword("Ana1");
		pac.setUrlfoto("urlf");
		PacienteDAOImplementation.getInstance().createPaciente(pac);
		
		Paciente p =PacienteDAOImplementation.getInstance().readPaciente(pac.getEmail());
		PacienteDAOImplementation.getInstance().deletePaciente(pac);
		assertEquals(pac.getEmail(), p.getEmail());
		assertEquals(pac.getName(), p.getName());
		assertEquals(pac.getUrlfoto(), p.getUrlfoto());
		assertEquals(pac.getPassword(), p.getPassword());
	}

	@Test
	public void testReadPaciente() {
		Paciente p = PacienteDAOImplementation.getInstance().readPaciente(paciente.getEmail());
		assertEquals(paciente.getEmail(), p.getEmail());
		assertNotEquals(p, null);
				
	}

	@Test
	public void testUpdatePaciente() {
		paciente.setName("pepe");
		paciente.setUrlfoto("fot");
		PacienteDAO dao = PacienteDAOImplementation.getInstance();
		dao.updatePaciente(paciente);
		Paciente p = dao.readPaciente(paciente.getEmail());
		
		assertEquals(paciente.getEmail(), p.getEmail());
		assertEquals(paciente.getName(), p.getName());
		assertEquals(paciente.getUrlfoto(), p.getUrlfoto());
		assertEquals(paciente.getPassword(), p.getPassword());
		
	}

	

	@Test
	public void testReadAllPaciente() {
		List<Paciente> pacientes=PacienteDAOImplementation.getInstance().readAllPaciente();
		assertNotEquals(pacientes, null);
	}

	

}
