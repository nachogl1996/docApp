package es.upm.dit.isst.docapp.dao.model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import es.upm.dit.isst.docapp.dao.model.Cita;
import es.upm.dit.isst.docapp.dao.model.Especialidad;

@Entity
public class Medico implements Serializable {

	
	@Id
	private String email;
	private String password;
	private String name;
	private String urlfoto;
	private String consulta; //Numero de consulta
	
	@ManyToOne //Para la BBDD
	private Especialidad especialidad; //Un medico tiene solo una especialidad
	
	@OneToMany(mappedBy = "medico", fetch = FetchType.EAGER)//relacion para BBDD
	private List<Cita> citasprogramadas;

	public Medico() {
			
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

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}
	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}


	public List<Cita> getCitasprogramadas() {
		return citasprogramadas;
	}

	public void setCitasprogramadas(List<Cita> citasprogramadas) {
		this.citasprogramadas = citasprogramadas;
	}
	
}
