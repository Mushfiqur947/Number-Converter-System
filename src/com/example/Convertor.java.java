package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Converter")
public class Convertor extends HttpServlet

    	{
	      protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	         {
	            System.out.println("some binary data hase been submitted");
	    
	            String user = request.getSession().getAttribute("CURRENT_USER").toString();
	            
	              System.out.println("session data: " + user);
	    
	            String input = request.getParameter("bin-number");
	    
	              System.out.println("user data: " + input);
	    
	              System.out.println("please enter a binary number : ");
	    
	             String binary;
	             int decimal;
	             String octal;
	             decimal = Integer.parseInt(input, 2);
	             octal = Integer.toOctalString(decimal);
	             String result = (" Decimal : " + decimal + "Octal : " + octal);
	             System.out.println(result);
	             
	      
	     	

	              request.getSession().setAttribute("CONVERTOR_RESULT", result);
	    
	            request.getSession().setAttribute("CONVERTER_RESULT", result);
	   
	            request.getRequestDispatcher("/WEB-INF/user-welcome.jsp").forward(request, response);
        	 }
        }