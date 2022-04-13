package com.example;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


 // A simple HTTP web application to accept username and password using the POST method.

@WebServlet("/Login")
public class Login extends HttpServlet {

	private Authenticator authenticator = null;
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Get request parameters for username and password
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");

		
		authenticator = new Authenticator(uname, pwd);

		if (authenticator.authenticateUser()) {
			// Add variable to session cookie
			request.getSession().setAttribute("CURRENT_USER", authenticator.getUsername());
			
			// Session cookie becomes invalid after 10s
			request.getSession().setMaxInactiveInterval(10); 
			
			request.getRequestDispatcher("/WEB-INF/user-welcome.jsp").forward(request, response);
		} else {
			request.setAttribute("error", authenticator.getAuthenticationMessage());
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
} 
