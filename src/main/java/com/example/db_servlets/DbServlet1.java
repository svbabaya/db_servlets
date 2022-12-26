package com.example.db_servlets;

import java.io.*;
import java.sql.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "DbServlet1", value = "/book-1")
public class DbServlet1 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        ResultSet resultSet = Util.getResultSet("SELECT * FROM books");
        try {
            out.println("<html><body>");
            while(resultSet.next()) {
                out.println("<p>" + resultSet.getString("id") +
                        " : " + resultSet.getString("quantity") + "</p>");
            }
            out.println("</body></html>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConnectionClose.close();
    }
}