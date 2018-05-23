package es.upm.dit.isst.docapp.dao;


import java.util.List;

import es.upm.dit.isst.docapp.dao.model.Admin;

public interface AdminDAO {

	public void createAdmin (Admin admin);
	public Admin readAdmin (String email);
	public void updateAdmin (Admin admin);
	public void deleteAdmin (Admin admin);
	
	public List<Admin>readAllAdmin();
	public Admin loginAdmin(String email, String password);
	
}