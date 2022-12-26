package com.example.db_servlets;
import java.io.*;
import java.sql.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "DbServlet2", value = "/book-2")
public class DbServlet2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        ResultSet resultSet = Util.getResultSet("SELECT * FROM books");
        try {
            out.println("<html><body>");
            while(resultSet.next()) {
                out.println("<p>" + resultSet.getString("title") +
                        " : " + resultSet.getString("author") + "</p>");
            }
            out.println("</body></html>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConnectionClose.close();
    }
}
