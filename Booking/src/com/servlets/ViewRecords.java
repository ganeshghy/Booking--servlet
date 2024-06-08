package com.servlets;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.Book;

@WebServlet("/ViewRecords")
public class ViewRecords extends HttpServlet {
    private static final long serialVersionUID = 1L;

   

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Book> books = fetchBookingsFromDatabase();

        // Set the bookings as an attribute in the request
        request.setAttribute("books", books);

        // Forward the request to the JSP page
        request.getRequestDispatcher("viewRecords.jsp").forward(request, response);
    }

    private List<Book> fetchBookingsFromDatabase() {
        List<Book> books = new ArrayList<>();

        try {
        	String query = "jdbc:mysql://localhost:3306/servlet";
        	String user = "root";
        	String pwd = "root";
        		
        	Connection connection = DriverManager.getConnection(query,user,pwd);
            String sql = "SELECT bno, bname, author, lan, price FROM booking";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(); 

            while (resultSet.next()) {
                int bno = resultSet.getInt("bno");
                String bname = resultSet.getString("bname");
                String author = resultSet.getString("author");
                String language = resultSet.getString("lan");
                float price = resultSet.getFloat("price");

                Book b1 = new Book(bno, bname, author, language, price);
                books.add(b1);
                }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }
}

