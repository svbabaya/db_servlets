package com.example.db_servlets;

import java.sql.SQLException;

public class ConnectionClose {
    public static void close() {
        try {
            Util.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
