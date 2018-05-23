package es.upm.dit.isst.docapp.dao.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.persistence.*;
import es.upm.dit.isst.docapp.dao.model.Medico;
import es.upm.dit.isst.docapp.dao.model.Paciente;

@Entity
public class Cita implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String date; //Formato yyyy/MM/dd HH:mm
	private String detail;
	private int status; // 0 si verde(libre) en calendario, 
	//1 si rojo(asignada), 
	//2 si paciente confirma llegada, 
	//3 si medico inicia cita, 
	//4 fin cita
	@ManyToOne //Para la BBDD	
	private Medico medico;
	@ManyToOne //Para la BBDD	
	private Paciente paciente;
	
	
	
		
		
	public Cita() {
		
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDate() {
		return this.date;
		
	}



	public void setDate(String date) {
		this.date = date;
		
	}
	
	public Date getformatDate()  {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date fecha = new Date();
		try {
			fecha  = formato.parse(this.date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ha habido un error al cambiar de string a sql.date");
		}
		return  fecha; //new java.util.Date(this.date.getTime());
		
	}



	public void setformatDate(Date date) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		this.date = formato.format(date);
	}	

	public String getDetail() {
		return detail;
	}



	public void setDetail(String detail) {
		this.detail = detail;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public Medico getMedico() {
		return medico;
	}



	public void setMedico(Medico medico) {
		this.medico = medico;
	}



	public Paciente getPaciente() {
		return paciente;
	}



	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}
