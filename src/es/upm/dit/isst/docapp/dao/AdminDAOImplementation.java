package es.upm.dit.isst.docapp.dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import es.upm.dit.isst.docapp.dao.AdminDAO;
import es.upm.dit.isst.docapp.dao.model.Admin;
import es.upm.dit.isst.docapp.dao.SessionFactoryService;

public class AdminDAOImplementation implements AdminDAO{
	private static AdminDAOImplementation instance;//Para modelo singleton
	private AdminDAOImplementation() {};
	public static AdminDAOImplementation getInstance() {
		if(null==instance) instance = new AdminDAOImplementation();
		return instance;
	}

	@Override
	public void createAdmin(Admin admin) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(admin);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		
	}

	@Override
	public Admin readAdmin(String email) {
		Admin admin = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			admin = session.get(Admin.class, email);
			session.getTransaction().commit();			
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		return admin;
	}

	@Override
	public void updateAdmin(Admin admin) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(admin);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		
	}

	@Override
	public void deleteAdmin(Admin admin) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(admin);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		
		
	}

	@Override
	public List<Admin> readAllAdmin() {
		List<Admin> admins = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			admins.addAll(
					session.createQuery("from Admin").list()
					);
			session.getTransaction().commit();			
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		return admins;
	}

	@Override
	public Admin loginAdmin(String email, String password) {
		Admin admin= null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			admin = (Admin) session.createQuery("select a from Admin a " + 
			"where a.email = :email and a.password = :password")
				.setParameter("email", email)
				.setParameter("password", password)
				.getSingleResult();
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		return admin;
	}

	

}
