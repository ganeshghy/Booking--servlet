package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.AddBookDao;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/insert")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	AddBookDao ab = new AddBookDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int  bookNo = Integer.parseInt(request.getParameter("bno"));
		String bookName = request.getParameter("bname");
		String author = request.getParameter("author");
		String language = request.getParameter("lan");
		float price =  Float.parseFloat(request.getParameter("price"));
		
		String result = ab.insertRecord(bookNo, bookName, author, language, price);
		PrintWriter out = response.getWriter();
		if(result.equalsIgnoreCase("success")) {
			out.println("Successfully added new record");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		else {
			out.println("can't add record,something wrong");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
	}

}
