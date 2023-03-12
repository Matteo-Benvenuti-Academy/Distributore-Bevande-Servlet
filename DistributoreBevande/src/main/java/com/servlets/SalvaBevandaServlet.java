package com.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.Bevanda;
import com.models.dao.BevandaDao;

@WebServlet("/Salva")
public class SalvaBevandaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SalvaBevandaServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bevanda bevanda=new Bevanda();
		bevanda.setNome(request.getParameter("nome"));
		bevanda.setDescrizione(request.getParameter("descrizione"));
		bevanda.setGradoAlcolico(Float.parseFloat(request.getParameter("gradoAlcolico")));
		
		String redirect;
		try {
			BevandaDao.getIstanza().insert(bevanda);
			redirect="bevande.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			redirect="error.html";
		}
		
		response.sendRedirect(redirect);
	}

}
