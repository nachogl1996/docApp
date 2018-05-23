package es.upm.dit.isst.docapp.servlets;

import java.io.IOException;

import javax.json.JsonObject;
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

@WebServlet("/PacienteObtenerJustificanteServlet")
public class PacienteObtenerJustificanteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int citaid = Integer.parseInt(req.getParameter("cita"));
		Cita cita = CitaDAOImplementation.getInstance().readCita(citaid);
		Paciente paciente = cita.getPaciente();
		ServletOutputStream sout = resp.getOutputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PdfDocument pdf = new PdfDocument(new PdfWriter(baos));
		Document document = new Document(pdf);
		Paragraph p = new Paragraph("Justificante medico para " + paciente.getName())
				.setFontSize(30);
		document.add(p);
		p = new Paragraph("Hospital La Paz")
				.setFontSize(20);
		document.add(p);
		p = new Paragraph("Desde La Paz confirmamos que el paciente "+ paciente.getName()+" ha acudido a nuestro centro en la siguiente fecha:")
				.setFontSize(12);
		document.add(p);
		List list = new List();
		ListItem item = new ListItem(cita.getDate());
		list.add(item);		
		document.add(list);		
		document.close();
		pdf.close();

		resp.setContentType("application/pdf");
		resp.setContentLength(baos.size());
		baos.writeTo(sout);
	}
}
