package es.upm.dit.isst.docapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.docapp.dao.model.Paciente;
import es.upm.dit.isst.docapp.dao.model.Paciente;

public class PacienteDAOImplementation implements PacienteDAO{
	private static PacienteDAOImplementation instance;//Para modelo singleton
	private PacienteDAOImplementation() {};
	public static PacienteDAOImplementation getInstance() {
		if(null==instance) instance = new PacienteDAOImplementation();
		return instance;
	}

	@Override
	public void createPaciente(Paciente paciente) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(paciente);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		
	}

	@Override
	public Paciente readPaciente(String email) {
		Paciente paciente = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			paciente = session.get(Paciente.class, email);
			session.getTransaction().commit();			
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		return paciente;
	}

	@Override
	public void updatePaciente(Paciente paciente) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(paciente);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		
	}

	@Override
	public void deletePaciente(Paciente paciente) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(paciente);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		
		
	}

	@Override
	public List<Paciente> readAllPaciente() {
		List<Paciente> pacientes = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			pacientes.addAll(
					session.createQuery("from Paciente").list()
					);
			session.getTransaction().commit();			
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		return pacientes;
	}

	@Override
	public Paciente loginPaciente(String email, String password) {
		Paciente paciente= null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			paciente = (Paciente) session.createQuery("select p from Paciente p " + 
			"where p.email = :email and p.password = :password")
				.setParameter("email", email)
				.setParameter("password", password)
				.getSingleResult();
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		return paciente;
	}

}
