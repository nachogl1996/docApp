package es.upm.dit.isst.docapp.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
public class Admin implements Serializable {

	@Id
	private String email;
	private String password;
	private String name;

	public Admin() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}