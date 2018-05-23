package es.upm.dit.isst.docapp.dao.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import es.upm.dit.isst.docapp.dao.model.Cita;

@Entity
public class Paciente implements Serializable {

	@Id
	private String email;
	private String password;
	private String name;
	private String urlfoto;
	
	@OneToMany(mappedBy = "paciente", fetch = FetchType.EAGER)//relacion para BBDD
	private List<Cita> miscitas;
	
	public Paciente() {
		
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

	public String getUrlfoto() {
		return urlfoto;
	}

	public void setUrlfoto(String urlfoto) {
		this.urlfoto = urlfoto;
	}

	public List<Cita> getMiscitas() {
		return miscitas;
	}

	public void setMiscitas(List<Cita> miscitas) {
		this.miscitas = miscitas;
	}
	

}
