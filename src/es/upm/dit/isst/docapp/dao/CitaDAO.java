package es.upm.dit.isst.docapp.dao;


import java.util.Date;
import java.util.List;

import es.upm.dit.isst.docapp.dao.model.Cita;

public interface CitaDAO {

	public void createCita (Cita cita);
	public Cita readCita (int id); //creo q no es el email jj
	public void updateCita (Cita cita);
	public void deleteCita (Cita cita);	
	public List<Cita>readAllCita();
	public List<Cita>readMedicoCitas(String emailM, Date fechainicio, Date fechafin);
	public List<Cita>readPacienteCitas(String emailP);
	public Cita readMedicofecha(String emailM, Date fecha);
	public List<Cita> readCitamenorFecha(Date date);
	public List<Cita> readCitaFechas(Date fecha, Date fecha2);
	
	
}