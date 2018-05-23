package es.upm.dit.isst.docapp.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.upm.dit.isst.docapp.dao.model.Cita;
import es.upm.dit.isst.docapp.dao.model.Especialidad;
import es.upm.dit.isst.docapp.dao.model.Medico;
import es.upm.dit.isst.docapp.dao.model.Paciente;

public class EspecialidadDAOImplementationTest {
	private Especialidad especialidad;
	private Medico medico;

	@Before
	public void setUp() throws Exception {
		especialidad  = new Especialidad();
		especialidad.setName("prueba");
		especialidad.setDescription("especialidad de prueba");
		especialidad.setUrlfoto("foto");
		EspecialidadDAOImplementation.getInstance().createEspecialidad(especialidad);
		
		medico = new Medico();
		medico.setConsulta("100");
		medico.setEmail("medico@prueba.com");
		medico.setName("medicoprueba");
		medico.setPassword("medico");
		medico.setEspecialidad(especialidad);
		MedicoDAOImplementation.getInstance().createMedico(medico);
		
		
	}

	@After
	public void tearDown() throws Exception {
		
		MedicoDAOImplementation.getInstance().deleteMedico(medico);
		EspecialidadDAOImplementation.getInstance().deleteEspecialidad(especialidad);
		medico=null;
		especialidad=null;
	}

	

	@Test
	public void testCreateEspecialidad() {
		MedicoDAO medicodao = MedicoDAOImplementation.getInstance();
		List<Medico> medicos = medicodao.readMedicoEspecialidad(especialidad.getName());
		Especialidad esp = new Especialidad();
		esp.setDescription("especialidad de prueba");
		esp.setName("prueba");
		esp.setUrlfoto("foto");
		EspecialidadDAOImplementation.getInstance().createEspecialidad(esp);
		
		Especialidad esp1 = EspecialidadDAOImplementation.getInstance().readEspecialidad(esp.getName());
		EspecialidadDAOImplementation.getInstance().deleteEspecialidad(esp);
		assertEquals(esp.getDescription(), esp1.getDescription());
		assertEquals(esp.getName(), esp1.getName());
		assertEquals(esp.getUrlfoto(), esp1.getUrlfoto());
		
	}

	@Test
	public void testReadEspecialidad() {
		Especialidad esp = EspecialidadDAOImplementation.getInstance().readEspecialidad(especialidad.getName());
		assertEquals(esp.getName(), especialidad.getName());
		assertNotEquals(esp, null);
	}

	@Test
	public void testUpdateEspecialidad() {
		especialidad.setDescription("prueba");
		especialidad.setUrlfoto("foto2");
		EspecialidadDAO espd= EspecialidadDAOImplementation.getInstance();
		espd.updateEspecialidad(especialidad);
		Especialidad upd = espd.readEspecialidad(especialidad.getName());
		
		assertEquals(especialidad.getDescription(), upd.getDescription());
		assertEquals(especialidad.getName(), upd.getName());
		assertEquals(especialidad.getUrlfoto(), upd.getUrlfoto());
		
	}

	
	@Test
	public void testReadAllEspecialidad() {
		List<Especialidad> esps =EspecialidadDAOImplementation.getInstance().readAllEspecialidad();
		assertNotEquals(esps, null);
	}

}
