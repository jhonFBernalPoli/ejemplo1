package co.poli.edu.ejemplo1.servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Singleton {
    private static Singleton singleton;
    private Connection connection;

    private Singleton() {
        Properties properties = new Properties();
        try {
            String url = properties.getProperty("jdbc.url");
            String user = properties.getProperty("jdbc.user");
            String password = properties.getProperty("jdbc.password");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("conexión DB establecida");
        } catch (SQLException e) {
            e.getMessage();
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
                e.getMessage();
            }
        }
    }
}