package es.upm.dit.isst.docapp.dao;


import java.util.List;

import es.upm.dit.isst.docapp.dao.model.Paciente;

public interface PacienteDAO {

	public void createPaciente (Paciente paciente);
	public Paciente readPaciente (String email);
	public void updatePaciente (Paciente paciente);
	public void deletePaciente (Paciente paciente);
	
	public List<Paciente>readAllPaciente();
	public Paciente loginPaciente(String email, String password);
	
}