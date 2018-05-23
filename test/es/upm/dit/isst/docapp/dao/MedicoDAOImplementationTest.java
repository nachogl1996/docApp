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

public class MedicoDAOImplementationTest {
	private Especialidad especialidad;
	private Medico medico;
	
	
	@Before
	public void setUp() throws Exception {
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
		
		
	}

	@After
	public void tearDown() throws Exception {
	
		MedicoDAOImplementation.getInstance().deleteMedico(medico);
		EspecialidadDAOImplementation.getInstance().deleteEspecialidad(especialidad);
		medico=null;
		especialidad=null;
	}

	

	@Test
	public void testCreateMedico() {
		Medico medico1=new Medico();
		medico1.setEmail("email");
		medico1.setEspecialidad(especialidad);
		medico1.setName("Eduardo");
		medico1.setPassword("password");
		medico1.setUrlfoto("foto");
		MedicoDAOImplementation.getInstance().createMedico(medico1);
		Medico med =MedicoDAOImplementation.getInstance().readMedico(medico1.getEmail());
		MedicoDAOImplementation.getInstance().deleteMedico(medico1);
		assertEquals(medico1.getEmail(), med.getEmail());
		assertEquals(medico1.getName(), med.getName());
		assertEquals(medico1.getUrlfoto(), med.getUrlfoto());
		assertEquals(medico1.getPassword(), med.getPassword());
		
		}

	@Test
	public void testReadMedico() {
		Medico med = MedicoDAOImplementation.getInstance().readMedico(medico.getEmail());
		assertEquals(medico.getEmail(), med.getEmail());
		assertNotEquals(med, null);
	}

	@Test
	public void testUpdateMedico() {
		medico.setEspecialidad(especialidad);
		medico.setName("jaime");
		medico.setPassword("jaime2");
		MedicoDAO medupd = MedicoDAOImplementation.getInstance();
		medupd.updateMedico(medico);
		Medico med = medupd.readMedico(medico.getEmail());
		
		assertEquals(medico.getEspecialidad().getName(), med.getEspecialidad().getName());
		assertEquals(medico.getName(), med.getName());
		assertEquals(medico.getUrlfoto(), med.getUrlfoto());
		assertEquals(medico.getPassword(), med.getPassword());
		
	}

	

	@Test
	public void testReadAllMedico() {
		List<Medico> med = MedicoDAOImplementation.getInstance().readAllMedico();
		assertNotEquals(med,null);
	}

	

	@Test
	public void testReadMedicoEspecialidad() {
		List<Medico> medicos = new ArrayList<>();
		medicos = MedicoDAOImplementation.getInstance().readMedicoEspecialidad(especialidad.getName());
		List<Medico> med = MedicoDAOImplementation.getInstance().readAllMedico();
		assertNotEquals(medicos,med);
	}

}
