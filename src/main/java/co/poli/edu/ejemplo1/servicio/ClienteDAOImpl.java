package co.poli.edu.ejemplo1.servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.poli.edu.ejemplo1.modelo.Cliente;
import co.poli.edu.ejemplo1.vista.Principal;

/**
 * 
 */
public class ClienteDAOImpl implements GestorElementoDAO<Cliente> {
    
    private Cliente cliente;
    private Connection connection;

    public ClienteDAOImpl() {
        try {
            connection = Singleton.getInstance().getConnection();
        } catch (Exception e) {
            System.out.println("Error al obtener la instancia de Singleton: " + e.getMessage());
            // Maneja el error adecuadamente
        }
    }

    @Override
    public String createElemento(Cliente elemento) {
    	cliente = elemento;

        if(this.readElemento(cliente.getId()) == null){
            String sql = "INSERT INTO cliente (id, nombre) VALUES (?, ?)";

            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setInt(1, Integer.parseInt(cliente.getId()));
                pstmt.setString(2, cliente.getNombre());
                pstmt.executeUpdate();
                return "Cliente " + cliente.getId() + " creado exitosamente";
            } catch (SQLException e) {
                e.printStackTrace();
                return "Error al crear el cliente";
            }
        }else{
            return "El cliente " + this.readElemento(cliente.getId()).getNombre() + " ya existe, no se puede insertar";
        }
        
    }

    @Override
    public List<Cliente> listAllElementos() {
    	List<Cliente> clientes = new ArrayList<>();

        Principal.cargarProperties();
        String sql = Principal.getProps("sql.select").replace("{elemento}", "cliente");

        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
            	 String id = String.valueOf(rs.getInt("id"));
                 String nombre = rs.getString("nombre");
                 Cliente cliente = new Cliente(id, nombre); // Inicializa el objeto Cliente con argumentos
                 clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public Cliente readElemento(String id) {
    	String sql = "SELECT * FROM cliente WHERE id = ?";
        Cliente cliente = null;

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente(String.valueOf(rs.getInt("id")), 
                rs.getString("nombre")); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public String updateElemento(String id, Cliente elemento) {
    	cliente = elemento;
        String sql = "UPDATE cliente SET nombre = ? WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getNombre());
            pstmt.setInt(2, Integer.parseInt(id));
            pstmt.executeUpdate();
            return "Cliente actualizado exitosamente";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al actualizar el cliente";
        }
    }

    @Override
    public Cliente deleteElemento(String id) {
    	String sql = "DELETE FROM cliente WHERE id = ?";
        cliente = readElemento(id);

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.parseInt(id));
            pstmt.executeUpdate();
            return cliente;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}