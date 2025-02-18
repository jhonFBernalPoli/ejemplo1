package co.poli.edu.ejemplo1.servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
    private static Singleton singleton;
    private Connection connection;

    private Singleton() {
        try {
            String url = "jdbc:mysql://localhost:3306/ejemplodb";
            String user = "EjemploUser";
            String password = "Ejemplo123.";
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("conexión DB establecida");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public Connection getConnection() {
        return connection;
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                singleton = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}