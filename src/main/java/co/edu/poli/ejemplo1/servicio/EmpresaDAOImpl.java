/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package co.edu.poli.ejemplo1.servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import co.edu.poli.ejemplo1.modelo.Departamento;
import co.edu.poli.ejemplo1.modelo.Empleado;

public class EmpresaDAOImpl {
    private static final String URL = "jdbc:mysql://localhost:3306/empresa_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public void guardarEmpleadoYDepartamento(Empleado empleado, Departamento departamento) {
        String sqlEmpleado = "INSERT INTO empleados (nombre, puesto) VALUES (?, ?)";
        String sqlDepartamento = "INSERT INTO departamentos (nombre) VALUES (?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmtEmpleado = connection.prepareStatement(sqlEmpleado);
             PreparedStatement pstmtDepartamento = connection.prepareStatement(sqlDepartamento)) {

            // Insertar el empleado
            pstmtEmpleado.setString(1, empleado.getNombre());
            pstmtEmpleado.setString(2, empleado.getPuesto());
            pstmtEmpleado.executeUpdate();

            // Insertar el departamento
            pstmtDepartamento.setString(1, departamento.getNombre());
            pstmtDepartamento.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

