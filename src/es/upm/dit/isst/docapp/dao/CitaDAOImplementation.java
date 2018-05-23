package es.upm.dit.isst.docapp.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.docapp.dao.model.Cita;

public class CitaDAOImplementation implements CitaDAO {
	
	SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	private static CitaDAOImplementation instance;//Para modelo singleton
	private CitaDAOImplementation() {};
	public static CitaDAOImplementation getInstance() {
		if(null==instance) instance = new CitaDAOImplementation();
		return instance;
	}
	
	@Override
	public void createCita(Cita cita) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(cita);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		
	}

	@Override
	public Cita readCita(int id) {
		Cita cita = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			cita = session.get(Cita.class, id);
			session.getTransaction().commit();			
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		return cita;
	}

	@Override
	public void updateCita(Cita cita) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(cita);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		
	}

	@Override
	public void deleteCita(Cita cita) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(cita);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		
		
	}

	@Override
	public List<Cita> readAllCita() {
		List<Cita> citas = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			citas.addAll(
					session.createQuery("from Cita").list()
					);
			session.getTransaction().commit();			
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		return citas;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Cita> readMedicoCitas(String emailM, Date fechainicio, Date fechafin) {
		String dateinicio = formato.format(fechainicio);
		String datefin = formato.format(fechafin);
		List<Cita> citas = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		try {			
			session.beginTransaction();
			citas = (List<Cita>) session.createQuery("Select c from Cita c"
							+ " INNER JOIN Medico m ON c.medico = m"
							+ "where m.email = :email and c.date > :fechainicio and c.date < :fechafin")
					.setParameter("email", emailM)
					.setParameter("fechainicio", dateinicio)
					.setParameter("fechafin", datefin)
					.list();					
			session.getTransaction().commit();			
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		return citas;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Cita> readPacienteCitas(String emailP) {
		Date fecha = new Date();
		Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fecha.getTime());
        cal.set(Calendar.HOUR_OF_DAY, 9);
        cal.set(Calendar.MINUTE, 0);
        fecha = new Date(cal.getTimeInMillis());
		String date = formato.format(fecha);
		List<Cita> citas = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			citas = (List<Cita>) session.createQuery("Select c from Cita c"
					+ " INNER JOIN Paciente p ON c.paciente = p "
					+ "where p.email = :email and c.date >= :date ORDER BY c.date")
			.setParameter("email", emailP)
			.setParameter("date", date)
			.list();	
			session.getTransaction().commit();			
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		return citas;
	}
	@Override
	public Cita readMedicofecha(String emailM, Date fecha) {
		Cita cita = null;
		String date =  formato.format(fecha);
		Session session = SessionFactoryService.get().openSession();
		try {			
			session.beginTransaction();
			cita = (Cita) session.createQuery("Select c from Cita c"
							+ " INNER JOIN Medico m ON c.medico = m"
							+ " where m.email = :email and c.date = :fecha")
					.setParameter("email", emailM)
					.setParameter("fecha", date)
					.getSingleResult();					
			session.getTransaction().commit();			
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		return cita;
	}
	public List<Cita> readCitamenorFecha(Date fecha) {
		System.out.println(fecha);
		String date =  formato.format(fecha);
		List<Cita> citas = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			citas = (List<Cita>) session.createQuery("Select c from Cita c where c.date < :fecha")
			.setParameter("fecha", date)
			.list();;
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		return citas;
		
	} 
	public List<Cita> readCitaFechas(Date fecha, Date fecha2) {
		System.out.println(fecha);
		String date =  formato.format(fecha);
		String date2 = formato.format(fecha2);
		List<Cita> citas = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			citas = (List<Cita>) session.createQuery("Select c from Cita c where c.date > :fecha and c.date < :fecha2")
			.setParameter("fecha", date)
			.setParameter("fecha2", date2)
			.list();;
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		return citas;
		
	} 
	
	

}
