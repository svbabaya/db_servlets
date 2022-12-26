package com.example.db_servlets;
import java.sql.*;
public class Util {
    private static Connection connection;
    private static Statement statement;
    public static ResultSet getResultSet(String str) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_db",
                    "postgres", "postgres");
            statement = connection.createStatement();
            return statement.executeQuery(str);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        Util.connection = connection;
    }

    public static Statement getStatement() {
        return statement;
    }

    public static void setStatement(Statement statement) {
        Util.statement = statement;
    }
}
