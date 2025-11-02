package br.com.store.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/store";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    public static Connection connection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception exception) {
            throw new SQLException("Erro Connect SQL", exception);
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
