package com.hkgroups.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeLoader
 */
@WebServlet("/site")
public class HomeLoader extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeLoader() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		String page = request.getParameter("page");
		page = page.toLowerCase();
		switch (page) {
		case "home": {
			homepage(request, response);
		}
			break;
		default: {
			errorpage(request, response);
		}
			break;
		}
	}

	private void errorpage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("Error Page", "title");
		request.getRequestDispatcher("errorpage.jsp").forward(request, response);

	}

	private void homepage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("Lonely Developer Home page", "title");
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
