package co.edu.poli.ejemplo1.servicio;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.poli.ejemplo1.vista.Principal;

public class Singleton {
    private static Singleton singleton;
    private Connection connection;
    private String lastError;

    private Singleton() throws Exception {
        
        try {
            Principal.cargarProperties();
            var url = Principal.getProps("jdbc.url");
            var user = Principal.getProps("jdbc.user");
            var password = Principal.getProps("jdbc.password");

            if (url == null || user == null || password == null) {
                throw new IOException("Faltan propiedades de conexión en config.properties");
            }

            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            lastError = "Error al conectar con la base de datos: " + e.getMessage();
            throw new Exception(lastError);
        }
    }

    public static synchronized Singleton getInstance() throws Exception {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public Connection getConnection() {
        return connection;
    }

    public String getLastError() {
        return lastError;
    }

    public void disconnect() throws SQLException {
        if (connection != null) {
            try {
                connection.close();
            } finally {
                connection = null;
                singleton = null;
            }
        }
    }
}