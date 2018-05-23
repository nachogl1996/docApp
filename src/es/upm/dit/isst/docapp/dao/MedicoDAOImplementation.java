package es.upm.dit.isst.docapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.docapp.dao.model.Medico;
import es.upm.dit.isst.docapp.dao.model.Medico;

public class MedicoDAOImplementation implements MedicoDAO{
	private static MedicoDAOImplementation instance;//Para modelo singleton
	private MedicoDAOImplementation() {};
	public static MedicoDAOImplementation getInstance() {
		if(null==instance) instance = new MedicoDAOImplementation();
		return instance;
	}

	@Override
	public void createMedico(Medico medico) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(medico);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		
	}

	@Override
	public Medico readMedico(String email) {
		Medico medico = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			medico = session.get(Medico.class, email);
			session.getTransaction().commit();			
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		return medico;
	}

	@Override
	public void updateMedico(Medico medico) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(medico);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		
	}

	@Override
	public void deleteMedico(Medico medico) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(medico);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		
		
	}

	@Override
	public List<Medico> readAllMedico() {
		List<Medico> medicos = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			medicos.addAll(
					session.createQuery("from Medico").list()
					);
			session.getTransaction().commit();			
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		return medicos;
	}

	@Override
	public Medico loginMedico(String email, String password) {
		Medico medico= null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			medico = (Medico) session.createQuery("select m from Medico m " + 
			"where m.email = :email and m.password = :password")
				.setParameter("email", email)
				.setParameter("password", password)
				.getSingleResult();
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		return medico;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Medico> readMedicoEspecialidad(String esp) {
		List<Medico> medicos = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			medicos = (List<Medico>) session.createQuery("Select m from Medico m"
					+ " INNER JOIN Especialidad e ON m.especialidad = e "
					+ "where e.name = :especialidad")
			.setParameter("especialidad", esp)
			.list();	
			session.getTransaction().commit();			
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		return medicos;
	}

}
