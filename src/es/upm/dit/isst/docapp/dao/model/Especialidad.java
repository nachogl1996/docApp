package es.upm.dit.isst.docapp.dao.model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import es.upm.dit.isst.docapp.dao.model.Medico;

@Entity
public class Especialidad implements Serializable {

	@Id
	private String name;
	private String description;
	private String urlfoto;
	
	@OneToMany(mappedBy = "especialidad", fetch = FetchType.EAGER)//relacion para BBDD
	private List<Medico> medicos;
	
	public Especialidad() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlfoto() {
		return urlfoto;
	}

	public void setUrlfoto(String urlfoto) {
		this.urlfoto = urlfoto;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	
	
}