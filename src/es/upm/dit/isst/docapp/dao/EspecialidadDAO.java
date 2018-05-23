package es.upm.dit.isst.docapp.dao;


import java.util.List;

import es.upm.dit.isst.docapp.dao.model.Especialidad;

public interface EspecialidadDAO {

	public void createEspecialidad (Especialidad especialidad);
	public Especialidad readEspecialidad (String name); 
	public void updateEspecialidad (Especialidad especialidad);
	public void deleteEspecialidad (Especialidad especialidad);
	
	public List<Especialidad>readAllEspecialidad();
	
	
}