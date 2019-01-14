package com.JairoBurgos.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JairoBurgos.models.Check;

/**
 * Servlet implementation class process
 */
@WebServlet("/process")
public class process extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public process() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String resetButton="<h5><a href=\"reset\" class=reset><button type=button>Play Again</button></a></h5>";
		
		int random = (int) session.getAttribute("random");
		Check check = new Check(random,Integer.parseInt(request.getParameter("guess")));
		System.out.println(random);
		
		if (check.checkGuess().equals("found")) {
			String text = random +" was the number!";
			session.setAttribute("reset",resetButton );
			session.setAttribute("text", text);
		}
		
		if (check.checkGuess().equals("low")){
			String text = "Too low!";
			session.setAttribute("text", text);
		}
		
		if (check.checkGuess().equals("high")) {
			String text = "Too High!";
			session.setAttribute("text", text);
		}
		
		session.setAttribute("box", check.checkGuess());
		response.sendRedirect("start");
		
		
	}

}
