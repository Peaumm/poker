package project.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Bddconnection {
    private static final String URL = "jdbc:mysql://localhost:3306/poker";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection connection;

    // Constructeur privé pour empêcher l'instanciation
    private Bddconnection() {}

    // Méthode pour obtenir la connexion
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
}