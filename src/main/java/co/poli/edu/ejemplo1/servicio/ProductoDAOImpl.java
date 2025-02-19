package co.poli.edu.ejemplo1.servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.poli.edu.ejemplo1.modelo.Producto;

/**
 * 
 */
public class ProductoDAOImpl implements GestorElementoDAO {
	private Connection connection = Singleton.getInstance().getConnection();

    @Override
    public String createElemento(Object elemento) {
        Producto producto = (Producto) elemento;
        String sql = "INSERT INTO producto (idproducto, descripcion, precio) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.parseInt(producto.getId()));
            pstmt.setString(2, producto.getDescripcion());
            pstmt.setDouble(3, producto.getPrecio());
            pstmt.executeUpdate();
            return "Producto " + producto.getId() + " creado exitosamente";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al crear el producto";
        }
    }

    @Override
    public List<Object> listAllElementos() {
        List<Object> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto";

        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String id = String.valueOf(rs.getInt("idproducto"));
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
    public Object readElemento(String id) {
        String sql = "SELECT * FROM producto WHERE idproducto = ?";
        Producto producto = null;

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                producto = new Producto(String.valueOf(rs.getInt("idproducto")), rs.getString("descripcion"), rs.getDouble("precio")); // Inicializa el objeto Producto con argumentos
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public String updateElemento(String id, Object elemento) {
        Producto producto = (Producto) elemento;
        String sql = "UPDATE producto SET descripcion = ?, precio = ? WHERE idproducto = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, producto.getDescripcion());
            pstmt.setDouble(2, producto.getPrecio());
            pstmt.setInt(3, Integer.parseInt(id));
            pstmt.executeUpdate();
            return "Producto actualizado exitosamente";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al actualizar el producto";
        }
    }

    @Override
    public Object deleteElemento(String id) {
        String sql = "DELETE FROM producto WHERE idproducto = ?";
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

}