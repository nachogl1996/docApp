package es.upm.dit.isst.docapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.docapp.dao.model.Especialidad;

public class EspecialidadDAOImplementation implements EspecialidadDAO{

	private static EspecialidadDAOImplementation instance;//Para modelo singleton
	private EspecialidadDAOImplementation() {};
	public static EspecialidadDAOImplementation getInstance() {
		if(null==instance) instance = new EspecialidadDAOImplementation();
		return instance;
	}
	@Override
	public void createEspecialidad(Especialidad especialidad) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(especialidad);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		
	}

	@Override
	public Especialidad readEspecialidad(String name) {
		Especialidad especialidad = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			especialidad = session.get(Especialidad.class, name);
			session.getTransaction().commit();			
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		return especialidad;
	}

	@Override
	public void updateEspecialidad(Especialidad especialidad) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(especialidad);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		
	}

	@Override
	public void deleteEspecialidad(Especialidad especialidad) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(especialidad);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		
		
	}

	@Override
	public List<Especialidad> readAllEspecialidad() {
		List<Especialidad> especialidades = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			especialidades.addAll(
					session.createQuery("from Especialidad").list()
					);
			session.getTransaction().commit();			
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		return especialidades;
	}

}
