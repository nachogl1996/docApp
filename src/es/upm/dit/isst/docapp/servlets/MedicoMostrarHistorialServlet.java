package es.upm.dit.isst.docapp.servlets;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;

import es.upm.dit.isst.docapp.dao.CitaDAOImplementation;
import es.upm.dit.isst.docapp.dao.model.Cita;
import es.upm.dit.isst.docapp.dao.model.Paciente;

import java.io.IOException;

import javax.json.*;

@WebServlet("/MedicoMostrarHistorialServlet")
public class MedicoMostrarHistorialServlet extends HttpServlet {
	JsonObject value = Json.createObjectBuilder()
		     .add("Nombre", "Paciente")
		     .add("Apellido", "Paciente")
		     .add("edad", "25")
		     .add("altura", "182cm")
		     .add("direccion", Json.createObjectBuilder()
		         .add("calle", "21 2nd Street")
		         .add("ciudad", "New York")
		         .add("estado", "NY")
		         .add("CP", "10021"))
		     .add("phoneNumber", Json.createObjectBuilder()
	             .add("type", "home")
	             .add("number", "212 555-1234"))
	         .add("datos medicos", Json.createObjectBuilder()
			         .add("grupo", "A+")
			         .add("al", "Polen, Acaros"))
	         .add("Historia", Json.createObjectBuilder()
			         .add("in1", "Apendicitis el 20 de Enero del 2000")
			         .add("in2", "Lesion en el femur el 10 de Marzo del 2017"))
		     .build();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cita cita = (Cita) req.getSession().getAttribute("citadetalle");
		Paciente paciente = cita.getPaciente();
		//peticion historialcentromedico?paciente=emailpaciente
		ServletOutputStream sout = resp.getOutputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PdfDocument pdf = new PdfDocument(new PdfWriter(baos));
		Document document = new Document(pdf);
		Paragraph p = new Paragraph("Historial medico de " + paciente.getName())
				.setFontSize(30);
		document.add(p);
		p = new Paragraph("Datos personales")
				.setFontSize(20);
		document.add(p);
		List list = new List();
		ListItem item = new ListItem("Edad: "+ value.getString("edad")+", altura: "+value.getString("altura"));
		list.add(item);
		JsonObject tlfno = value.getJsonObject("phoneNumber");
		item = new ListItem("Telefono-> tipo: "+tlfno.getString("type")+", numero: "+tlfno.getString("number"));
		list.add(item);
		document.add(list);
		p = new Paragraph("Direccion")
				.setFontSize(15);
		document.add(p);
		list = new List();
		JsonObject direccion = value.getJsonObject("direccion");
		item = new ListItem("Calle: "+direccion.getString("calle"));
		list.add(item);
		item = new ListItem("Ciudad: "+direccion.getString("ciudad"));
		list.add(item);
		item = new ListItem("Estado: "+direccion.getString("estado"));
		list.add(item);
		item = new ListItem("Codigo Postal: "+direccion.getString("CP"));
		list.add(item);		
		document.add(list);
		
		p = new Paragraph("Datos Medicos")
				.setFontSize(20);
		document.add(p);
		list = new List();
		JsonObject dmed = value.getJsonObject("datos medicos");
		item = new ListItem("Grupo sanguineo: "+dmed.getString("grupo"));
		list.add(item);
		item = new ListItem("Alergias: "+dmed.getString("al"));
		list.add(item);
		document.add(list);
		
		p = new Paragraph("HISTORIA")
				.setFontSize(23);
		document.add(p);
		list = new List();
		JsonObject hist = value.getJsonObject("Historia");
		item = new ListItem("Incidencia 1: "+hist.getString("in1"));
		list.add(item);
		item = new ListItem("Incidencia 2: "+hist.getString("in2"));
		list.add(item);
		document.add(list);
		document.close();
		pdf.close();

		resp.setContentType("application/pdf");
		resp.setContentLength(baos.size());
		baos.writeTo(sout);
	}
	
}
