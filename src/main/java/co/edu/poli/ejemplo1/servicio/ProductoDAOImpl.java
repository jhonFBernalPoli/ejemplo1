package co.edu.poli.ejemplo1.servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.poli.ejemplo1.modelo.Comestible;
import co.edu.poli.ejemplo1.modelo.Electronico;
import co.edu.poli.ejemplo1.modelo.Producto;
import co.edu.poli.ejemplo1.vista.Principal;

/**
 * 
 */
public class ProductoDAOImpl implements GestorElementoDAO<Producto>, GestionProductoDAO {

    private Producto producto;
	private Connection connection;
    private ComestibleDAOImpl comestible;
    private ElectronicoDAOImpl electronico;

    public ProductoDAOImpl() {
        try {
            connection = Singleton.getInstance().getConnection();
        } catch (Exception e) {
            System.out.println("Error al obtener la instancia de Singleton: " + e.getMessage());
            // Maneja el error adecuadamente
        }
    }

    @Override
    public String createElemento(Producto elemento) {

        producto = elemento;
        if(this.readElemento(producto.getId()) == null){
            String sql = "INSERT INTO producto (id, descripcion, precio) VALUES (?, ?, ?)";

            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setInt(1, Integer.parseInt(producto.getId()));
                pstmt.setString(2, producto.getDescripcion());
                pstmt.setDouble(3, producto.getPrecio());
                pstmt.executeUpdate();

                //Creando los datos del producto si es comestible o electronico
                if (producto instanceof Comestible) {
                    System.out.println("si es comestible");
                    comestible.createElemento((Comestible) elemento);
                }else if (producto instanceof Electronico) {
                    System.out.println("si es electronico");
                    electronico.createElemento((Electronico) elemento);
                }else {
                    System.out.println("El producto no es comestible no electronico");
                }
                return "Producto " + producto.getId() + " creado exitosamente";
            } catch (SQLException e) {
                e.printStackTrace();
                return "Error al crear el producto";
            }
        }else{
            return "El producto " + this.readElemento(producto.getId()).getDescripcion() + " ya existe, no se puede insertar";
        }
    }

    @Override
    public List<Producto> listAllElementos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto";

        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");
                Producto producto = new Producto(id, descripcion, precio); // Inicializa el objeto Producto con argumentos
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public Producto readElemento(String id) {
        String sql = "SELECT * FROM producto WHERE id = ?";
        Producto producto = null;

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                producto = new Producto(String.valueOf(rs.getInt("id")), 
                rs.getString("descripcion"), 
                rs.getDouble("precio")); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public String updateElemento(String id, Producto elemento) {
        producto = elemento;

        String sql = "UPDATE producto SET descripcion = ?, precio = ? WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, producto.getDescripcion());
            pstmt.setDouble(2, producto.getPrecio());
            pstmt.setInt(3, Integer.parseInt(id));
            pstmt.executeUpdate();
            
            //Insertando el tipo de producto
            
            return "Producto actualizado exitosamente";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al actualizar el producto";
        }
    }

    @Override
    public Producto deleteElemento(String id) {
        String sql = "DELETE FROM producto WHERE id = ?";
        Producto producto = (Producto) readElemento(id);

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.parseInt(id));
            pstmt.executeUpdate();
            return producto;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Producto> FilterByPrecio(double desde, double hasta) {

        List<Producto> productos = new ArrayList<>();
        Principal.cargarProperties();
        String sql = Principal.getProps("sql.select").replace("{elemento}", "producto").concat(" WHERE precio BETWEEN ? AND ?");

        try (PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setDouble(1, desde);
            pstmt.setDouble(2, hasta);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");
                Producto producto = new Producto(id, descripcion, precio); // Inicializa el objeto Producto con argumentos
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

}