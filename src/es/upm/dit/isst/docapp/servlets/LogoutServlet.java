package es.upm.dit.isst.docapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("terminar") != null) {
			req.getSession().setAttribute("paciente", null);
			req.getSession().setAttribute("medico", null);
			req.getSession().setAttribute("suplantacion", null);
			resp.sendRedirect(req.getContextPath() + "/LoginAdmin.jsp");
			
		} else {
			req.getSession().invalidate();
			resp.sendRedirect(req.getContextPath() + "/index");
		}
		
	}

}
