package com.hkgroups.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.hkgroups.adapter.UsersAdapter;
import com.hkgroups.dataresources.UsersData;

/**
 * Servlet implementation class Operations
 */
@WebServlet("/operations")
public class Operations extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/project")
	private DataSource dataSource;
	
	public Operations() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = request.getParameter("page");
		page = page.toLowerCase();
		switch (page) {
		case "adduser": {
			adduserpage(request, response);
		}
			break;
		case "userlist" : {userlists(response,request);}
		break;
		default: {
			errorpage(request, response);
		}
			break;
		}
	}

	private void userlists(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		List<UsersData> userlist = new ArrayList<UsersData>();
		userlist = new UsersAdapter().dataList(dataSource);
		request.setAttribute("userlist", userlist);
		request.setAttribute("Users Data List", "title");
		request.getRequestDispatcher("userlisting.jsp").forward(request, response);
		
	}

	private void errorpage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("Error 404 Page", "title");
		request.getRequestDispatcher("errorpage.jsp").forward(request, response);

	}

	private void adduserpage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("Add User's Page", "title");
		request.getRequestDispatcher("addusers.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
