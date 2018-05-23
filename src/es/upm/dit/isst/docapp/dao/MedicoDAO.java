package es.upm.dit.isst.docapp.dao;


import java.util.List;

import es.upm.dit.isst.docapp.dao.model.Medico;

public interface MedicoDAO {

	public void createMedico (Medico medico);
	public Medico readMedico (String email);
	public void updateMedico (Medico medico);
	public void deleteMedico (Medico medico);
	public List<Medico>readMedicoEspecialidad(String esp);
	public List<Medico>readAllMedico();
	public Medico loginMedico(String email, String password);
	
}