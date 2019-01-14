package com.JairoBurgos.UserInformation.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String favLanguage = request.getParameter("language");
		String homeTown = request.getParameter("hometown");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		if (homeTown == null) {
			homeTown = "Unknown";
		}
		if(favLanguage == null) {
			favLanguage = "Unknown";
		}
		if (firstName == null) {
			homeTown = "Unknown";
		}
		if(lastName == null) {
			favLanguage = "Unknown";
		}
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<h1>Welcome, "+firstName+" "+lastName+"</h1>"
				+"<p> Your favorite language is: "+favLanguage+"</p>"
				+"<p> Your hometown is: "+homeTown+"</p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
